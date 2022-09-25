function solve() {
  let text = document.getElementById('text').value;
  let convention = document.getElementById('naming-convention').value;

  let res = "";
  let arr = text.split(' ');

  if (convention === 'Camel Case') {
    for (let i = 0; i < arr.length; i++) {

      let word = arr[i].toString().toLowerCase();

      if (res.length === 0) {
        res += word;
        continue;
      }

      let wordConvert = word.charAt(0).toUpperCase() + word.slice(1);

      res += wordConvert;
    }
  } else if (convention === 'Pascal Case') {
    for (let i = 0; i < arr.length; i++) {

      let word = arr[i].toString().toLowerCase();

      let wordConvert = word.charAt(0).toUpperCase() + word.slice(1);

      res += wordConvert;
    }
  } else {
    res += 'Error!'
  }

  document.getElementById('result').innerText = res;
}