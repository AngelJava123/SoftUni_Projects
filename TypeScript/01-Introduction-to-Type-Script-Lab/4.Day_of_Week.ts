function dayOfWeek(day: string): string {

    enum result {
        Monday = 1,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    }

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