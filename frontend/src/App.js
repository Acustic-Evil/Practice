import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainComponent from "./components/MainPage/MainComponent";
import AdminMainComponent from "./components/AdminPage/AdminMainComponent";
import InstrumentEdit from "./components/AdminPage/InstrumentEdit";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<MainComponent/>}/>
                <Route path='/admin' element={<AdminMainComponent/>}/>
                <Route path='/admin/edit_instrument/:id' element={<InstrumentEdit/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;