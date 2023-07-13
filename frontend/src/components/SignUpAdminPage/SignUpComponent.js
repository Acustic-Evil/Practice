/*
import React, {useState, useEffect} from 'react';
import styles from './sign_up.css';
// import SignUpService from "./services/SignUpService";


function SignUpComponent() {

    const [admins, setAdmins] = useState([])

    useEffect(() => {
        getAdmins()
    }, [])

    const getAdmins = () => {
        SignUpService.getAdmins().then((response) => {
            setAdmins(response.data)
            console.log(response.data);
        });
    };

    return (
        <>
            <header>
                <h1>Admin Page - Add New Admins</h1>
                <div>
                    <a href="/admin">
                        <button>Admin</button>
                    </a>
                    <a href="/">
                        <button> Main page</button>
                    </a>
                    {/!*<a href="/logout">
                        <button>Log out</button>
                    </a>*!/}
                </div>
            </header>
            <div className="intro"></div>
            <main>
                <form action="/admin/sign_up" method="post">
                    <p>Регистрация администратора</p>
                    <label>
                        <input type="text" placeholder="Введите никнейм" name="username"/>
                    </label>
                    <label>
                        <input type="password" placeholder="Введиете пароль" name="password"/>
                    </label>
                    <span className="button-container">
                        <button type="submit">Зарегистрировать</button>
                    </span>
                </form>
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        admins.map(
                            admin =>
                                <tr key={admin.id}>
                                    <td>{admin.id}</td>
                                    <td>{admin.username}</td>
                                    <td><a><button>❌</button></a></td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </main>
        </>
    )
}

export default SignUpComponent*/
