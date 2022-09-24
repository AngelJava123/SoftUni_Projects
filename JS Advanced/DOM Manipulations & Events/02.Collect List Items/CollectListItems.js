function extractText() {
    let listItems = document.querySelectorAll('ul li');
    let textarea = document.getElementById('result');

    for (const item of listItems) {
        textarea.value += item.textContent + '\n';
    }
}