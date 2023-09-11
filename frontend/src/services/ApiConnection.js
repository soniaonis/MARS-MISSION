import http from '../httpCommon.js';

class ApiConnection {

    saveResult() {
        return http.post('/calculate');
    }

    deleteOperationById(id) {
        return http.delete(`${id}`);
    }
}

export default new ApiConnection();