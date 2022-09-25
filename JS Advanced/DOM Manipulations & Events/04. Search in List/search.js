function search() {
   let towns = Array.from(document.querySelectorAll('ul li'));
   let search = document.getElementById('searchText').value;

   let count = 0;
   for (const item of towns) {
      let text = item.textContent;

      if (text.includes(search)) {
         item.style.fontWeight = 'bold';
         item.style.textDecoration = 'underline';
         count++;
      } else {
         item.style.fontWeight = 'normal';
         item.style.textDecoration = 'none';
      }
   }
      document.getElementById('result').innerText = `${count} matches found`;
}

