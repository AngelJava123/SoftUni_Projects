function focused() {
    let focused = document.getElementsByTagName('input');

    for (let item of focused) {

        item.addEventListener('focus', focusInput);
        item.addEventListener('blur', blurInput);
    }

    function focusInput(event) {
        event.target.parentElement.classList.add('focused')
    }

    function blurInput(event) {
        event.target.parentElement.classList.remove('focused')
    }
}