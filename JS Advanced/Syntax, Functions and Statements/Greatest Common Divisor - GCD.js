function gcd_two_numbers(x, y) {

    x = Math.abs(x);
    y = Math.abs(y);
    while(y) {
      let t = y;
      y = x % y;
      x = t;
    }
    return x;
  }
  
  console.log(gcd_two_numbers(15, 5));
  console.log(gcd_two_numbers(2154, 458));

//Second Solution

function gcd2(num1, num2) {
    let gcd = num2;

    while (!(num1 % gcd == 0 && num2 % gcd == 0)) {
        gcd--;
    }

    console.log(gcd);
  }

  gcd2(15, 5);
  gcd2(2154, 458);
