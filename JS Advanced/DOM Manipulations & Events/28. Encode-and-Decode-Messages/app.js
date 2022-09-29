function encodeAndDecodeMessages() {

    let btn1 = document.querySelectorAll('button')[0];
    let btn2 = document.querySelectorAll('button')[1];

    btn1.addEventListener('click', myFunc1);
    btn2.addEventListener('click', myFunc2);

    function myFunc1(event) {
        let textToDecode = document.querySelectorAll('textarea')[0].value;

        let convertedText = "";

        for (let i = 0; i < textToDecode.length; i++) {
            convertedText += String.fromCharCode(textToDecode[i].charCodeAt() + 1)

        }

        document.querySelectorAll('textarea')[1].value = convertedText;

        document.querySelectorAll('textarea')[0].value = "";
    }


    function myFunc2(event) {
        let textToDecode = document.querySelectorAll('textarea')[1].value;

        let convertedText = "";

        for (let i = 0; i < textToDecode.length; i++) {
            convertedText += String.fromCharCode(textToDecode[i].charCodeAt() - 1)
        }

        document.querySelectorAll('textarea')[1].value = convertedText;
    }
}