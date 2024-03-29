import { getAllPosts } from "../api/posts.js";
import { html } from "../lib.js";

const catalogTemplate = (posts) => html`
<section id="dashboard-page">
    <h1 class="title">All Posts</h1>

    <!-- Display a div with information about every post (if any)-->
    <div class="all-posts">
        
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

export async function catalogView(ctx) {
    const posts = await getAllPosts();
    ctx.render(catalogTemplate(posts));
}