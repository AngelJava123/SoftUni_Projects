function loadCommits() {
    const username = document.getElementById('username').value;
    const repository = document.getElementById('repo').value;
    fetch(`https://api.github.com/repos/${username}/${repository}/commits`)
        .then(handleResponse)
        .then(handleData)
        .catch(handleError)
}

function handleResponse(response) {
    if (response.ok == false) {
        throw new Error(`Error: ${response.status} ${response.statusText}`);
    }
    return response.json();
}

function handleData(data) {

    const list = document.getElementById('commits');

    Object.entries(data).forEach(el => {
        const li = document.createElement('li');
        li.textContent = `${el[1].commit.author.name}: ${el[1].commit.message}`;
        list.appendChild(li)
    });
}

function handleError(err) {
    const list = document.getElementById('commits');
    list.textContent = err.message;
}