function solve(str) {

    let words = "";

    let result = str.match(/\w+/g);

    for (let i = 0; i < result.length; i++) {
        
        let w = result[i].replace(/[^a-zA-Z][0-9]+/g, '');
        let upperCase = w.toUpperCase();

        if(!((i + 1) == (result.length))){
            words += `${upperCase}, `;
        } else {
            words += upperCase;
        }
        
    }

    console.log(words);
}

solve('Hi, how are you?');
solve('hello')

solve('Functions in JS can43 be32 nested, i.e. hold other functions');

///("[^"]+"|[^"\s]+)/g
///(\w+)/g