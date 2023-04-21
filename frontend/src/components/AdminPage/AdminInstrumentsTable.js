import React, {Component, useEffect, useState} from "react";
import MainService from "../MainPage/services/MainService";
import baseUrl from "../../base-url";
import axios from "axios";

function AdminInstrumentsTable() {
     const [instruments, setInstruments] = useState([])

     useEffect(() => {
         getInstruments()
         /*fetch(baseUrl + '/admin/main')
             .then(response => {
                 if(!response.ok){
                     throw new Error('Failed to fetch instruments');
                 }
                 return response.json();
             })
             .then(data => {
                 setInstruments(data);
             })
             .catch(error => {
                 console.error(error);
             });*/
     }, []);

     const getInstruments = () => {
         MainService.getInstruments().then((response) => {
             setInstruments(response.data)
             console.log(response.data);
         });
     };

     const handleDelete = id => {
         axios.delete(baseUrl + `/admin/delete_instrument/${id}`, id)
             .then(response => {
                 console.log(response);
             })
             .catch(error => {
                 console.log(error);
             });
     };

    return (
        <>
            <section>
                <h2>Instruments</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Number of strings</th>
                        <th>Factory name</th>
                        <th>Factory number</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        instruments.map(
                            instrument =>
                                <tr key={instrument.id}>
                                    <td>{instrument.id}</td>
                                    <td>{instrument.instrument_name}</td>
                                    <td>{instrument.num_of_strings}</td>
                                    <td>{instrument.factory_name}</td>
                                    <td>{instrument.factory_number}</td>
                                    <td>
                                        <a>
                                            <button>✏️</button>
                                        </a>
                                        <a>
                                            <button onClick={() => handleDelete(instrument.id)}>❌</button>
                                        </a>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </section>
        </>
    )

}

export default AdminInstrumentsTable;