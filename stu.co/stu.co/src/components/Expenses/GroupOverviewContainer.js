import React, { useState, useEffect } from "react";
import AuthService from "../../services/AuthService";
import RecipesService from "../../services/Service";
import { useNavigate } from "react-router-dom";

export default function GroupOverviewContainer(props) {

  const [user, setUser] = useState(AuthService.getCurrentUser());
  let navigate = useNavigate();
  const [userOwedTo, setUserOwedTo] = useState("");

  useEffect(() => {
    setUser(AuthService.getCurrentUser());
    if (!user) {
      AuthService.logout();
      navigate("/");
    }
  }, []);

  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    retrieveExpenses(props.selectedGroup);
    setUserOwedTo([]);
  }, [props.selectedGroup])

  const retrieveExpenses = async (id) => {
    await RecipesService.getExpensesByGroupId(id)
      .then(response => {
        setExpenses(response.data.expenses);
      })
      .catch(err => {
        // console.log(err);
        if (err.response.status === 403) {
          navigate("/unauthorized");
        } else if (err.response.status === 0) {
          // should be changed
          AuthService.logout();
          navigate("/");
        }
      });
  };
  const getUserById = (id, i) => {
    RecipesService.getUserById(id)
      .then(response => {
        setUserOwedTo(values => ({ ...values, [i]: response.data.username }))
      }
      )
      .catch(err => {
        setUserOwedTo({});
      }
      );
  };

  const data = {
    "id": 0,
    "uot_id": 4,
    "group_id": 5,
    "amount_of_money": 3.50,
    "created_at": "2023-01-13T09:37:48.214Z",
    "username": "frank",
    "user_id": 5
  }

  const handleSubmit = (e) => {
      e.preventDefault();
          (async () => {
              const response = await RecipesService.createExpense(data);
              alert("Expense created");
          })().catch(err => {
              alert(err.message);
          });
  }

  return (
    <div className="expenses-dashboard-overview">
      <h2>Members</h2>
      <button className="input-button" type="Submit" onClick={handleSubmit}>Create expense</button>
      <div className="expenses-dashboard-members-overwiev-container">
        {expenses.map((member, i) => {
          return (
            <div key={i} className="expenses-dashboard-darker-card">
              <h2>{member.username}</h2>
              <h4>📉Debt: {member.amount_of_money} €💸</h4>
              <h4 id={i} onClick={() => getUserById(member.uot_id, i)}>⏰{!userOwedTo[i] ? 'click to see who is waiting for money' : `${userOwedTo[i]}`} </h4>
            </div>
          )
        })} </div>
    </div>
  )
}