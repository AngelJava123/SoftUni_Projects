import { page, render } from './lib.js';
import { updateNav } from './views/nav.js';
import { homeView } from './views/home.js';
import { loginView } from './views/login.js';
import { registerView } from './views/register.js';
import { catalogView } from './views/catalog.js';
import { detailsView } from './views/details.js';
import { editView } from './views/edit.js';
import { createView } from './views/create.js';

const main = document.querySelector('main');

page(decorateContext);
page('/', homeView);
page('/login', loginView);
page('/register', registerView);
page('/catalog', catalogView);
page('/offers/:id', detailsView);
page('/edit/:id', editView);
page('/create', createView);

updateNav();
page.start();

function decorateContext(ctx, next) {
    ctx.render = renderMain;
    ctx.updateNav = updateNav;
    next();
}

function renderMain(templateResult) {
    render(templateResult, main);
}