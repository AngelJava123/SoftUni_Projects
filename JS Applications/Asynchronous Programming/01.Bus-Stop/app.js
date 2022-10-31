function getInfo() {

    const stopId = document.getElementById('stopId').value;
    const stopName = document.getElementById('stopName');
    const busesElement = document.getElementById('buses');

    fetch(`http://localhost:3030/jsonstore/bus/businfo/${stopId}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            let name = data.name;
            let busData = data.buses;

            stopName.textContent = name;
            busesElement.innerHTML = '';

            Object.entries(busData).forEach(el => {
                let liElement = document.createElement('li')
                liElement.textContent = `Bus ${el[0]} arrives in ${el[1]} minutes`;
                busesElement.appendChild(liElement);
            })
        })
        .catch(err => {
            stopName.textContent = 'Error';
            busesElement.innerHTML = '';
        });
}
