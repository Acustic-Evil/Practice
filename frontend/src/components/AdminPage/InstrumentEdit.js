import React, {useEffect, useState} from 'react';
import backend from "../../backend";
import {useNavigate, useParams} from "react-router-dom";

function InstrumentEdit() {

    const [instrument, setInstrument] = useState('');
    const {id} = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        backend.Admin.getInstrumentById(id)
            .then(data => {
                setInstrument(data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);


    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.target;
        const data = {
            id: id,
            instrument_name: form.instrument_name.value,
            num_of_strings: parseInt(form.num_of_strings.value),
            factory_name: form.factory_name.value,
            factory_number: form.factory_number.value
        };
        backend.Admin.updateInstrument(data)
            .then(response => {
                console.log(response);
                navigate(`/admin`)
            })
            .catch(error => {
                console.log(error);
            })
    };

    return (
        <>
            <header>
                <h1>Admin Page - Edit instrument</h1>
                <div>
                    <a href="/admin">
                        <button>Admin</button>
                    </a>
                    <a href="/">
                        <button> Main page</button>
                    </a>
                </div>
            </header>
            <main>
                <form onSubmit={handleSubmit}>
                    <table>
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Instrument name</th>
                            <th>Number of strings</th>
                            <th>Factory name</th>
                            <th>Factory number</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr key={instrument.id}>
                            <td>{instrument.id}</td>
                            <td><input defaultValue={instrument.instrument_name}
                                       type="text" name="instrument_name" required/>
                            </td>
                            <td><input defaultValue={instrument.num_of_strings}
                                       type="number" name="num_of_strings" required/>
                            </td>
                            <td><input defaultValue={instrument.factory_name} type="text"
                                       name="factory_name" required/></td>
                            <td><input defaultValue={instrument.factory_number} type="text"
                                       name="factory_number" required/>
                            </td>
                            <td>
                                <button type="submit">✅</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </main>
        </>
    );
}

export default InstrumentEdit;
