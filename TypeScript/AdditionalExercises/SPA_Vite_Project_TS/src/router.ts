import { RouterMap } from "./type/router";
import { postPage } from "./views/post";
import { userPage } from "./views/users";

export const router: RouterMap = {
  "/": userPage,
  "/post": postPage,
};