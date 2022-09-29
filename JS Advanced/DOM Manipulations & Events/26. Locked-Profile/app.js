function lockedProfile() {
    let profiles = Array.from(document.querySelectorAll('.profile'));

    profiles.forEach(element => {
        let sendbtn = element.querySelector('button');
        let hidden = element.querySelector('div');
        sendbtn.addEventListener('click', function (event) {
            let checkRadio = element.querySelector(
                'input[type="radio"]');

            if (checkRadio.checked) {
                return
            } else {
                if (sendbtn.textContent === 'Show more') {
                    hidden.style.display = 'block'
                    sendbtn.textContent = 'Hide it'
                } else if (sendbtn.textContent === 'Hide it') {
                    hidden.style.display = 'none'
                    sendbtn.textContent = 'Show more'
                }
            }


        });
    });
}