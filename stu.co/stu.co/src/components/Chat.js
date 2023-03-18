import React, { useState } from "react";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

const ENDPOINT = "http://localhost:8080/ws";

export default function Chat() {

    const [connected, setConnected] = useState(false);
    const [stompClient, setStompClient] = useState(null);
    const [msgToSend, setSendMessage] = useState("Enter your message here!");
    const [chatResponse, setChatResponse] = useState()
    const [liveChat, setLiveChat] = useState([]);

    const connect = () => {
        const socket = SockJS(ENDPOINT);
        const stompClient = Stomp.over(socket);
        stompClient.connect({}, () => {
            stompClient.subscribe('/topic/websockets', (data) => {
                onMessageReceived(JSON.parse(data.body).content);
                addData(JSON.parse(data.body).content);
            });
        });
        setConnected(current => !current);
        setStompClient(stompClient);
        alert("Connected successfully!");
    }

    const disconnect = () => {
        if (stompClient) {
            stompClient.disconnect();
            setConnected(current => !current);
            alert("Disconnected successfully!");
        }
        setStompClient(null);
    }

    // send the data using Stomp
    function sendMessage() {
        if (stompClient) {
            stompClient.send("/app/hello", {}, JSON.stringify({ 'name': msgToSend }));
        } else {
            alert("You are not connected :'(");
        }
    };

    // display the received data
    function onMessageReceived(data) {
        setChatResponse(data);
    };
    const addData = (data) => {
        setLiveChat(liveChat => [...liveChat, data]);
    }


    return (
        <div className="chat">
            <button id="join" className="navbar-button" onClick={connected ? disconnect : connect}>{connected ? "Leave live-chat" : "Join live-chat"}</button>
            <div className="chat-messages-list">
                {liveChat && liveChat.map((messages, i) => {
                return (
                    <p key={i}>{messages}</p>
                );
                })}
            </div>
            <div className="chat-bar">
                <input onChange={(event) => setSendMessage(event.target.value)} placeholder={msgToSend}></input>
                <button onClick={sendMessage}>🍪</button>
            </div>
        </div>
    )
}