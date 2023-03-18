import React, { useState } from "react";


export default function Counter(props) {
    const [counter, setCounter] = useState(props.amountOfPeople);
    const increase = () => {
        setCounter(counter + 1);
        props.updateAmount(counter + 1);
    };
    const decrease = () => {
        if (counter > props.amountOfPeople) {//here should be a number from recipe, default number set by the person
            setCounter(counter - 1);
            props.updateAmount(counter - 1);
        }
    };
    const reset = () =>{
        setCounter(props.amountOfPeople)
        props.updateAmount(props.amountOfPeople);
      }
    return (  
            <div className="counter">
                <button onClick={decrease} className="creaser">-</button>
                <button onClick={increase} className="creaser">+</button>
                <p>I will cook for {counter} people</p>
                
                <button onClick={reset} className="btn_reset">Reset</button>
            </div>
    )
}