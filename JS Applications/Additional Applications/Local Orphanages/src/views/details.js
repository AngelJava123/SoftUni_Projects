import { getPostById, deletePostById } from "../api/posts.js";
import { html, nothing } from "../lib.js";
import { getUserData } from "../util.js";

const detailsTemplate = (post, hasUser, isOwner, onDelete) => html`
<section id="details-page">
    <h1 class="title">Post Details</h1>

    <div id="container">
        <div id="details">
            <div class="image-wrapper">
                <img src=${post.imageUrl} alt="Material Image" class="post-image">
            </div>
            <div class="info">
                <h2 class="title post-title">${post.title}</h2>
                <p class="post-description">Description: ${post.description}</p>
                <p class="post-address">Address: ${post.address}</p>
                <p class="post-number">Phone number: ${post.phone}</p>
                <p class="donate-Item">Donate Materials: 0</p>

                ${hasUser ? html`
                <div class="btns">
                    ${isOwner ? html`
                    <a href="/edit/${post._id}" class="edit-btn btn">Edit</a>
                    <a @click="${onDelete}" href="javascript:void(0)" class="delete-btn btn">Delete</a>`: html`
                    <a href="#" class="donate-btn btn">Donate</a>`}
                </div>` : nothing}
            </div>
        </div>
    </div>
</section>`;

export async function detailsView(ctx) {
    const post = await getPostById(ctx.params.id);

    const hasUser = getUserData();
    const isOwner = hasUser?.id == post._ownerId;

    ctx.render(detailsTemplate(post, hasUser, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete with pet?');

        if (choice) {
            await deletePostById(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    }
}