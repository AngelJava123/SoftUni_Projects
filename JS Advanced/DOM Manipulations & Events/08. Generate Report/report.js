function generateReport() {
   // let rows = Array.from(document.querySelectorAll('input[type="checkbox"]:checked'));


    [].slice.call(document.querySelectorAll('input[type="checkbox"]:checked'), 1).forEach(function(row){
        row.addEventListener("click", function(){
             var ths = document.querySelectorAll('input[type="checkbox"]:checked');
             var obj = [].reduce.call(ths, function(obj, th, i){
                 obj[th.textContent] = row.cells[i].textContent;
                 return obj;
             }, {});
             console.log(obj);
        });
  });

  debugger
}