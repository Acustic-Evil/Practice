import axios from "axios";
import baseUrl from "./base-url";


const validateStatus = status => (status >= 200 && status <= 300) || [500].includes(status);

export default {
    Admin: {
        submitNewInstrument: async (data) => {
            let response = await axios.post(baseUrl + '/admin/add_new_instrument',
                data,
                {
                    validateStatus
                });

            return response.data;
        },
        getInstruments: async () => {
            let response = await axios.get(baseUrl + '/admin/main', {
                validateStatus
            })
            return response.data;
        },
        deleteInstrument: async (id) => {
            let response = await axios.delete(baseUrl + `/admin/delete_instrument/${id}`, {
                validateStatus
            })
            return response.data;

        },
        updateInstrument: async (data) => {
            let response = await axios.post(baseUrl + `/admin/edit_instrument`,
                data,
                {
                    validateStatus
                });
            return response.data;
        },
        getInstrumentById: async (id) => {
            let response = await axios.get(baseUrl + `/admin/get_instrument/${id}`,
                {
                    validateStatus
                });
            return response.data;
        }
    },
    Main: {
        fetchInstruments: async () => {
            let response = await axios.get(baseUrl + '/main', {
                validateStatus
            })
            return response.data;
        }

    }
}