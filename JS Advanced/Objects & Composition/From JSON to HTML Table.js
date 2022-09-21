function solve(input) {

    parsedJSON = JSON.parse(input);

    let str = [];

    let indicator = 0;

    str.push(`<tr><th>`)

    let final = [];

    final.push(`<tr><td>`)

    console.log('<table>')

    parsedJSON.forEach(element => {
        for (let key in element) {

            if (indicator == 0) {
                str.push(`${escapeHTML(key)}`);
                str.push(`</th><th>`);
            }
        }
        indicator++;
    })
    str.pop();
    str.push(`</th></tr>`);

    parsedJSON.forEach(element => {
        for (let key in element) {

            final.push(`${escapeHTML(element[key])}`);
            final.push(`</td><td>`);
        }
        final.pop();
        final.push(`</td></tr>`);
        final.push(`<tr><td>`);
    })
    final.pop();

    console.log(`   ${str.join("")}`)
    //console.log(`    ${final.join("")}`)

    let res = "   ";

    let flag = false;

    for (let i = 0; i < final.length; i++) {
        if (final[i] === '</td></tr>') {
            flag = true;
            res += final[i];
        } else {
            res += final[i];
        }

        if (flag) {
            console.log(res);
            res = "   ";
            flag = false;
        }
    }
    console.log('</table>')

    function escapeHTML(value) {
        return value
            .toString()
            .replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }

}

//<table>
//   <tr><th>Name</th><th>Score</th></tr>
//   <tr><td>Stamat</td><td>5.5</td></tr>
//   <tr><td>Rumen</td><td>6</td></tr>
//</table>


solve(`[{"Name":"Stamat",
"Score":5.5},
{"Name":"Rumen",
"Score":6}]`
);

solve(`[{"Name":"Pesho",
"Score":4,
" Grade":8},
{"Name":"Gosho",
"Score":5,
" Grade":8},
{"Name":"Angel",
"Score":5.50,
" Grade":10}]`
);
