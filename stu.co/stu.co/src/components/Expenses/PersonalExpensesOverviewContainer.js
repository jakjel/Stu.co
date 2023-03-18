import React from "react";
 export default function PersonalExpensesOverviewContainer(props){
    return(
        <div className="expenses-dashboard-overview">
                    <h2>⚖️Overview</h2>
                    <div className="expenses-dashboard-card">
                        <h2>Amount owed to me: {props.groups[0].members[0].owned}</h2>
                        <h2>Debth: {props.groups[0].members[0].debt}</h2>
                    </div>
                <h2>Expenses history</h2>
                <div className="expenses-dashboard-card">
                    <h1>...</h1>
                </div>
        </div>
    )
 }