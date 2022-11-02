function attachEvents() {
    // get all buttons from page
    // attach event listeners
    // create load func -> fetch all data from server
    // display loaded data
    // create new resords func -> get data from inputs and call server
    // implement delete func

    document.querySelector('#btnLoad').addEventListener('click', load)
    document.querySelector('#btnCreate').addEventListener('click', create)
    document.querySelector('#phonebook').addEventListener('click', remove)
}

let phoneBook = document.querySelector('#phonebook')
let url = 'http://localhost:3030/jsonstore/phonebook'

function create() {
    let name = document.querySelector('#person')
    let number = document.querySelector('#phone')

    if (!name.value || !number.value) {
        return
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            person: name.value.trim(),
            phone: number.value.trim()
        })
    })
        .then(res => res.json())
        .catch(err => alert(err.message))

    name.value = ''
    number.value = ''

}

function load() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            phoneBook.replaceChildren()
            Object.values(data).forEach(p => {
                let liElement = document.createElement('li')
                liElement.textContent = `${p.person} ${p.phone}`
                let buttonDelete = document.createElement('button')
                buttonDelete.textContent = 'Delete'
                buttonDelete.setAttribute('id', p._id)
                liElement.appendChild(buttonDelete)
                phoneBook.appendChild(liElement)
            })
        })
}

function remove(e) {
    let currentId = e.target.id;
    if (e.target.textContent == 'Delete') {
        fetch(`${url}/${currentId}`, {
            method: 'DELETE'
        })
            .then(res => {
                load()
                res.json()
            })
            .catch(err => alert(err.message))
    }

}
attachEvents();