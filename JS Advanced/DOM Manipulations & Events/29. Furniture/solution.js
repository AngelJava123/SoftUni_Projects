function solve() {

  let btn1 = document.querySelectorAll('button')[0];
  let btn2 = document.querySelectorAll('button')[1];

  btn1.addEventListener('click', myFunc);
  btn2.addEventListener('click', myFunc2);

  function myFunc(event) {
    let converted = Array.from(JSON.parse(document.getElementsByTagName('textarea')[0].value));

    for (const item of converted) {
      let tr = document.createElement('tr');
      let td1 = document.createElement('td');
      let img = document.createElement('img');
      img.src = item.img;

      td1.appendChild(img);
      tr.appendChild(td1);

      let td2 = document.createElement('td');
      let p1 = document.createElement('p');
      p1.textContent = item.name;

      td2.appendChild(p1);
      tr.appendChild(td2);

      let td3 = document.createElement('td');
      let p2 = document.createElement('p');
      p2.textContent = item.price;

      td3.appendChild(p2);
      tr.appendChild(td3);

      let td4 = document.createElement('td');
      let p3 = document.createElement('p');
      p3.textContent = item.decFactor;

      td4.appendChild(p3);
      tr.appendChild(td4);

      let td5 = document.createElement('td');
      let input = document.createElement('input');

      input.type = "checkbox";

      td5.appendChild(input);
      tr.appendChild(td5);

      document.querySelector('tbody').appendChild(tr);
    }
  }

  function myFunc2(event) {
    let allChecked = document.querySelectorAll('input[type="checkbox"]:checked');

    let arr = [];
    let totalPrice = 0;
    let avgDecFac = 0;

    for (const item of allChecked) {

      arr.push(item.parentElement.parentElement.querySelectorAll('td p')[0].textContent);
      totalPrice += Number(item.parentElement.parentElement.querySelectorAll('td p')[1].textContent);
      avgDecFac += Number(item.parentElement.parentElement.querySelectorAll('td p')[2].textContent);
    }

    document.getElementsByTagName('textarea')[1].value += `Bought furniture: ${arr.join(', ')}` + `\n`;
    document.getElementsByTagName('textarea')[1].value += `Total price: ${totalPrice.toFixed(2)}` + `\n`;
    document.getElementsByTagName('textarea')[1].value += `Average decoration factor: ${avgDecFac / allChecked.length}`
  }
}