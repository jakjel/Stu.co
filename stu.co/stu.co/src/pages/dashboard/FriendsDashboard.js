import React, {useState, useEffect} from "react";
import RecipesService from "../../services/Service";
import FriendsList from "../../components/friends/FriendsList";
import SearchBar from "../../components/SearchBar";
import myLogo from "../../images/stuco-logo.png";
import NavBar from "../../components/NavBar";
import NavbarTop from "../../components/NavBarTop";
import AuthService from "../../services/AuthService";
import { useNavigate } from "react-router-dom";

export default function FriendsDashboard(){

    let navigate = useNavigate();
    
    const [username, setUsername] = useState("");
    const [users, setUsers] = useState([]);
    
    const retrieveUsersWithSearchedUsername = (username) => {
        RecipesService.getAllWithUsername(username)
          .then(response => {
            setUsers(response.data.users);
          })
          .catch(err => {
            setUsers([]);
          });
      };

    useEffect(() => {
        if (username !== "") {//check for empty string
          retrieveUsersWithSearchedUsername(username);
        }
        else{
          retrieveUsers();
        }
      }, [username]);

    //retrieves all users
  const retrieveUsers = () => {
    RecipesService.getAllUsers()
      .then(response => {
        setUsers(response.data.users);
      })
      .catch(err => {
        if(err.response.status === 403){
          navigate("/unauthorized");
        }else if(err.response.status === 0){
          // should be changed
          AuthService.logout();
          navigate("/");
        }
      });
  };

    //this one is sent to child component and from there sets value of ingredient
    const textChangedUsername = e => {
        setUsername(e.target.value);
      }
    
        return(
          <div>
            <NavbarTop />
            <img className="logo" src={myLogo} alt="logo" />
            <h1 className="heading">Friends🔎</h1>  
              <SearchBar textChanged={textChangedUsername} text={"Search for friend by his username..."}/>
              <FriendsList users={users}/>
              <NavBar/>
          </div> 
      )
      }
