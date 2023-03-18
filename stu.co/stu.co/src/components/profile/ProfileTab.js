import React from "react";

export default function ProfileTab(props) {
    return (
        <div className="profile-tab">
            <span>Welcome<h2>{props.profile.firstName + " " + props.profile.lastName}</h2></span>
            <span>Username:<h2>{props.profile.username}</h2></span>
            <span>Email:<h2>{props.profile.email}</h2></span>
            <h2>Settings</h2>
            <form>
                <h3>Password</h3>
                <input className="input-settings" type="password" placeholder="Old password"></input>
                <input className="input-settings" type="password" placeholder="New password"></input>
                <input className="input-settings" type="password" placeholder="Confirm new password"></input>
                <button className="input-button">Change password</button>
            </form>
        </div>
    )
}