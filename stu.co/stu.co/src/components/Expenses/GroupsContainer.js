import React, {useEffect, useState} from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../../services/AuthService";
import RecipesService from "../../services/Service";
// import Bubbles from "./Bubbles";

export default function GroupsContainer(props){

    let navigate = useNavigate();

    const [selectedGroup, setSelectedGroup] = useState(0);
    const [user, setUser] = useState(AuthService.getCurrentUser());
    const [groups, setGroups] = useState([]);

    useEffect(() => {
      setUser(AuthService.getCurrentUser());
      if(!user){
          AuthService.logout();
          navigate("/");
      }else{
        retrieveGroups(user.userId);
      }
  }, []);

    const retrieveGroups = async (id) => {
        await RecipesService.getGroupsByUserId(id)
          .then(response => {
            setGroups(response.data.groups); //dulezity rict recipes!!! jinak array inside of an array
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

      const groupSwitcher = (id) => {
        setSelectedGroup(id);
    }

    useEffect(()=>{
        props.getSelectedGroup(selectedGroup);
    },[selectedGroup])

    const data = {
      "id": 0,
      "group_name": "TestForDemo",
      "created_at": "2023-01-13T09:32:50.641Z"
    }

    const handleSubmit = (e) => {
        e.preventDefault();
            (async () => {
                const response = await RecipesService.createGroup(data);
                alert("Group created");
            })().catch(err => {
                alert(err.message);
            });
    }

    return(
        <div className="expenses-dashboard-groups">
                    <h2>Groups</h2>
                    <button className="input-button" type="Submit" onClick={handleSubmit}>Create group</button>
                        {groups.map(group => {
                            return(
                            <div key={group.id} className="expenses-dashboard-groups-tab">
                                <h2 onClick={()=>groupSwitcher(group.id)}>{group.group_name}</h2>
                                <p>Created on: {group.created_at.split('T')[0]}</p>
                            </div>
                        )})
                    }
                </div>
    )
}