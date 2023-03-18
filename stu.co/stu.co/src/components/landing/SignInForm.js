import React, { useState } from "react";
import AuthService from "../../services/AuthService";
import { useNavigate } from 'react-router-dom';


function SignInForm() {

    let navigate = useNavigate();
    const [data, setData] = useState({});

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setData(values => ({ ...values, [name]: value }));
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        (async () => {
            const response = await AuthService.login(data);
            if (response) {
                localStorage.setItem("user", response.data.accessToken);
                if (response.data.accessToken) {
                    alert("You are logged in");
                    navigate("/feed");
                }
            }
        })().catch(err => {
            if (err.response.status === 400) {
                alert("Invalid credentials");
            }
        });
    }
    return (
        <div className="background-overlay">
            <div className="signIn-form-container">
                <form className="signIn-form">
                    <h1>sign in</h1>
                    <p>Username</p>
                    <input className="text-input-signin" type="text"
                        name="username"
                        value={data.username || ""}
                        onChange={handleChange} />
                    <p>Password</p>
                    <input className="text-input-signin" type="password"
                        name="password"
                        value={data.password || ""}
                        onChange={handleChange} />
                    <p>Forgot password...</p>
                    <button onClick={handleSubmit} className="input-button" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    )
}
export default SignInForm;