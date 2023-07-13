import React, {useEffect, useState} from "react";
import backend from "../../backend";
import {useNavigate} from "react-router-dom";
import styles from "./admin.css"

function AdminInstrumentsTable( ) {

    const [instruments, setInstruments] = useState([]);
    const navigate = useNavigate();

    let [instrument_name, setInstrument_name] = useState('');
    let [num_of_strings, setNum_of_strings] = useState('');
    let [factory_name, setFactory_name] = useState('');
    let [factory_number, setFactory_number] = useState('');



    useEffect(() => {
        fetchInstruments();
    }, []);


    const fetchInstruments = () => {
        backend.Admin.getInstruments()
            .then(data => {
                setInstruments(data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleDelete = id => {
        backend.Admin.deleteInstrument(id)
            .then(response => {
                console.log(response);
                fetchInstruments();
            })
            .catch(error => {
                console.log(error);
            });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = {
            instrument_name: instrument_name,
            num_of_strings: parseInt(num_of_strings),
            factory_name: factory_name,
            factory_number: factory_number
        };
        backend.Admin.submitNewInstrument(data)
            .then(response => {
                console.log(response);
                fetchInstruments();
            })
            .catch(error => {
                console.log(error);
                
            });
    };

    const handleUpdate = id => {
        navigate(`/admin/edit_instrument/${id}`)
    }

    const handleInstrumentNameChange = (event) => {
        setInstrument_name(event.target.value);
    };

    const handleNumberOfStringsChange = (event) => {
        setNum_of_strings(event.target.value);
    };

    const handleFactoryNameChange = (event) => {
        setFactory_name(event.target.value);
    };

    const handleFactoryNumberChange = (event) => {
        setFactory_number(event.target.value);
    };
    return (
        <>
            <section>
                <h2>Add Instrument</h2>
                <form onSubmit={handleSubmit}>
                    <label>Instrument name:
                        <input type="text" value={instrument_name}
                               onInput={handleInstrumentNameChange}
                               required/>
                    </label>
                    <label>Chord name:
                        <input type="text" required/>
                    </label>
                    <label>Number of strings:
                        <input type="number" value={num_of_strings}
                               onInput={handleNumberOfStringsChange}
                               required/>
                    </label>
                    <label>Factory name:
                        <input type="text" value={factory_name}
                               onInput={handleFactoryNameChange} required/>
                    </label>
                    <label>Factory number:
                        <input type="text" value={factory_number}
                               onInput={handleFactoryNumberChange}
                               required/></label>
                    <button type="submit">Add</button>
                </form>
            </section>
            <section>
                <h2>Instruments</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Number of strings</th>
                        <th>Factory name</th>
                        <th>Factory number</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        instruments.map(
                            instrument =>
                                <tr key={instrument.id}>
                                    <td>{instrument.id}</td>
                                    <td>{instrument.instrument_name}</td>
                                    <td>{instrument.num_of_strings}</td>
                                    <td>{instrument.factory_name}</td>
                                    <td>{instrument.factory_number}</td>
                                    <td>
                                        <a>
                                            <button onClick={() => handleUpdate(instrument.id)}>✏️</button>
                                        </a>
                                        <a>
                                            <button onClick={() => handleDelete(instrument.id)}>❌</button>
                                        </a>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </section>
        </>
    )

}

export default AdminInstrumentsTable;