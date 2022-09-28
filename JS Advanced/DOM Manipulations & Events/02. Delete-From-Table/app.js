function deleteByEmail() {

    let emails = document.querySelectorAll('#customers td:nth-child(2)');
    let text = document.querySelector('input[type=text]').value;
    let result = document.getElementById('result');

    let flag = false;

    for (const email of emails) {
        if (email.textContent === text) {
            email.parentElement.remove();
            result.textContent = 'Deleted.'
            flag = true;
        }
    }
    if (!flag) {
        result.textContent = 'Not found.'
    }
}