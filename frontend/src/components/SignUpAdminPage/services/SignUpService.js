import axios from 'axios';

const MAIN_API_BASE_URL = 'http://localhost:8080/api/admin/sign_up';

class SignUpService {
    getAdmins() {
        return axios.get(MAIN_API_BASE_URL);
    }
}

export default new SignUpService();