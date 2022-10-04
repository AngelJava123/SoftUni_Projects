function solve(str1, str2) {

    let card = {
        face: '',
        suit: ''
    };

    let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    if (!validFaces.includes(str1)) {
        throw new Error;
    } else {
        card.face = str1
        if (str2 === 'S') {
            card.suit = '\u2660';
        } else if (str2 === 'H') {
            card.suit = '\u2665';
        } else if (str2 === 'D') {
            card.suit = '\u2666';
        } else if (str2 === 'C') {
            card.suit = '\u2663';
        }
    }
    return `${card.face.toString()}${card.suit.toString()}`;
}

console.log(solve('10', 'H'));
console.log(solve('A', 'S'));
solve('1', 'C');