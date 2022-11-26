import { getAllPostsByOwner } from "../api/posts.js";
import { getUserData } from "../util.js";
import { html } from "../lib.js";

const catalogTemplate = (posts) => html`
<section id="my-posts-page">
    <h1 class="title">My Posts</h1>

    <!-- Display a div with information about every post (if any)-->
    <div class="my-posts">
        
    ${posts.length == 0 
        ? html`<h1 class="title no-posts-title">No posts yet!</h1>`
        : posts.map(postCard)}
    </div>
</section>`;

const postCard = (post) => html`
<div class="post">
            <h2 class="post-title">${post.title}</h2>
            <img class="post-image" src=${post.imageUrl} alt="Kids clothes">
            <div class="btn-wrapper">
                <a href="/catalog/${post._id}" class="details-btn btn">Details</a>
            </div>
</div>`;

export async function myPostsView(ctx) {
    const hasUser = getUserData();
    const id = hasUser.id
    const posts = await getAllPostsByOwner(id);
    ctx.render(catalogTemplate(posts));
}