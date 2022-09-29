function attachEventsListeners() {

    Array.from(document.querySelectorAll('input[type=button]')).forEach(occurence => {
        let id = occurence.getAttribute('id');
        occurence.addEventListener('click', function (event) {
            let getNumber = Number(event.target.parentElement.querySelector('input[type=text]').value);

            let days = document.getElementById('days');
            let hours = document.getElementById('hours');
            let minutes = document.getElementById('minutes');
            let seconds = document.getElementById('seconds');

            if (id === 'daysBtn') {
                hours.value = getNumber * 24;
                minutes.value = getNumber * 24 * 60;
                seconds.value = getNumber * 24 * 60 * 60;
            }

            if (id === 'hoursBtn') {
                days.value = getNumber / 24;
                minutes.value = getNumber * 60;
                seconds.value = getNumber * 60 * 60;
            }

            if (id === 'minutesBtn') {
                days.value = getNumber / 1440;
                hours.value = getNumber / 60;
                seconds.value = getNumber * 60;
            }

            if (id === 'secondsBtn') {
                days.value = getNumber / 86400;
                hours.value = getNumber / 3600;
                minutes.value = getNumber / 60;
            }
        });
    });
}