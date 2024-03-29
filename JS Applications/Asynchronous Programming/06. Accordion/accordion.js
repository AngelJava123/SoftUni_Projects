async function solution() {
    // fetch all articles from server
    // create divs with titles // toggle buttons
    // on click fetch details data
    // update html with data
    try {
        let response = await fetch(`http://localhost:3030/jsonstore/advanced/articles/list`);

        if (!response.ok) {
            throw new Error('Error obtaining article list')
        }

        let data = await response.json();

        data.forEach(articleInfo => {
            let articleElement = document.createElement('div')
            articleElement.classList.add('accordion')
            articleElement.innerHTML = `<div class="head">
                                        <span>${articleInfo.title}</span>
                                        <button class="button" id="${articleInfo._id}" onclick="moreOnclick(event)">More</button>
                                        </div>
                                        <div class="extra"></div>`

            let main = document.getElementById('main')
            main.appendChild(articleElement)
        });
    } catch (error) {

    }

}

async function moreOnclick(e) {
    try {
        let currentTarget = e.currentTarget
        let parent = currentTarget.parentNode.parentNode;
        let extraDiv = parent.querySelector('div.extra')

        let response = await fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${currentTarget.id}`)

        if (!response.ok) {
            throw new Error('Error obtaining article details')
        }

        let data = await response.json()
        extraDiv.innerHTML = `<p>${data.content}</p>`;

        if (currentTarget.textContent == 'More') {
            currentTarget.textContent = 'Less'
            extraDiv.style.display = 'block'
        } else {
            currentTarget.textContent = 'More'
            extraDiv.style.display = 'none'
        }

    } catch (error) {
        console.log(error)
    }
}

solution();