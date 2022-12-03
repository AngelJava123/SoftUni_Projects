import { getAllBooksByOwner } from "../api/books.js";
import { getUserData } from "../util.js";
import { html } from "../lib.js";

const catalogTemplate = (books) => html`
<section id="my-books-page" class="my-books">
    <h1>My Books</h1>
    <ul class="my-books-list">

        ${books.length == 0 
        ? html`<p class="no-books">No books in database!</p>`
        : books.map(bookCard)}
    </ul>    
</section>`;

const bookCard = (book) => html`
<li class="otherBooks">
    <h3>${book.title}</h3>
    <p>Type: ${book.type}</p>
    <p class="img"><img src=${book.imageUrl}></p>
    <a class="button" href="/catalog/${book._id}">Details</a>
</li>`;

export async function myBooksView(ctx) {
    const hasUser = getUserData();
    const id = hasUser.id
    const books = await getAllBooksByOwner(id);
    ctx.render(catalogTemplate(books));
}