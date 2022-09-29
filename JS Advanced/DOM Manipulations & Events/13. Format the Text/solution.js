function solve() {
  let text = document.getElementById('input').value;
  let output = document.getElementById('output');
  output.innerHTML = "";
  let splitArr = text.split('.').filter(x=> x.length > 0);

  for (let i = 0; i < splitArr.length; i += 3) {
    let res = [];
    for (let x = 0; x < 3; x++) {
      if (splitArr[i + x]) {
        res.push(splitArr[i + x]);
      }
    }
    let result = res.join('. ') + '.';
    output.innerHTML += `<p>${result}</p>`;
  }
}