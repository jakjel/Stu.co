import React, { useState } from "react";
import UserService from "../../services/Service";

function SignUpForm() {

    const [data, setData] = useState({});

    const handleSubmit = (e) => {
        e.preventDefault();
            (async () => {
                const response = await UserService.signUp(data);
                alert("Account created");
            })().catch(err => {
                if (err.response.status === 403) {
                    alert("User with such username already exists");
                }else if (err.response.status === 400){
                    alert("User with such username already exists");
                }
            });
    }

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setData(values => ({ ...values, [name]: value }));
    }


    return (
        <div className="background-overlay">
            <div className="signIn-form-container">
                <form className="signIn-form">
                    <h1>sign up</h1>
                    <p>Email</p>
                    <input className="text-input-signin" type="email"
                        name="email"
                        value={data.email || ""}
                        onChange={handleChange}
                    />
                    <p>First name</p>
                    <input className="text-input-signin" type="text"
                        name="first_name"
                        value={data.first_name || ""}
                        onChange={handleChange} />
                    <p>Last name</p>
                    <input className="text-input-signin" type="text" name="last_name"
                        value={data.last_name || ""}
                        onChange={handleChange} />
                    <p>Username</p>
                    <input className="text-input-signin" type="text" name="username"
                        value={data.username || ""}
                        onChange={handleChange} />
                    <p>Password</p>
                    <input className="text-input-signin" type="password" name="password"
                        value={data.password || ""}
                        onChange={handleChange} />
                    <button className="input-button" type="Submit" onClick={handleSubmit}>Sign up</button>
                </form>
            </div>
        </div>
    )
}
export default SignUpForm;