import React, {useState, useEffect} from "react";
import AdminDashboard from "./dashboard/AdminDashboard";
import AuthService from "../services/AuthService";
import UnauthorizedPage from "./dashboard/UnauthorizedPage";

export default function AdminPage(){
    const [permission, setPermission] = useState(false);
    useEffect(()=>{
        const role = AuthService.getUsersRole();
        console.log(role);
        if(role[0] === "ADMIN"){
            setPermission(true);
        }
    },[])
    return (
    <div>
        {permission? <AdminDashboard/> : <UnauthorizedPage />}
    </div>
    )
}