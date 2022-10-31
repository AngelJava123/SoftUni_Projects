function solve() {
    // Get all elements
    // depart func -> fetch data for next stop, start from 'depot'
    // update infoElement with text from server data
    // arrive button disabled = false
    // arrive func -> update buttons

    let infoElement = document.querySelector('.info')
    let departButton = document.getElementById('depart')
    let arriveButton = document.getElementById('arrive')

    let busStop = {
        next: 'depot'
    }

    function depart() {
        departButton.disabled = true;
        fetch(`http://localhost:3030/jsonstore/bus/schedule/${busStop.next}`)
            .then(response => response.json())
            .then(data => {
                busStop = Object.assign(data);
                infoElement.textContent = `Next stop ${busStop.name}`
            })
            .catch(error => console.log(error))
        arriveButton.disabled = false;
    }

    function arrive() {
        infoElement.textContent = `Arriving at ${busStop.name}`;
        departButton.disabled = false;
        arriveButton.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();