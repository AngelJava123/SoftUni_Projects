function solve() {

    let recipientName = document.getElementById('recipientName')
    let title = document.getElementById('title')
    let message = document.getElementById('message')

    let add = document.getElementById('add')
    let reset = document.getElementById('reset')

    let list = document.getElementById('list')
    let sentList = document.querySelector('.sent-list')
    let deleteList = document.querySelector('.delete-list')

    add.addEventListener('click', addFunc);
    reset.addEventListener('click', resetFunc);

    function addFunc(e) {
        e.preventDefault();

        let recipientNameValue = recipientName.value;
        let titleValue = title.value;
        let messageValue = message.value;

        if (recipientNameValue == '' || titleValue == '' || messageValue == '') {
            return
        };

        const li = document.createElement('li')
        li.innerHTML = `<h4>Title: ${titleValue}</h4>
                       <h4>Recipient Name: ${recipientNameValue}</h4>
                       <span>${messageValue}</span>
                      <div id="list-action">
                         <button type="submit" id="send">Send</button>
                         <button type="submit" id="delete">Delete</button>
                     </div>`;

        const sendBtn = li.querySelector('#send');
        const deleteBtn = li.querySelector('#delete')
        sendBtn.addEventListener('click', sendFunc);
        deleteBtn.addEventListener('click', deleteFunc);

        list.appendChild(li);

        recipientName.value = '';
        title.value = '';
        message.value = '';

        function sendFunc() {
            const liSent = document.createElement('li')
            liSent.innerHTML = `<span>To: ${recipientNameValue}</span>
                           <span>Title: ${titleValue}</span>
                           <div class="btn">
                              <button type="submit" class="delete">Delete</button>
                           </div>`;

            sentList.appendChild(liSent);
            // remove action buttons
            deleteBtn.remove();
            sendBtn.remove();

            li.remove();

            const btn = liSent.querySelector('.delete');
            btn.addEventListener('click', deleteSent);

            function deleteSent() {
                const liDeleteSent = document.createElement('li')
                liDeleteSent.innerHTML = `<span>To: ${recipientNameValue}</span>
                                          <span>Title: ${titleValue}</span>`;

                deleteList.appendChild(liDeleteSent);

                liSent.remove();
                btn.remove();
            }
        }

        function deleteFunc() {
            const liDelete = document.createElement('li')
            liDelete.innerHTML = `<span>To: ${recipientNameValue}</span>
                                 <span>Title: ${titleValue}</span>`;

            deleteList.appendChild(liDelete);

            deleteBtn.remove();
            sendBtn.remove();

            li.remove();
        }

    }

    function resetFunc(e) {
        e.preventDefault();

        recipientName.value = '';
        title.value = '';
        message.value = '';
    }
}
solve()