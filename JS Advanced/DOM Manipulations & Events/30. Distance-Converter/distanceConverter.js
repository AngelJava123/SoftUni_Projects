function attachEventsListeners() {

    let btnConvert = document.getElementById('convert');
    let final = document.querySelector('#outputDistance');

    btnConvert.addEventListener('click', myFunc);

    let enumType = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254
    };

    function myFunc(event) {
        let inputValue = document.getElementById('inputDistance').value;

        let selectedValue = event.target.parentElement.querySelector('#inputUnits').value;

        let selectedToConvert = event.target.parentElement.parentElement.querySelector('#outputUnits').value;

        let convertedIntoMeters = 0;
        let finalRes = 0;

        if (selectedValue === 'km') {
            convertedIntoMeters += inputValue * enumType.km;
        } else if (selectedValue === 'm') {
            convertedIntoMeters += inputValue * enumType.m;
        } else if (selectedValue === 'cm') {
            convertedIntoMeters += inputValue * enumType.cm;
        } else if (selectedValue === 'mm') {
            convertedIntoMeters += inputValue * enumType.mm;
        } else if (selectedValue === 'mi') {
            convertedIntoMeters += inputValue * enumType.mi;
        } else if (selectedValue === 'yrd') {
            convertedIntoMeters += inputValue * enumType.yrd;
        } else if (selectedValue === 'ft') {
            convertedIntoMeters += inputValue * enumType.ft;
        } else if (selectedValue === 'in') {
            convertedIntoMeters += inputValue * enumType.in;
        }

        if (selectedToConvert === 'km') {
            finalRes += convertedIntoMeters / enumType.km;
        } else if (selectedToConvert === 'm') {
            finalRes += convertedIntoMeters / enumType.m;
        } else if (selectedToConvert === 'cm') {
            finalRes += convertedIntoMeters / enumType.cm;
        } else if (selectedToConvert === 'mm') {
            finalRes += convertedIntoMeters / enumType.mm;
        } else if (selectedToConvert === 'mi') {
            finalRes += convertedIntoMeters / enumType.mi;
        } else if (selectedToConvert === 'yrd') {
            finalRes += convertedIntoMeters / enumType.yrd;
        } else if (selectedToConvert === 'ft') {
            finalRes += convertedIntoMeters / enumType.ft;
        } else if (selectedToConvert === 'in') {
            finalRes += convertedIntoMeters / enumType.in;
        }

        final.value = finalRes;
    }
}
