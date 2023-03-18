import React from "react";
import { NavLink } from "react-router-dom";
import wallet from "../images/icons/wallet1.png";
import feed from "../images/icons/feed.png";
import friends from "../images/icons/friends.png";

function NavBar() {

    const links = [
        {
            id: 1,
            path: "/expenses",
            text: "expenses",
            icon: wallet
        },
        {
            id: 2,
            path: "/feed",
            text: "feed",
            icon: feed
        },
        {
            id: 3,
            path: "/friends",
            text: "friends",
            icon: friends
        }

    ]

    return (
        <div className="navbar-bottom">
            <ul className="navbar-bottom-links">
                {links.map(link => {
                    return (
                        <li className="navbar-list" key={link.id}>
                        <NavLink className="navbar-point" to={link.path}>
                        <img className="icon" src={link.icon} alt="icon" />
                        </NavLink>
                    </li>
                )
            })}
            </ul>
        </div>
    )
}
export default NavBar;