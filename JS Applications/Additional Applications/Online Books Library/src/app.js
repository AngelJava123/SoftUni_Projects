import { updateNav } from './views/nav.js';
import { page, render } from './lib.js';
import { loginView } from './views/login.js';
import { registerView } from './views/register.js';
import { catalogView } from './views/catalog.js';
import { myBooksView } from './views/myBooks.js';
import { detailsView } from './views/details.js';
import { createView } from './views/create.js';
import { editView } from './views/edit.js';

const main = document.querySelector('main');

page(decorateContext);
page('/', catalogView)
page('/login', loginView);
page('/register', registerView);
page('/catalog', catalogView);
page('/myBooks', myBooksView);
page('/catalog/:id', detailsView);
page('/create', createView);
page('/edit/:id', editView);

// Start app
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