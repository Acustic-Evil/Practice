import axios from "axios";
import baseUrl from "./base-url";

export default {
    Admin: {
        submitNewInstrument: async (data) => {
            let response= await axios.post(baseUrl + '/admin/add_new_instrument', data)
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                })
            return response.data;
        },
        getInstruments: async () => {
            return await axios.get(baseUrl + 'admin/main')
        }
    }
}