import React, {useState, useEffect} from 'react'
import './index.css'
import './Violin.webp'
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
                    <a href="/api/admin/main">
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
                    <div className="select-container">
                        <label htmlFor="instrument"></label>
                        <select>
                            {instruments.map(
                                instrument =>
                                    <option id={instrument} key={instrument.id}
                                            value={instrument.instrument_name}>{instrument.instrument_name}</option>
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
                    {/*<div className="gallery-container">
                        <img src="/Violin.webp" alt="Gallery Image 1"/>
                    </div>*/}
                </section>
            </main>
            </body>
        </>
    )
}

function playSound() {
    const instrument = document.getElementById('instrument').value;
    const chord = document.getElementById('chord').value;

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