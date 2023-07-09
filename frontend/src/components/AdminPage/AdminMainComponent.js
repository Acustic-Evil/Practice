import React, {useState} from 'react';
import AdminInstrumentsForm from './AdminInstrumentsForm';
import AdminInstrumentTable from './AdminInstrumentsTable';

function AdminMainComponent() {

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
                {/*<AdminInstrumentsForm onInstrumentAdded={handleInstrumentAdded} />*/}
                <AdminInstrumentTable/>
            </main>
        </>
    );
}

export default AdminMainComponent;