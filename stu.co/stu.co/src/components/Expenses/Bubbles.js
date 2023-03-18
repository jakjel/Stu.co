import React from "react";

export default function Bubbles(props){
    return(
        <div className="bubbles-avatars">
            {props.members.map(
                member=>{
                    return(
                        <div key={member.member_name} >
                            <img className="avatar" src={member.member_avatar} alt="avatar"/>
                        </div>
                    )
                }
            )}
        </div>
    )
}