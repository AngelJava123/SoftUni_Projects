window.addEventListener("load", solve);

function solve() {
  let sendBittonElement = document.querySelector('#right form button')
  sendBittonElement.addEventListener('click', sendInfo)

  let productTypeSelectElement = document.querySelector('#type-product')
  let descriptionTextAreaElement = document.querySelector('#description')
  let clientNameElement = document.querySelector('#client-name')
  let clientPhoneElement = document.querySelector('#client-phone')

  let receivedOrders = document.querySelector('#received-orders')
  let completeOrders = document.querySelector('#completed-orders')

  let clearBtnElement = document.querySelector('#completed-orders button')
  clearBtnElement.addEventListener('click', clearOrders)

  function sendInfo(e) {
    e.preventDefault()

    let productType = productTypeSelectElement.value;
    let description = descriptionTextAreaElement.value;
    let clientName = clientNameElement.value;
    let clientPhone = clientPhoneElement.value;

    if (description == '' || clientName == '' || clientPhone == '' || productType == '') {
      return
    }

    productTypeSelectElement.value = ''
    descriptionTextAreaElement.value = ''
    clientNameElement.value = ''
    clientPhoneElement.value = ''

    let containerDivElement = document.createElement('div');
    containerDivElement.classList.add('container')

    let h2Element = document.createElement('h2')
    h2Element.textContent = `Product type for repair: ${productType}`

    let h3Element = document.createElement('h3')
    h3Element.textContent = `Client information: ${clientName}, ${clientPhone}`

    let h4Element = document.createElement('h4')
    h4Element.textContent = `Description of the problem: ${description}`

    let startButton = document.createElement('button')
    startButton.classList.add('start-btn')
    startButton.textContent = 'Start Repair'

    let finishButton = document.createElement('button')
    finishButton.classList.add('finish-btn')
    finishButton.textContent = 'Finish Repair'
    finishButton.disabled = true;

    startButton.addEventListener('click', startRepair)
    finishButton.addEventListener('click', finishRepair)

    containerDivElement.appendChild(h2Element)
    containerDivElement.appendChild(h3Element)
    containerDivElement.appendChild(h4Element)
    containerDivElement.appendChild(startButton)
    containerDivElement.appendChild(finishButton)

    receivedOrders.appendChild(containerDivElement)

  }

  function startRepair(e) {
    e.currentTarget.disabled = true;

    e.currentTarget.parentNode.querySelector('.finish-btn').disabled = false;
  }
  function finishRepair(e) {
    let containerDiv = e.currentTarget.parentNode;
    e.currentTarget.remove()

    containerDiv.querySelector('.start-btn').remove()

    containerDiv.remove()
    completeOrders.appendChild(containerDiv)
  }

  function clearOrders(e) {
    let allContainers = Array.from(e.currentTarget.parentNode.querySelectorAll('.container'))

    for (const container of allContainers) {
      container.remove()
    }
  }
}
