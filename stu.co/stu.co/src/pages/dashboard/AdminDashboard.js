import React from "react";
import myLogo from "../../images/stuco-logo.png";
import NavbarTop from "../../components/NavBarTop";

export default function AdminDashboard() {
    return (
    <div>
        <NavbarTop />
        <img className="logo" src={myLogo} alt="logo" />
        <div className="dashboard">
            <h1>Admin page</h1>
        </div>
    </div>
    )
}