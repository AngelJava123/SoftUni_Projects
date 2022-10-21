class SummerCamp {
    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = { "child": 150, "student": 300, "collegian": 500 };
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        if (!this.priceForTheCamp.hasOwnProperty(condition)) {
            throw new Error('Unsuccessful registration at the camp.');
        }

        let participant = this.listOfParticipants.find(p => p.name == name);

        if (participant != undefined) {
            return `The ${name} is already registered at the camp.`
        }

        if (money < this.priceForTheCamp[condition]) {
            return `The money is not enough to pay the stay at the camp.`
        }

        this.listOfParticipants.push({ name, condition, power: 100, wins: 0 })
        return `The ${name} was successfully registered.`
    }

    unregisterParticipant(name) {

        let participant = this.listOfParticipants.find(p => p.name == name);

        if (participant === undefined) {
            throw new Error(`The ${name} is not registered in the camp.`)
        }

        this.listOfParticipants = this.listOfParticipants.filter((p) => p.name != name);
        return `The ${name} removed successfully.`
    }

    timeToPlay(typeOfGame, participant1, participant2) {

        let participantOne = this.listOfParticipants.find(p => p.name == participant1);
        let participantTwo = this.listOfParticipants.find(p => p.name == participant2);

        if (participantOne === undefined || (participantTwo === undefined && typeOfGame === 'WaterBalloonFights')) {
            throw new Error(`Invalid entered name/s.`)
        }

        if (typeOfGame === 'WaterBalloonFights' && participantOne.condition != participantTwo.condition) {
            throw new Error(`Choose players with equal condition.`)
        }

        if (typeOfGame === 'WaterBalloonFights') {
            if (participantOne.power > participantTwo.power) {
                participantOne.wins++
                return `The ${participant1} is winner in the game ${typeOfGame}.`
            } else {
                return `There is no winner.`
            }
        } else if (typeOfGame === 'Battleship') {
            participantOne.power += 20;
            return `The ${participant1} successfully completed the game ${typeOfGame}.`
        }
    }

    toString() {
        let res = [];
        res.push(`${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`)

        this.listOfParticipants.sort((a, b) => b.wins - a.wins);

        this.listOfParticipants.forEach(p => res.push(`${p.name} - ${p.condition} - ${p.power} - ${p.wins}`))

        return res.join('\n')
    }
}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

console.log(summerCamp.toString());



