window.addEventListener('load', solve);

function solve() {

    let likesCount = 0;

    let genre = document.getElementById('genre')
    let name = document.getElementById('name')
    let author = document.getElementById('author')
    let date = document.getElementById('date')

    let addBtn = document.getElementById('add-btn')

    let allHitsList = document.querySelector('.all-hits-container')

    let savedList = document.querySelector('.saved-container')

    let totalLikes = document.querySelector('#total-likes p')

    addBtn.addEventListener('click', addSong)

    function addSong(e) {
        e.preventDefault();

        let genreValue = genre.value;
        let nameValue = name.value;
        let authorValue = author.value;
        let dateValue = date.value;
        // let likesValue = Number(totalLikes.value);

        if (genreValue == '' || nameValue == '' || authorValue == '' || dateValue == '') {
            return;
        }

        const div = document.createElement('div');
        div.className = 'hits-info'
        div.innerHTML = `<img src="./static/img/img.png">
                        <h2>Genre: ${genreValue}</h2>
                        <h2>Name: ${nameValue}</h2>
                        <h2>Author: ${authorValue}</h2>
                        <h3>Date: ${dateValue}</h3>
                        <button class="save-btn">Save song</button>
                        <button class="like-btn">Like song</button>
                        <button class="delete-btn">Delete</button>`;

        // add functionality to buttons
        const saveBtn = div.querySelector('.save-btn');
        const likeBtn = div.querySelector('.like-btn')
        const deleteBtn = div.querySelector('.delete-btn')
        saveBtn.addEventListener('click', saves);
        likeBtn.addEventListener('click', likes);
        deleteBtn.addEventListener('click', deletes);

        // append to first list
        allHitsList.appendChild(div);
        // clear input fields
        genre.value = '';
        name.value = '';
        author.value = '';
        date.value = '';

        function likes() {
            likesCount++
            totalLikes.textContent = `Total Likes: ${likesCount}`;
            likeBtn.disabled = true
        }

        function saves() {

            const divSaves = document.createElement('div');
            divSaves.className = 'hits-info';
            divSaves.innerHTML = `<img src="./static/img/img.png">
                            <h2>Genre: ${genreValue}</h2>
                            <h2>Name: ${nameValue}</h2>
                            <h2>Author: ${authorValue}</h2>
                            <h3>Date: ${dateValue}</h3>
                            <button class="delete-btn">Delete</button>`;

            const deleteSavesBtn = divSaves.querySelector('.delete-btn')
            deleteSavesBtn.addEventListener('click', deleteSaves);

            savedList.appendChild(divSaves);
            // remove action buttons
            likeBtn.remove();
            saveBtn.remove();

            div.remove();

            function deleteSaves() {
                divSaves.remove();
            }
        }

        function deletes() {
            div.remove();
        }
    }
}