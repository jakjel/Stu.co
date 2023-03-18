import React from 'react';

function InformationContainer(props){
    return (
        <div className='information-container'>
            <h1>{props.newInfo.heading}</h1>
            <div>{props.newInfo.div}</div>
        </div>
    )
}

export default InformationContainer;