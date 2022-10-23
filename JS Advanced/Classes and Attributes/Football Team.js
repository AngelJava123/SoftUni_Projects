class footballTeam {
    constructor(clubName, country) {
        this.clubName = clubName;
        this.country = country;
        this.invitedPlayers = [];
    }

    newAdditions(footballPlayers) {

        let res = [];

        for (const player of footballPlayers) {
            let [name, age, playerValue] = player.split('/');

            let playerArr = this.invitedPlayers.find(p => p.name == name);

            if (playerArr != undefined) {
                if (Number(playerValue) > Number(playerArr.playerValue)) {
                    Number(playerArr.playerValue) = Number(playerValue);
                }
            } else {
                this.invitedPlayers.push({ name, age, playerValue });
            }

            res.push(name);
        }

        let unique = [...new Set(res)];
        return `You successfully invite ${unique.join(', ')}.`
    }

    signContract(selectedPlayer) {
        //"{name}/{playerOffer}"

        let [name, playerOffer] = selectedPlayer.split('/');

        let playerName = this.invitedPlayers.find(p => p.name == name);

        if (playerName === undefined) {
            throw new Error(`"${name} is not invited to the selection list!"`)
        }

        if (Number(playerOffer) < Number(playerName.playerValue)) {
            let priceDifference = Number(playerName.playerValue) - Number(playerOffer);
            throw new Error(`The manager's offer is not enough to sign a contract with ${name}, ${priceDifference} million more are needed to sign the contract!`)
        }

        playerName.playerValue = 'Bought';
        return `Congratulations! You sign a contract with ${name} for ${playerOffer} million dollars.`
     }

     ageLimit(name, age) {
        let playerName = this.invitedPlayers.find(p => p.name == name);

        if (playerName === undefined) {
            throw new Error(`"${name} is not invited to the selection list!"`)
        }

        if (Number(playerName.age) < Number(age)) {
            let diff = Number(age) - Number(playerName.age);
            if (diff < 5) {
                return `${name} will sign a contract for ${diff} years with ${this.clubName} in ${this.country}!`
            } else if (diff > 5) {
                return `${name} will sign a full 5 years contract for ${this.clubName} in ${this.country}!`
            }
        }

        if (Number(playerName.age) >= Number(age)) {
            return `${name} is above age limit!`
        }
     }

     transferWindowResult() {
        let res = ['Players list:'];

        this.invitedPlayers.sort((a, b) => a.name - b.name);
        this.invitedPlayers.forEach((v) => res.push(`Player ${v.name}-${v.playerValue}`))

        return res.join('\n')
     }
}

let fTeam = new footballTeam("Barcelona", "Spain");
console.log(fTeam.newAdditions(["Kylian Mbappé/23/160", "Lionel Messi/35/50", "Pau Torres/25/52"]));
console.log(fTeam.signContract("Kylian Mbappé/240"));
console.log(fTeam.ageLimit("Kylian Mbappé", 30));
console.log(fTeam.transferWindowResult());