function notify(message) {

  let notification = document.getElementById('notification');

  notification.textContent = message;
  notification.style.display = 'block';

  notification.addEventListener('click', myFunc);

  function myFunc(event) {
    notification.style.display = 'none';

  }

}