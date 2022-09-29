function create(words) {

   let content = document.getElementById('content');

   for (const word of words) {
      let div = document.createElement('div');
      let p = document.createElement('p');
      p.style.display = 'none';
      p.textContent = word;
      div.appendChild(p);
      div.addEventListener('click', function (ev) { p.style.display = 'block' });
      content.appendChild(div);
   }
}