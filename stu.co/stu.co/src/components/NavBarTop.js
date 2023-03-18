import React from "react";
import AuthService from "../services/AuthService";
import { useNavigate } from 'react-router-dom';
// import { useNavigate } from 'react-router-dom';

export default function LogoutBtn() {

    let navigate = useNavigate();
    const logout = () => {
        return (
            AuthService.logout(),
            navigate("/")
        );
    }
    const myProfile =() => {
        navigate("/profile");
    }

    return (
        <div className="navbar-top">
            <button id="profile" className="navbar-button" onClick={myProfile}>Profile</button>
            <button className="navbar-button" onClick={logout}>Log out</button>
        </div>
    )
}