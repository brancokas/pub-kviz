import {HTTPRequest} from "../../requests/HTTPRequest"

const Logout = () => {
    const req = new HTTPRequest();
    req.get('/logout').then(res => {});
};

export default Logout;