import React from 'react';
import ArticleContainer from './ArticleContainer';

function ArticleContainersList(props) {
    return (
        <div className='article-containers-list'>
            {props.listArticles.map(articleContainer => (
                <div key={articleContainer.id}>
                    <ArticleContainer newArticle={articleContainer} />
                </div>
            ))}
        </div>
    )
}

export default ArticleContainersList;