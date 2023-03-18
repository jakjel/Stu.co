import React, {useState} from 'react';



function ArticleContainer(props){
    const [isShownSignUp, setIsShownSignUp] = useState(false);

    const handleClick = () => {
        setIsShownSignUp(current => !current);
    };
    return (
        <div className='article-container'>
            <h1>{props.newArticle.heading}</h1>
            <button className='navbar-button-join' onClick={handleClick}>{props.newArticle.text}</button>{
                    isShownSignUp && props.newArticle.component
                }
        </div>
    )
}

export default ArticleContainer;