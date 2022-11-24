import { homeView } from './views/home.js';
import { loginView } from './views/login.js';
import { page, render } from './lib.js';
import { catalogView } from './views/pets.js';
import { detailsView } from './views/details.js';
import { registerView } from './views/register.js';
import { updateNav } from './views/nav.js';
import { editView } from './views/edit.js';
import { createView } from './views/create.js';

const main = document.querySelector('main');

page(decorateContext);
page('/', homeView);
page('/pets', catalogView);
page('/pets/:id', detailsView);
page('/edit/:id', editView);
page('/login', loginView);
page('/register', registerView);
page('/create', createView);

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