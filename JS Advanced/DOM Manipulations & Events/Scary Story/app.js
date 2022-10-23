window.addEventListener("load", solve);

function solve() {

  let firstName = document.getElementById('first-name')
  let lastName = document.getElementById('last-name')
  let age = document.getElementById('age')
  let storyTitle = document.getElementById('story-title')
  let genre = document.getElementById('genre')
  let story = document.getElementById('story')

  let main = document.getElementById('main')

  let previewList = document.getElementById('preview-list')

  let formBtn = document.getElementById('form-btn')

  formBtn.addEventListener('click', publish)

  function publish(e) {
    e.preventDefault();

    let firstNameValue = firstName.value;
    let lastNameValue = lastName.value;
    let ageValue = age.value;
    let storyTitleValue = storyTitle.value;
    let genreValue = genre.value;
    let storyValue = story.value;

    if (firstNameValue == '' || lastNameValue == '' || ageValue == '' || storyTitleValue == '' || genreValue == '' || storyValue == '') {
      return;
    }

    const li = document.createElement('li');
    li.className = 'story-info';
    li.innerHTML = `<artile>
                        <h4>Name: ${firstNameValue} ${lastNameValue}</h4>
                        <p>Age: ${ageValue}</p>
                        <p>Title: ${storyTitleValue}</p>
                        <p>Genre: ${genreValue}</p>
                        <p>${storyValue}</p>
                    </article>
                    <button class="save-btn">Save Story</button>
                    <button class="edit-btn">Edit Story</button>
                    <button class="delete-btn">Delete Story</button>`;


    const saveBtn = li.querySelector('.save-btn');
    const editBtn = li.querySelector('.edit-btn');
    const deleteBtn = li.querySelector('.delete-btn');

    saveBtn.addEventListener('click', save);
    editBtn.addEventListener('click', edit);
    deleteBtn.addEventListener('click', deletePreview);

    previewList.appendChild(li);

    firstName.value = '';
    lastName.value = '';
    age.value = '';
    storyTitle.value = '';
    genre.value = '';
    story.value = '';

    formBtn.disabled = true;

    function edit() {
 
      firstName.value = firstNameValue;
      lastName.value = lastNameValue;
      age.value = ageValue;
      storyTitle.value = storyTitleValue;
      genre.value = genreValue;
      story.value = storyValue;

      formBtn.disabled = false;

      li.remove();
    }

    function save() {
      main.innerHTML = `<h1>Your scary story is saved!</h1>`
    }

    function deletePreview() {
      li.remove();
      formBtn.disabled = false;
    }
  }
}
