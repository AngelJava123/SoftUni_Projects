function loadRepos() {
	const usrname = document.getElementById('username').value;
	fetch(`https://api.github.com/users/${usrname}/repos`)
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

	const list = document.getElementById('repos');

	const items = data.map(repo => {
		const li = document.createElement('li');
		li.innerHTML = `<a href="${repo.html_url}">
		                 ${repo.full_name}
	                    </a>`

		return li;
	});

	list.replaceChildren(...items);
}

function handleError(err) {
	const list = document.getElementById('repos');
	list.textContent = err.message;
}
