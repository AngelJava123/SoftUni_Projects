function solve(speed, area) {

    let motowayLimit = 130;
    let interstateLimit = 90;
    let cityLimit = 50;
    let residentialLimit = 20;

    switch (area) {
        case 'motorway': speedLimit(speed, motowayLimit); break;
        case 'interstate': speedLimit(speed, interstateLimit); break;
        case 'city': speedLimit(speed, cityLimit); break;
        case 'residential': speedLimit(speed, residentialLimit); break;
    }

    function speedLimit(speed, limit) {
        if (speed <= limit) {
            console.log(`Driving ${speed} km/h in a ${limit} zone`);
        } else {
            let overSpeeding = speed - limit;
            let status = "";

            status = speeding(overSpeeding, status);
            console.log(`The speed is ${overSpeeding} km/h faster than the allowed speed of ${limit} - ${status}`);
        }
    }

    function speeding(overSpeeding, status) {
        if (overSpeeding <= 20) {
            status = 'speeding';
        } else if (overSpeeding <= 40) {
            status = 'excessive speeding';
        } else {
            status = 'reckless driving';
        }
        return status;
    }
}

solve(40, 'city');
solve(21, 'residential');
solve(120, 'interstate');
solve(200, 'motorway');
