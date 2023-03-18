import React, {useState, useEffect} from "react";
import AuthService from "../services/AuthService";
import { useNavigate } from "react-router-dom";

export default function LoggedInStatus(){
    let navigate = useNavigate();
    const [user, setUser] = useState();
    useEffect(()=>{
        setUser(AuthService.getCurrentUser());
    },[])
    return (
        <div className="loggedInStatus">
            <p onClick={()=>navigate("/feed")} style={user? {backgroundColor: 'green'} : {backgroundColor:'red'}}>{user? 'Signed in' : 'Signed out'}</p>
        </div>
    )
}