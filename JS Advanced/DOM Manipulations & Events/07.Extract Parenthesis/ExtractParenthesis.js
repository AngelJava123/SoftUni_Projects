function extract(content) {
    let elementText = document.getElementById(content).textContent;

    let pattern = /\(([^)]+)\)/g;

    let result = elementText.matchAll(pattern);

    let matches = [];

    for (const text of result) {
        matches.push(text[1]);
    }

    debugger

    return matches.join('; ')

    
}