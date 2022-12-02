import { html, render, page } from "../lib.js";
import { getUserData } from "../util.js";
import { logout } from "../api/users.js";

const nav = document.querySelector('header');

const navTemplate = (hasUser) => html`
<!-- Navigation -->
<h1><a class="home" href="/">GamesPlay</a></h1>
<nav>
    <a href="/catalog">All games</a>
    ${hasUser ? html`
    <div id="user">
        <a href="create">Create Game</a>
        <a @click="${onLogout}" id="logoutBtn" href="javascript:void(0)">Logout</a>
    </div>` : html`
    <div id="guest">
        <a href="/login">Login</a>
        <a href="/register">Register</a>
    </div>`}
</nav>`;

export function updateNav() {

    const user = getUserData();

    render(navTemplate(user), nav)
}

function onLogout() {
    logout();
    updateNav();
    page.redirect('/');
}