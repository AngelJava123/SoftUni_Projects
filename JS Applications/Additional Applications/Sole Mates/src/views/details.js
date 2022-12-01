import { getShoeById, deleteShoeById } from "../api/shoes.js";
import { html, nothing } from "../lib.js";
import { getUserData } from "../util.js";

const detailsTemplate = (shoe, hasUser, isOwner, onDelete) => html`
<section id="details">
    <div id="details-wrapper">
        <p id="details-title">Shoe Details</p>
        <div id="img-wrapper">
            <img src=${shoe.imageUrl} alt="example1" />
        </div>
        <div id="info-wrapper">
            <p>Brand: <span id="details-brand">${shoe.brand}</span></p>
            <p>
                Model: <span id="details-model">${shoe.model}</span>
            </p>
            <p>Release date: <span id="details-release">${shoe.release}</span></p>
            <p>Designer: <span id="details-designer">${shoe.designer}</span></p>
            <p>Value: <span id="details-value">${shoe.value}</span></p>
        </div>

        ${hasUser ? html`
        <div id="action-buttons">
            ${isOwner ? html`
            <a href="/edit/${shoe._id}" id="edit-btn">Edit</a>
            <a @click="${onDelete}" href="javascript:void(0)" id="delete-btn">Delete</a>` : nothing}
        </div>` : nothing}
    </div>
</section>`;

export async function detailsView(ctx) {
    const shoe = await getShoeById(ctx.params.id);

    const hasUser = getUserData();
    const isOwner = hasUser?.id == shoe._ownerId;

    ctx.render(detailsTemplate(shoe, hasUser, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete these shoes?');

        if (choice) {
            await deleteShoeById(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    }
}