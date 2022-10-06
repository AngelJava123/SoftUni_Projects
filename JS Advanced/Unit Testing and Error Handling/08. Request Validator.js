function solve(obj) {

    let methods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    let versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    let regexURI = /^[\w\[.\]\\]+$/
    let regexMessage = /^[^<>\\&'"\r\n]+$/

    if (!methods.includes(obj.method)) {
        throw new Error("Invalid request header: Invalid Method");
    }
    if (!obj.hasOwnProperty('uri')) {
        throw new Error("Invalid request header: Invalid URI");
    }
     if (!obj.uri.match(regexURI) && obj.uri !== '*') {
        throw new Error("Invalid request header: Invalid URI");
    } 
    if (!versions.includes(obj.version)) {
        throw new Error("Invalid request header: Invalid Version");
    } 
    if (!obj.hasOwnProperty('message')) {
        throw new Error("Invalid request header: Invalid Message");
    }
    if (!obj.message.match(regexMessage) && obj.message !== '') {
        throw new Error("Invalid request header: Invalid Message");
    } 

    return obj
}


console.log(solve({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
}));

onsole.log(solve({
    method: 'OPTIONS',
    uri: 'git.master',
    version: 'HTTP/1.1',
    message: '-recursive'
}));

console.log(solve({
    method: 'POST',
    uri: 'home.bash',
    message: 'rm -rf /*'
}));