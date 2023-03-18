import http from "../http-common";
import jwt_decode from "jwt-decode";

const login = (data) => {
    const response = http.post('login', data);
    return response;
}

const logout = () => {
    localStorage.removeItem("user");
}
const getCurrentUser = () => {
    var token = localStorage.getItem("user");
    if(token){
        var user = jwt_decode(token);
    }else{
        user = null;
    }
    return user;
}
const getUsersRole = () => {
    var token = localStorage.getItem("user");
    if (token) {
        var user = jwt_decode(token);
    }else{
        user = {
            roles: "Not logged in",
        }
    }
    return user.roles;
}

const AuthService = {
    login,
    logout,
    getCurrentUser,
    getUsersRole
};
export default AuthService;