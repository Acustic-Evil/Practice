import React, {useState, useEffect} from 'react'
import './admin.css'
import MainService from "/services/MainService";

function MainComponent() {
    const [instruments, setInstruments] = useState([])

    useEffect(() => {
        getInstruments()
    }, [])

    const getInstruments = () => {
        MainService.getInstruments().then((response) => {
            setInstruments(response.data)
            console.log(response.data);
        });
    };

    return (
        <>
            <body>
            <header>
                <h1>Admin Page - Bowed Musical Instruments</h1>
                <div>
                    <a href="/admin/sign_up">
                        <button>Sign Up a new Admin</button>
                    </a>
                    <a href="/">
                        <button> Main page</button>
                    </a>
                    <a href="/logout">
                        <button>Log out</button>
                    </a>
                </div>
            </header>
            <main>
                <section>
                    <h2>Add Instrument</h2>
                    <form action="/admin/add_new_instrument" method="post">
                        <label htmlFor="instrument_name">Instrument name:</label>
                        <input type="text" id="instrument_name" name="instrument_name" required/>
                        <label htmlFor="chord-name">Chord name:</label>
                        <input type="text" id="chord-name" name="chord_name" required/>
                        <label htmlFor="num_of_strings">Number of strings:</label>
                        <input type="number" id="num_of_strings" name="num_of_strings" required/>
                        <label htmlFor="factory_name">Factory name:</label>
                        <input type="text" id="factory_name" name="factory_name" required/>
                        <label htmlFor="factory_number">Factory number:</label>
                        <input type="text" id="factory_number" name="factory_number" required/>
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
                                            <button>✏️</button>
                                        </a>
                                        <a>
                                            <button>❌</button>
                                        </a>
                                    </td>
                                </tr>
                            )

                        }

                        </tbody>
                    </table>
                </section>
            </main>
            </body>
        </>
    )

}

export default MainComponent