import axios from "axios";
import baseUrl from "./base-url";

const validateStatus = status => (status >= 200 && status <= 300) || [500].includes(status);

export default {
    Admin: {
        submitNewInstrument: async (data) => {
            let response= await axios.post(baseUrl + '/admin/add_new_instrument', 
            data,
            {  
                validateStatus 
            });

            return response.data;
        },
        getInstruments: async() => {
            return axios
                .get(`${baseUrl}/admin/main`, { validateStatus })
                .then(response => response.data)
                .catch(error => {
                    console.error(error);
                    return [];
                });
        },
        deleteInstrument: async (id) => {
            return axios
                .delete(`${baseUrl}/admin/delete_instrument/${id}`, { validateStatus })
                .then(response => response.data)
                .catch(error => {
                    console.error(error);
                });
        }
    },
    Main: {
         fetchInstruments: async() => {
            try {
                const response = await axios.get('http://localhost:8080/api/main', { validateStatus }); // Update the URL to match your backend endpoint
                return response.data;
            } catch (error) {
                console.log(error);
                return [];
            }
        }

    }
}