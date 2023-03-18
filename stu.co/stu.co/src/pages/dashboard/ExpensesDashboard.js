import React, { useEffect, useState } from "react";
import myLogo from "../../images/stuco-logo.png";
import NavBar from "../../components/NavBar";
import GroupsContainer from "../../components/expenses/GroupsContainer";
import GroupOverviewContainer from "../../components/expenses/GroupOverviewContainer";
import NavbarTop from "../../components/NavBarTop";





export default function ExpensesDashboard() {

    const [selectedGroup, setSelectedGroup] = useState(0);


    const setSelected=(value)=>{
        setSelectedGroup(value);
    }
    
    return (
         <div>
            <NavbarTop/>
            <img className="logo" src={myLogo} alt="logo" />
            <h1 className="heading">Expenses💸</h1>
            <div className="expenses-dashboard">
                <GroupsContainer getSelectedGroup={setSelected} />
                <GroupOverviewContainer selectedGroup={selectedGroup} />
            </div>
            <NavBar />
        </div>
    )
}
