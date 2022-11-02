function attachEvents() {
    // add event listeners to the buttons
    // create addComment func -> get data from inputs
    // POST request to the server
    // create displayComments func -> fetch all comments from server
    // display the data

    document.querySelector('#refresh').addEventListener('click', displayComments)
    document.querySelector('#submit').addEventListener('click', addComment)
}

let url = 'http://localhost:3030/jsonstore/messenger';

function addComment() {
    let authorName = document.querySelector('[name="author"]')
    let content = document.querySelector('[name="content"]')

    if (!authorName.value || !content.value) {
        return
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            author: authorName.value.trim(),
            content: content.value.trim()
        })
    })
        .then(res => {
            if (res.ok == false) {
                throw new Error('Error creating new record')
            }

            return res.json()
        })
        .catch(err => alert(err))

    authorName.value = ''
    content.value = ''

}

function displayComments() {
    fetch(url)
        .then(res => {
            if (res.ok == false) {
                throw new Error('Error')
            }

            return res.json()
        })
        .then(data => {
            let textArea = document.querySelector('#messages')
            let comments = []
            Object.values(data).forEach(u => comments.push(`${u.author}: ${u.content}`))
            textArea.value = comments.join('\n')
        })
        .catch(err => alert(err.message))
}

attachEvents();