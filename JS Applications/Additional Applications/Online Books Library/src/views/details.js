import { getBookById, deleteBookById } from "../api/books.js";
import { html, nothing } from "../lib.js";
import { getUserData } from "../util.js";

const detailsTemplate = (book, hasUser, isOwner, onDelete) => html`
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${book.title}</h3>
        <p class="type">Type: ${book.type}</p>
        <p class="img"><img src=${book.imageUrl}></p>
        <div class="actions">

            ${hasUser ? html`
            ${isOwner ? html`
            <a class="button" href="/edit/${book._id}">Edit</a>
            <a class="button" @click="${onDelete}" href="javascript:void(0)">Delete</a>` : html`
            <a class="button" href="#">Like</a>`}
            ` : nothing}

            <!-- ( for Guests and Users )  -->
            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: 0</span>
            </div>
            <!-- Bonus -->
        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${book.description}</p>
    </div>
</section>`;

export async function detailsView(ctx) {
    const book = await getBookById(ctx.params.id);

    const hasUser = getUserData();
    const isOwner = hasUser?.id == book._ownerId;

    ctx.render(detailsTemplate(book, hasUser, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete this book?');

        if (choice) {
            await deleteBookById(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    }
}