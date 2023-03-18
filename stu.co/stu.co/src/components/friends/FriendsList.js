import React from "react";
import addfriend from "../../images/icons/addfriend.png";


export default function FriendsList(props){
    return (
    <div className="friends-list-container">
        <div className="friends-list">
            {props.users && props.users.map((user) => {
                return (
                <div className="friend-container" key={user.username}>
                    <div className="username-container">
                    <div className="username-bubble">{user.username.substring(0, 2).toUpperCase()}</div>
                    <h4>{user.username}</h4>
                    </div>
                    <img className="icon" src={addfriend} alt="addfriend"/>
                </div>
            )})}
        </div>
    </div>)
}