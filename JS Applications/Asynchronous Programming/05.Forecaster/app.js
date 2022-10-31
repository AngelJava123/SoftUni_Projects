function attachEvents() {
    // Get all elements
    // define weather symbols
    // define upcoming and current weather divs
    // getButton => eventListener
    // fetch location data from server -> name, code
    // code => fetch forecast for today
    // update html with forecast day
    // fetch upcoming forecast
    // update html based on data

    let inputElement = document.getElementById('location')
    let getButton = document.getElementById('submit')
    let divDisplay = document.getElementById('forecast')
    let currentDiv = document.getElementById('current')
    let upcomingDiv = document.getElementById('upcoming')
    let sunny = '&#x2600'; // ☀
    let partlySunny = '&#x26C5'; // ⛅
    let overcast = '&#x2601'; // ☁
    let rain = '&#x2614'; // ☂
    let degrees = '&#176';   // °
    let code = '';
    let divElementUpcoming = document.createElement('div')
    let divElementCurrent = document.createElement('div')

    getButton.addEventListener('click', (e) => {
        divElementUpcoming.innerHTML = '';
        divElementCurrent.innerHTML = '';

        divElementUpcoming.className = 'forecast-info';
        divElementCurrent.className = 'forecasts';

        divDisplay.style.display = 'inline';

        fetch(`http://localhost:3030/jsonstore/forecaster/locations`)
            .then(response => response.json())
            .then(data => {
                data.forEach(locationInObject => {
                    if (locationInObject.name == inputElement.value) {
                        return code = locationInObject.code;
                    }
                });

                fetch(`http://localhost:3030/jsonstore/forecaster/today/${code}`)
                    .then(response => response.json())
                    .then(data => {
                        let condition = data.forecast.condition;
                        let spanIcon = '';
                        if (condition == 'Sunny') {
                            spanIcon = sunny;
                        } else if (condition == 'Partly sunny') {
                            spanIcon = partlySunny;
                        } else if (condition == 'Overcast') {
                            spanIcon = overcast;
                        } else if (condition == 'Rain') {
                            spanIcon = rain;
                        }
                        divElementCurrent.innerHTML = `<span class="condition symbol">${spanIcon}</span>
                                                 <span class="condition">
                                                 <span class="forecast-data">${data.name}</span>
                                                 <span class="forecast-data">${data.forecast.low}${degrees}/${data.forecast.high}${degrees}</span>
                                                 <span class="forecast-data">${data.forecast.condition}</span>
                                                 </span>`;

                        currentDiv.appendChild(divElementCurrent);
                    })
                    .catch(error => console.log(error))

                fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${code}`)
                    .then(response => response.json())
                    .then(data => {

                        let nextDays = data.forecast;
                        nextDays.forEach(x => {
                            let spanGroup = document.createElement('span')
                            let conditionSpan = document.createElement('span')
                            let temperatureSpan = document.createElement('span')
                            let spanWithIcon = document.createElement('span')

                            spanWithIcon.setAttribute('class', 'symbol')
                            spanGroup.setAttribute('class', 'upcoming')
                            temperatureSpan.setAttribute('class', 'forecast-data')
                            conditionSpan.setAttribute('class', 'forecast-data')

                            temperatureSpan.innerHTML = `${x.low}${degrees}/${x.high}${degrees}`;
                            conditionSpan.textContent = x.condition;
                            let condition = x.condition;
                            if (condition == 'Sunny') {
                                spanWithIcon.innerHTML = sunny;
                            } else if (condition == 'Partly sunny') {
                                spanWithIcon.innerHTML  = partlySunny;
                            } else if (condition == 'Overcast') {
                                spanWithIcon.innerHTML  = overcast;
                            } else if (condition == 'Rain') {
                                spanWithIcon.innerHTML  = rain;
                            }
                           
                            spanGroup.appendChild(spanWithIcon)
                            spanGroup.appendChild(temperatureSpan)
                            spanGroup.appendChild(conditionSpan)
                            divElementUpcoming.appendChild(spanGroup)
                            upcomingDiv.appendChild(divElementUpcoming);

                        })
                    })
            })
    })
}

attachEvents();