function printDeckOfCards(cards) {

    let invalid = false;

    function createCard(str1, str2) {
        let card = {
            face: '',
            suit: ''
        };

        let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        let validSuites = ['S', 'H', 'D', 'C'];

        if (!validFaces.includes(str1) || !validSuites.includes(str2)) {
            invalid = true;
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

        if (invalid) {
            return `Invalid card: ${str1}${str2}`;
        }
        return `${card.face.toString()}${card.suit.toString()}`;
    }

    let result = [];
    let inv = [];

    let face1 = '';
    let suite = '';
    for (const element of cards) {
        if (element.length == 3) {
            face1 = '10';
            suite = element[2].toString();
            let res = createCard(face1, suite);
            if (invalid) {
                inv.push(res)
                break;
            } else {
                result.push(res)
            }
        } else {
            face1 = element[0].toString();
            suite = element[1].toString();
            let res = createCard(face1, suite);
            if (invalid) {
                inv.push(res)
                break;
            } else {
                result.push(res)
            }
        }
    }

    if (invalid) {
        console.log(inv[0].toString());
        return
    }
    console.log(result.join(' '));
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);
printDeckOfCards(['5S', '3D', 'QD', '5X']);
