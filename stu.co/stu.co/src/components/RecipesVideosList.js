import React from 'react';
import VideoContainer from './VideoContainer';

export default function RecipesVideosList(props){

    return (
        <div className='videos-container'>
            <div className='list-of-videos'>
            {props.recipes.map(video =>
                {
                return(
                    <div key={video.id}>
                        <VideoContainer newVideo={video} />
                    </div>  
                    )
                })
            }
            </div>
        </div>
    ) 
}