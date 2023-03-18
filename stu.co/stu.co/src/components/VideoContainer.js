import React, { useState } from "react";
import VideoView from "./VideoView";

export default function VideoContainer(props) {

    const [isShown, setIsShown] = useState(false);

    const handleClickOnVideo = () => {
        setIsShown(current => !current);
    };


    const isHovered = (e) => {
        e.target.style.textDecoration = 'underline';
        e.target.style.color = 'wheat';
    }
    const isNotHovered = (e) => {
        e.target.style.textDecoration = 'none';
        e.target.style.color = 'white';

    }

    return (
        <div className="video-container">
            <video autoPlay={true} muted loop>
                <source src={props.newVideo.video_link} type="video/mp4" />
            </video>
            
                <p onMouseOver={isHovered} onMouseLeave={isNotHovered} className="video-container-link" onClick={handleClickOnVideo}>{props.newVideo.title}</p>{
                    isShown && <VideoView video={props.newVideo} closeVideo={handleClickOnVideo} />
                }
            

        </div>
    )
}