window.addEventListener("load", solve);

function solve() {

  let res = 0;

  let make = document.getElementById('make');
  let model = document.getElementById('model');
  let year = document.getElementById('year');
  let fuel = document.getElementById('fuel');

  let originalCost = document.getElementById('original-cost');
  let sellingPrice = document.getElementById('selling-price');

  let publishedCarList = document.getElementById('table-body');
  let carsList = document.getElementById('cars-list');

  let profit = document.getElementById('profit');

  document.getElementById('publish').addEventListener('click', publish);

  function publish(e) {
    e.preventDefault();

    let makeValue = make.value;
    let modelValue = model.value;
    let yearValue = year.value;
    let fuelValue = fuel.value;

    let originalCostValue = parseInt(originalCost.value);
    let sellingPriceValue = parseInt(sellingPrice.value);

    if (makeValue == '' || modelValue == '' || yearValue == '' || fuelValue == '' || originalCostValue == '' || sellingPriceValue == '' || originalCostValue > sellingPriceValue) {
      return;
    }

    const tr = document.createElement('tr');
    tr.className = 'row';
    tr.innerHTML = `<td>${makeValue}</td>
                    <td>${modelValue}</td>
                    <td>${yearValue}</td>
                    <td>${fuelValue}</td>
                    <td>${originalCostValue}</td>
                    <td>${sellingPriceValue}</td>
                    <td><button class="action-btn edit">Edit</button>
                    <button class="action-btn sell">Sell</button></td`;

    const editBtn = tr.querySelector('.edit');
    const sellBtn = tr.querySelector('.sell')
    editBtn.addEventListener('click', edit);
    sellBtn.addEventListener('click', sell);

    publishedCarList.appendChild(tr);

    make.value = '';
    model.value = '';
    year.value = '';
    fuel.value = '';
    originalCost.value = '';
    sellingPrice.value = '';

    function edit() {
      // populate input fields with values
      make.value = makeValue;
      model.value = modelValue;
      year.value = yearValue;
      fuel.value = fuelValue;
      originalCost.value = originalCostValue;
      sellingPrice.value = sellingPriceValue;

      // remove list item from list
      tr.remove();
    }

    function sell() {

      let difference = sellingPriceValue - originalCostValue;
      const li = document.createElement('li');
      li.className = 'each-list';
      li.innerHTML = `<span>${makeValue} ${modelValue}</span>
                      <span>${yearValue}</span>
                      <span>${difference}</span>`;

      carsList.appendChild(li);
      // remove action buttons
      editBtn.remove();
      sellBtn.remove();

      tr.remove();

      res += difference;

      profit.textContent = Math.round(res).toFixed(2);
    }
  }
}
