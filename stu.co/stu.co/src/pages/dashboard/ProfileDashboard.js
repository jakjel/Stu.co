import React, { useState, useEffect } from "react";
import RecipesService from "../../services/Service";
import myLogo from "../../images/stuco-logo.png";
import NavBar from "../../components/NavBar";
import InformationContainer from "../../components/InformationContainer";
import GDPRandCookies from "../../components/profile/GDPRandCookies";
import ProfileTab from "../../components/profile/ProfileTab";
import FriendsList from "../../components/friends/FriendsList";
import RecipesVideosList from "../../components/RecipesVideosList";
import AuthService from "../../services/AuthService";
import NavbarTop from "../../components/NavBarTop";
import { useNavigate } from "react-router-dom";




export default function ProfileDashboard() {
    const [user, setUser] = useState(AuthService.getCurrentUser());
    let navigate = useNavigate();

    
    useEffect(() => {
        setUser(AuthService.getCurrentUser());
        if(!user){
            AuthService.logout();
            navigate("/unauthorized");
        }else{
            getUserById(user.userId);
            getFriends();
            getFavoriteRecipes();
        }
    }, []);

    const [profile, setProfile] = useState({});
    const [friends, setFriends] = useState([]); //only friends
    const [recipes, setRecipes] = useState([]); //only favorite recipes
    const [selected, setSelected] = useState({}); //selected tab

    const tabSwitcher = (id) => {
        components.filter(component => component.id === (id)).map(div => (setSelected(div)));
    }

    const getUserById = (id) => {
        RecipesService.getUserById(id)
            .then(response => {
                setProfile(response.data);
            }
            )
            .catch(err => {
                setProfile({});
            }
            );
    };

    const getFriends = (userId) => {
        //axios method to get friends by user id
        setFriends([{
            id: 1,
            username: "jelinejak",
            firstName: "Jakub",
            lastName: "Jelinek"
        },
        {
            id: 2,
            username: "danielito",
            firstName: "Daniel",
            lastName: "Danielovski"
        },
        ]);
    };

    const getFavoriteRecipes = (userId) => {
        //axios method, get favorite recipes by user id
        // for now it gets all recipes
        RecipesService.getAll()
            .then(response => {
                setRecipes(response.data.recipes); //dulezity rict recipes!!! jinak array inside of an array
            })
            .catch(err => {
            });
    };
    // const scrollToDiv = (id) => {
    //     var element = document.getElementById(id);
    //     element.scrollIntoView({ behavior: "smooth" });
    // }
    const components = [
        {
            id: 1,
            heading: "Profile",
            div: <ProfileTab profile={profile} />
        },
        {
            id: 2,
            heading: "Friends",
            div: <FriendsList users={friends} />
        },
        {
            id: 3,
            heading: "Favourite recipes",
            div: <RecipesVideosList recipes={recipes} />
        },
        {
            id: 4,
            heading: "Cookies and GDPR",
            div: <GDPRandCookies />
        },
    ]
    const sidebarLinks = [
        {
            id: 1,
            link: "", //component it will show
            text: "General information"
        },
        {
            id: 2,
            link: "", //component it will show
            text: "List of friends"
        },
        {
            id: 3,
            link: "", //component it will show
            text: "Favorite recipes"
        },
        {
            id: 4,
            link: "", //component it will show
            text: "Cookies and GDPR"
        },
    ]

        return (
            <div>
                <NavbarTop />
                <img className="logo" src={myLogo} alt="logo" />
                <h1 className="heading">Profile page👤</h1>
                <div className="profile-container">
                    <div className="profile-container-sidebar">
                        {sidebarLinks.map(sidebarLink => {
                            return (
                                <div key={sidebarLink.id} onClick={() => tabSwitcher(sidebarLink.id)} className="sidebar-link">{sidebarLink.text}</div>
                            )
                        })}
                    </div>
                    <div className="profile-container-info">
                        <InformationContainer newInfo={selected} />
                    </div>
                </div>
                <NavBar />
            </div>
        )
    }


