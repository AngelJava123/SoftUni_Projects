function dayOfWeek(day) {
    let result;
    (function (result) {
        result[result["Monday"] = 1] = "Monday";
        result[result["Tuesday"] = 2] = "Tuesday";
        result[result["Wednesday"] = 3] = "Wednesday";
        result[result["Thursday"] = 4] = "Thursday";
        result[result["Friday"] = 5] = "Friday";
        result[result["Saturday"] = 6] = "Saturday";
        result[result["Sunday"] = 7] = "Sunday";
    })(result || (result = {}));
    for (const key in result) {
        if (key.match(day)) {
            return result[day];
        }
    }
    return 'error';
}
console.log(dayOfWeek('Monday'));
console.log(dayOfWeek('Friday'));
console.log(dayOfWeek('Invalid'));
