function solve() {

    let res = 0;

    let firstName = document.getElementById('fname')
    let lastName = document.getElementById('lname')
    let email = document.getElementById('email')
    let dateOfBirth = document.getElementById('birth')
    let position = document.getElementById('position')
    let salary = document.getElementById('salary')

    let addWorkerBtn = document.getElementById('add-worker')

    let element = document.getElementById('tbody')

    let sum = document.getElementById('sum')

    addWorkerBtn.addEventListener('click', addWorker)

    function addWorker(e) {
        e.preventDefault();

        let firstNameValue = firstName.value;
        let lastNameValue = lastName.value;
        let emailValue = email.value;
        let dateOfBirthValue = dateOfBirth.value;
        let positionValue = position.value;
        let salaryValue = Number(salary.value);

        if (firstNameValue == '' || lastNameValue == '' || emailValue == '' || dateOfBirthValue == '' || positionValue == '' || salaryValue == '') {
            return;
        }

        const tr = document.createElement('tr');
        tr.innerHTML = `<td>${firstNameValue}</td>
                        <td>${lastNameValue}</td>
                        <td>${emailValue}</td>
                        <td>${dateOfBirthValue}</td>
                        <td>${positionValue}</td>
                        <td>${salaryValue}</td>
                        <td><button class="fired">Fired</button>
                        <button class="edit">Edit</button></td`;

        const fireBtn = tr.querySelector('.fired');
        const editBtn = tr.querySelector('.edit')
        fireBtn.addEventListener('click', fire);
        editBtn.addEventListener('click', edit);

        element.appendChild(tr);

        res += salaryValue;
        sum.textContent = Math.round(res).toFixed(2);

        firstName.value = '';
        lastName.value = '';
        email.value = '';
        dateOfBirth.value = '';
        position.value = '';
        salary.value = '';

        function edit() {
            // populate input fields with values
            firstName.value = firstNameValue;
            lastName.value = lastNameValue;
            email.value = emailValue;
            dateOfBirth.value = dateOfBirthValue;
            position.value = positionValue;
            salary.value = salaryValue;

            // remove list item from list
            tr.remove();

            res -= salaryValue;
            sum.textContent = Math.round(res).toFixed(2);
        }

        function fire() {
            tr.remove();
            res -= salaryValue;
            sum.textContent = Math.round(res).toFixed(2);
        }
    }
}
solve()