function getArticleGenerator(articles) {

    let div = document.getElementById('content')
    return function () {
        //remove first element from list
        let article = articles.shift();
        if (article !== undefined) {
            // construct HTML elements
            let element = document.createElement('article');
            element.textContent = article;
            // display article on page
            div.appendChild(element);
        }
    }
}
