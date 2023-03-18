import React, {useState} from 'react';
import RecipeDetails from './RecipeDetails';

export default function VideoView(props) {

    let textClose = "x";

    const [favorite, setFavorite] = useState(true);

    const addremoveFavorite = () => {
        setFavorite(favorite => !favorite);
    }


    return (
        <div className='video-view-overlay'>
            <button onClick={props.closeVideo} className='video-view-button-close'>{textClose}</button>
                <div className='video-view-first-part'>
                    <video className='video-view' controls autoPlay={true} muted>
                    <source src={props.video.video_link} type="video/mp4"/>
                </video>
                <button onClick={addremoveFavorite} className='btn_favorite'>{favorite? 'Save' : 'Saved'}</button>
                </div>
                <RecipeDetails recipe={props.video}/>            
        </div>
    )

}