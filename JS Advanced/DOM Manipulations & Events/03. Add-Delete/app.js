function addItem() {

    let item = document.getElementById('items');

    let getItem = document.getElementById('newItemText').value;

    let itemRes = document.createElement('li');
    itemRes.innerHTML = `${getItem} <a href="#">[Delete]</a>`;

    item.addEventListener('click', function (e) {
        e.target.parentElement.remove();
    });

    item.appendChild(itemRes);
}