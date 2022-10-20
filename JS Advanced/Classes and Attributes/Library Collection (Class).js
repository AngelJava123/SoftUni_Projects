class LibraryCollection {
    constructor(capacity) {
        this.capacity = capacity;
        this.books = [];
    }

    addBook(bookName, bookAuthor) {
        if (this.capacity == 0) {
            throw new Error('Not enough space in the collection.')
        }

        this.books.push({ bookName, bookAuthor, payed: false })
        this.capacity--

        return `The ${bookName}, with an author ${bookAuthor}, collect.`
    }

    payBook(bookName) {
        let book = this.books.find(b => b.bookName === bookName);

        if (book === undefined) {
            throw new Error(`${bookName} is not in the collection.`)
        }

        if (book.payed == true) {
            throw new Error(`${bookName} has already been paid.`)
        }

        book.payed = true;
        return `${bookName} has been successfully paid.`;
    }

    removeBook(bookName) {
        let book = this.books.find(b => b.bookName === bookName);

        if (book === undefined) {
            throw new Error('The book, you\'re looking for, is not found.')
        }

        if (book.payed == false) {
            throw new Error(`${bookName} need to be paid before removing from the collection.`)
        }

        this.books = this.books.filter((b) => b.bookName != bookName);
        return `${bookName} remove from the collection.`;
    }

    getStatistics(bookAuthor) {
        if (bookAuthor === undefined) {

            let res = [];
            res.push(`The book collection has ${this.capacity} empty spots left.`);

            this.books.sort((a, b) => a.bookName - b.bookName);

            this.books.forEach((b) => res.push(`${b.bookName} == ${b.bookAuthor} - ${(b.payed ? "Has Paid" : "Not Paid")}.`))

            return res.join('\n')
        } else {
            let book = this.books.find(b => b.bookAuthor === bookAuthor);

            if (book === undefined) {
                throw new Error(`${bookAuthor} is not in the collection.`)
            }

            return `${book.bookName} == ${book.bookAuthor} - ${(book.payed ? "Has Paid" : "Not Paid")}.`
        }
    }

}

const library = new LibraryCollection(2)
console.log(library.addBook('Don Quixote', 'Miguel de Cervantes'));
console.log(library.getStatistics('Miguel de Cervantes'));





