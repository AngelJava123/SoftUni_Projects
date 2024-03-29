import { html, render, page } from "../lib.js";
import { getUserData } from "../util.js";
import { logout } from "../api/users.js";

const nav = document.querySelector('header');

const navTemplate = (hasUser) => html`
<nav class="navbar">
    <section class="navbar-dashboard">
        <a href="/catalog">Dashboard</a>
   
        ${!hasUser ? html`
        <div id="guest">
            <a class="button" href="/login">Login</a>
            <a class="button" href="/register">Register</a>
        </div>` : html`
        <div id="user">
            <span>Welcome, ${hasUser.email}</span>
            <a class="button" href="/myBooks">My Books</a>
            <a class="button" href="/create">Add Book</a>
            <a class="button" @click="${onLogout}" id="logoutBtn" href="javascript:void(0)">Logout</a>
        </div>`}
    </section>
</nav>`;

export function updateNav() {

    const user = getUserData();

    render(navTemplate(user), nav)
}

function onLogout() {
    logout();
    updateNav();
    page.redirect('/catalog');
} 