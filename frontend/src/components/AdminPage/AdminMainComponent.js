import React, {useState, useEffect} from 'react';
import styles from './admin.css';
import AdminService from "./services/AdminService";

function AdminMainComponent() {
    const [instruments, setInstruments] = useState([])

    useEffect(() => {
        getInstruments()
    }, [])

    const getInstruments = () => {
        AdminService.getInstruments().then((response) => {
            setInstruments(response.data)
            console.log(response.data);
        });
    };

    return (
        <>
            <body className={styles.body}>
            <header className={styles.header}>
                <h1 className={styles.h1}>Admin Page - Bowed Musical Instruments</h1>
                <div>
                    <a className={styles.a} href="/admin/sign_up">
                        <button className={styles.headerButton}>Sign Up a new Admin</button>
                    </a>
                    <a className={styles.a} href="/">
                        <button className={styles.headerButton}> Main page</button>
                    </a>
                    {/*<a className={styles.a} href="/logout">
                        <button className={styles.headerButton}>Log out</button>
                    </a>*/}
                </div>
            </header>
            <main className={styles.main}>
                <section className={styles.section}>
                    <h2>Add Instrument</h2>
                    <form action="/admin/add_new_instrument" method="post">
                        <label className={styles.label} htmlFor="instrument_name">Instrument name:</label>
                        <input className={styles.input} type="text" id="instrument_name" name="instrument_name" required/>
                        <label className={styles.label} htmlFor="chord-name">Chord name:</label>
                        <input className={styles.input} type="text" id="chord-name" name="chord_name" required/>
                        <label className={styles.label} htmlFor="num_of_strings">Number of strings:</label>
                        <input className={styles.input} type="number" id="num_of_strings" name="num_of_strings" required/>
                        <label className={styles.label} htmlFor="factory_name">Factory name:</label>
                        <input className={styles.input} type="text" id="factory_name" name="factory_name" required/>
                        <label className={styles.label} htmlFor="factory_number">Factory number:</label>
                        <input className={styles.input} type="text" id="factory_number" name="factory_number" required/>
                        <button type="submit">Add</button>
                    </form>
                </section>
                <section className={styles.section}>
                    <h2>Instruments</h2>
                    <table className={styles.table}>
                        <thead>
                        <tr>
                            <th className={styles.th}>Id</th>
                            <th className={styles.th}>Name</th>
                            <th className={styles.th}>Number of strings</th>
                            <th className={styles.th}>Factory name</th>
                            <th className={styles.th}>Factory number</th>
                            <th className={styles.th}></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            instruments.map(
                                instrument =>
                                    <tr key={instrument.id}>
                                    <td className={styles.td}>{instrument.id}</td>
                                    <td className={styles.td}>{instrument.instrument_name}</td>
                                    <td className={styles.td}>{instrument.num_of_strings}</td>
                                    <td className={styles.td}>{instrument.factory_name}</td>
                                    <td className={styles.td}>{instrument.factory_number}</td>
                                    <td className={styles.td}>
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

export default AdminMainComponent