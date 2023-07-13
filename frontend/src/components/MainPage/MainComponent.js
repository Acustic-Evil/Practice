import React, {useState, useEffect} from 'react'
import styles from './index.css'
import backend from "../../backend";

function MainComponent() {
    const [instruments, setInstruments] = useState([]);

    useEffect(() => {
        const fetchInstrumentData = async () => {
            const data = await backend.Main.fetchInstruments();
            setInstruments(data);
        };

        fetchInstrumentData();
    }, []);


    return (
        <>
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
            <main>
                <p>Welcome to our website! Please select an instrument and a chord to listen to.</p>
                <section>
                    <h2>Select an Instrument and Chord</h2>
                    <div className= "selectContainer">
                        <label htmlFor="instrument"></label>
                        <select id="instrument">
                            {instruments.map(
                                instrument =>
                                    <option value={instrument.instrument_name}>{instrument.instrument_name}</option>
                            )}
                        </select>
                        <label htmlFor="chord"></label>
                        <select id="chord">
                            <option value="">Select a chord</option>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">D</option>
                            <option value="E">E</option>
                            <option value="F">F</option>
                            <option value="G">G</option>
                        </select>
                        <div>
                            <button onClick={playSound}>Play</button>
                        </div>
                    </div>
                    <div id="alert"></div>
                </section>
                <section>
                    <h2>Photo Gallery</h2>
                    {<div className= "gallery-container">
                        <img src={require('.//Violin.webp')} alt="Gallery Image 1"/>
                    </div>}
                </section>
            </main>
        </>
    )
}

function playSound() {
    const instrument = document.getElementById('instrument').value;
    console.log(instrument);

    const chord = document.getElementById('chord').value;
    console.log(chord);

    if (!instrument || !chord) {
        alert('Please select an instrument and a chord');
        return;
    }

    const alertBox = document.getElementById('alert');
    alertBox.textContent = `Playing ${chord} chord on ${instrument}`;
    alertBox.style.opacity = 1;

    setTimeout(() => {
        alertBox.style.opacity = 0;
    }, 3000);
}


export default MainComponent