function solve(speed, area) {

    if (area === 'motorway') {
        if (speed <= 130) {
            console.log(`Driving ${speed} km/h in a 130 zone`)
        } else {
           let overSpeeding = speed - 130;
           let status = "";
            
           status = speeding(overSpeeding, status);
           console.log(`The speed is ${overSpeeding} km/h faster than the allowed speed of 130 - ${status}`);
        }
    } else if (area === 'interstate') {
        if (speed <= 90) {
            console.log(`Driving ${speed} km/h in a 90 zone`)
        } else {
           let overSpeeding = speed - 90;
           let status = "";
            
           status = speeding(overSpeeding, status);
           console.log(`The speed is ${overSpeeding} km/h faster than the allowed speed of 90 - ${status}`);
        }
    } else if (area === 'city') {
        if (speed <= 50) {
            console.log(`Driving ${speed} km/h in a 50 zone`)
        } else {
           let overSpeeding = speed - 50;
           let status = "";
            
           status = speeding(overSpeeding, status);
           console.log(`The speed is ${overSpeeding} km/h faster than the allowed speed of 50 - ${status}`);
        }
    } else if (area === 'residential') {
        if (speed <= 20) {
            console.log(`Driving ${speed} km/h in a 20 zone`)
        } else {
           let overSpeeding = speed - 20;
           let status = "";
            
           status = speeding(overSpeeding, status);
           console.log(`The speed is ${overSpeeding} km/h faster than the allowed speed of 20 - ${status}`);
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
