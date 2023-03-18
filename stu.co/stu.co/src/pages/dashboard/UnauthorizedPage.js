import React from "react";
import { useNavigate } from "react-router-dom";
import myLogo from "../../images/stuco-logo.png";
import NavbarTop from "../../components/NavBarTop";

export default function UnauthorizedPage() {
    let navigate = useNavigate();
    return (
        <div >
            <NavbarTop />
            <img className="logo" src={myLogo} alt="logo" />
            <div className="dashboard">
                <h1>You have no permission to be here :&#40;</h1>
                <button className="input-button" onClick={() => navigate("/")}>Back to landing page</button>
            </div>
        </div>
    )
}