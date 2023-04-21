import React, {useState} from "react";
import styles from "../AdminPage/admin.css";

function Header(props) {

    const [currentComponent, setCurrentComponent] = useState('Main');

    const renderHeader = () => {
        if (currentComponent === 'Main') {
            return (<>
                <header>
                    <h1>Bowed Musical Instruments</h1>
                    <div>
                        <a href="/admin">
                            <button>Admin</button>
                        </a>
                        {/*<a href="/logout">
                        <button>Log out</button>
                    </a>*/}
                    </div>
                </header>
            </>)
        } else if (currentComponent === 'Admin') {
            return (<>
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
            </>)
        } else if (currentComponent === 'SignUp') {
            return (<>
                <header>
                    <h1>Admin Page - Add New Admins</h1>
                    <div>
                        <a href="/admin">
                            <button>Admin</button>
                        </a>
                        <a href="/">
                            <button> Main page</button>
                        </a>
                        {/*<a href="/logout">
                        <button>Log out</button>
                    </a>*/}
                    </div>
                </header>
            </>)
        }
    }
}
export default Header;