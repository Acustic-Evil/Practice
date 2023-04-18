import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainComponent from "./components/MainPage/MainComponent";
import AdminMainComponent from "./components/AdminPage/AdminMainComponent";
import SignUpComponent from "./components/SignUpAdminPage/SignUpComponent";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<MainComponent/>}/>
                <Route path='/admin' element={<AdminMainComponent/>}/>
                <Route path='/admin/sign_up' element={<SignUpComponent/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;