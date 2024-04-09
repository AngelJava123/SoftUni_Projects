function inputPerson(param1: string, param2: string, param3: string): void {

    const products =  { ["FirstName"]: param1, ["lastName"]: param2, ["age"]: param3};
    console.log("FirstName:", products["FirstName"] + "\nLastName:", products["lastName"] + "\nage:", products["age"]);
}

inputPerson("Peter","Pan","20");
inputPerson("George", "Smith","18");