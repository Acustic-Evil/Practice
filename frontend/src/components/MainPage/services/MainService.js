import axios from 'axios';

const MAIN_API_BASE_URL = 'http://localhost:8080/api/main';

class MainService {
    getInstruments() {
        return axios.get(MAIN_API_BASE_URL);
    }
}

export default new MainService();