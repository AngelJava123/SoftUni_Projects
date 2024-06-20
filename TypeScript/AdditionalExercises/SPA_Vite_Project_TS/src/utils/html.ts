import { router } from "../router";

export class HtmlUtil {
    static render(rootDiv: HTMLElement | null) {
        if (!rootDiv) {
            throw Error('Missing root element!');
        }

        const { pathname } = window.location;
        rootDiv.innerHTML = router[pathname];

        HtmlUtil.addEventListeners(rootDiv);
    }

    private static addEventListeners(rootDiv: HTMLElement) {
        const usersBtn: HTMLElement | null = document.getElementById("users");
        const postsBtn: HTMLElement | null = document.getElementById("posts");

        if (usersBtn) {
            usersBtn.addEventListener('click', () => {
                HtmlUtil.navigate(rootDiv, "/");
            });
        }

        if (postsBtn) {
            postsBtn.addEventListener('click', () => {
                HtmlUtil.navigate(rootDiv, "/post");
            });
        }
    }

    private static navigate(rootDiv: HTMLElement, pathname: string) {
        const { origin } = window.location;
        const url = `${origin}${pathname}`;

        window.history.pushState({}, pathname, url);

        rootDiv.innerHTML = router[pathname];
    }
}