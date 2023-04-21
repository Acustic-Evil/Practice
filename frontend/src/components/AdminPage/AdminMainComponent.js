import React, {useEffect, useState} from 'react';
import AdminInstrumentsForm from './AdminInstrumentsForm';
import AdminInstrumentTable from './AdminInstrumentsTable';
import axios from "axios";
import baseUrl from "../../base-url";

function AdminMainComponent() {
    const [instruments, setInstruments] = useState([]);

    useEffect(() => {
        axios.get(baseUrl + '/admin/main')
            .then(response => {
                setInstruments(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

    return (
        <>
            <header>
                <h1>Admin Page - Bowed Musical Instruments</h1>
                <div>
                    <a href="/admin/sign_up">
                        <button>Sign Up a new Admin</button>
                    </a>
                    <a href="/">
                        <button> Main page</button>
                    </a>
                    {/*<a className={styles.a} href="/logout">
                        <button className={styles.headerButton}>Log out</button>
                    </a>*/}
                </div>
            </header>
            <main>
                <AdminInstrumentsForm />
                <AdminInstrumentTable />
            </main>
        </>
    );
}

export default AdminMainComponent;