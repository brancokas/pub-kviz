import {HTTPRequest} from "../../requests/HTTPRequest"
import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";

const Logout = () => {
    const [loggedOut, setLoggedOut] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        if (loggedOut) {
            navigate('/login');
        }
    }, [loggedOut, navigate]);

    const req = new HTTPRequest();
    req.get('/logout').then(() => {
        sessionStorage.clear();
        setLoggedOut(() => true);
    });
};

export default Logout;