function solve(steps, footprint, speed) {
    let distanceInMeters = steps * footprint;
    let speedInSec = speed / 3.6;
    let time = distanceInMeters / speedInSec;
    let res = Math.floor(distanceInMeters / 500);

    let timeInMinutes = Math.floor(time / 60);
    let timeInSec = Number(time - (timeInMinutes * 60)).toFixed(0);
    let timeInH = Math.floor(time / 3600);
    timeInMinutes += res;
    timeInH += Math.floor(timeInMinutes / 60);
    timeInMinutes = timeInMinutes % 60;

    let formattedH = timeInH < 10 ? `0${timeInH}` : `${timeInH}`;
    let formattedM = timeInMinutes < 10 ? `0${timeInMinutes}` : `${timeInMinutes}`;
    let formattedS = timeInSec < 10 ? `0${timeInSec}` : `${timeInSec}`

    console.log(`${formattedH}:${formattedM}:${formattedS}`);

}

solve(4000, 0.60, 5);
solve(2564, 0.70, 5.5);

