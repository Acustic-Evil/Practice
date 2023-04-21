import axios from "axios";
import React, {useState} from "react";
import baseUrl from "../../base-url";

function AdminInstrumentsForm() {

    const [instrument_name, setInstrument_name] = useState('');
    const [num_of_strings, setNum_of_strings] = useState('');
    const [factory_name, setFactory_name] = useState('');
    const [factory_number, setFactory_number] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = {
            instrument_name: instrument_name,
            num_of_strings: parseInt(num_of_strings),
            factory_name: factory_name,
            factory_number: factory_number
        };
        axios.post(baseUrl + '/admin/add_new_instrument', data)
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            });
    }

    const handleInstrumentNameChange = (event) => {
        setInstrument_name(event.target.value);
    }


    const handleNumberOfStringsChange = (event) => {
        setNum_of_strings(event.target.value);
    }

    const handleFactoryNameChange = (event) => {
        setFactory_name(event.target.value);
    }

    const handleFactoryNumberChange = (event) => {
        setFactory_number(event.target.value);
    }

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
        </>
    )
}

export default AdminInstrumentsForm;