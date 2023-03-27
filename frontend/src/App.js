import React, { useState, useEffect } from 'react';

function InstrumentList() {
    const [instruments, setInstruments] = useState([]);

    useEffect(() => {
        fetch('/api/instruments')
            .then(response => response.json())
            .then(data => setInstruments(data));
    }, []);

    return (
        <div>
            <h2>Instrument List</h2>
            <ul>
                {instruments.map(instrument => (
                    <li key={instrument.id}>{instrument.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default InstrumentList;
