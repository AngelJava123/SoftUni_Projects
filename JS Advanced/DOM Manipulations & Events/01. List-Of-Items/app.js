function addItem() {
    let item = document.getElementById('items');

    let getItem = document.getElementById('newItemText').value;

    let itemRes = document.createElement('li');
    itemRes.innerHTML = getItem;

    item.appendChild(itemRes);

}