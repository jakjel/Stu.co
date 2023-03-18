import React, { useState } from "react";
import SignInForm from "../components/landing/SignInForm";
import SignUpForm from "../components/landing/SignUpForm";
import ArticleContainersList from "../components/landing/ArticleContainersList";
import WallpaperImage from "../images/Cooking.jpeg";
import myLogo from "../images/stuco-logo.png";
import LoggedInStatus from "../components/LoggedInStatus";
import Chat from "../components/Chat";

export default function LandingPage() {
    const [isShown, setIsShown] = useState(false);
    const [chat, setChat] = useState(false);

    const handleClick = () => {
        setIsShown(current => !current);
    };

    const chatControl = () => {
        setChat(current => !current);
      }

    const articles = [
        {
            id: 1,
            heading: "Example",
            component: "", //here I will have about us page
            text: "Read more about us here..."
        },
        {
            id: 2,
            heading: "Join us now",
            component: <SignUpForm />,
            text: "Join us by creating new account here..."
        },
    ]
    return (
        <div>
            <div className="navbar-top">
                <img className="logo" src={myLogo} alt="logo" />
                <button className="navbar-button" onClick={handleClick}>{isShown? "Close" : "Sign in"}</button>{
                    isShown && <SignInForm />
                }
            </div>
            <img className="wallpaper" src={WallpaperImage} alt="wallpaper" />
            <p className="title-homepage"><b>students</b> <i>cookbook</i></p>
            <ArticleContainersList listArticles={articles} />
            <button id="chat" className="navbar-button" onClick={chatControl}>{chat? "close chat" : "open chat"}</button>{chat && <Chat />}
            <LoggedInStatus />
        </div>
    )
}