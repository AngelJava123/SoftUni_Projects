import { getAllCommentsById, deleteGameById, getGameById } from "../api/games.js";
import { html, nothing } from "../lib.js";
import { getUserData } from "../util.js";

const detailsTemplate = (game, comments, hasUser, isOwner, onDelete) => html`
    <section id="game-details">
        <h1>Game Details</h1>
        <div class="info-section">
    
            <div class="game-header">
                <img class="game-img" src=${game.imageUrl} />
                <h1>${game.title}</h1>
                <span class="levels">MaxLevel: ${game.maxLevel}</span>
                <p class="type">${game.category}</p>
            </div>
    
            <p class="text">${game.summary}</p>
    
            <!-- Bonus ( for Guests and Users ) -->
            <div class="details-comments">
                <h2>Comments:</h2>
                <ul>
                    <!-- list all comments for current game (If any) -->
                    ${comments.length == 0 
                    ? html`<p class="no-comment">No comments.</p></h3>`
                    : comments.map(commentCard)}
                </ul>
            </div>

            ${hasUser ? html`
                    ${isOwner ? html`
                    <div class="buttons">
                       <a  href="/edit/${game._id}" class="button">Edit</a>
                       <a @click="${onDelete}" href="javascript:void(0)" class="button">Delete</a>
                    </div>`: html`
                    <article class="create-comment">
                       <label>Add new comment:</label>
                         <form class="form">
                         <textarea name="comment" placeholder="Comment......"></textarea>
                         <input class="btn submit" type="submit" value="Add Comment">
                         </form>
                    </article>`}
                </div>` : nothing}
    
            <!-- Edit/Delete buttons ( Only for creator of this game )  -->
            
        </div>
    
        <!-- Bonus -->
        <!-- Add Comment ( Only for logged-in users, which is not creators of the current game ) -->
        
    
    </section>`;

const commentCard = (comment) => html`
<li class="comment">
    <p>${comment}</p>
</li>`;

export async function detailsView(ctx) {
    const game = await getGameById(ctx.params.id);
    const comments = await getAllCommentsById(ctx.params.id);

    const hasUser = getUserData();
    const isOwner = hasUser?.id == game._ownerId;

    ctx.render(detailsTemplate(game, comments, hasUser, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete this game?');

        if (choice) {
            await deleteGameById(ctx.params.id);
            ctx.page.redirect('/');
        }
    }
}