import { CONFIG } from "./constants";
import { PostService } from "./services/postService";
import { UserService } from "./services/userService";
import './style.css'
import { UserDetails } from "./type/user";
import { HtmlUtil } from "./utils/html";

const { baseUrl } = CONFIG;
const postService = new PostService(baseUrl);
const userService = new UserService(baseUrl);
const userId = 3;
const root = document.querySelector<HTMLElement>("#root");
HtmlUtil.render(root);

/** Read All - Posts */
postService.getAll().then((data) => {
  console.log("posts ", data);
});


userService.getAll().then((data) => {
  console.log("users ", data);
});

const user: UserDetails = {
  id: 2,
  name: "Sara Davidson",
  username: "Sara",
  email: "Sara@april.biz",
  address: {
    street: "",
    suite: "",
    city: "",
    zipcode: "",
    geo: { lat: "", lng: "" },
  },
  phone: "0876123123123",
  website: "Sara.org",
  company: {
    name: "",
    catchPhrase: "",
    bs: "",
  },
};

userService.getSingleUser(userId, (id: number) => {
  postService.getUserPost(id).then((data) => {
    console.log("users's posts", data[0]);
  });
});

userService.delete(3).then((x) => {
  console.log("delete", x);
});

userService.update(user).then((x) => {
  console.log(x);
});

userService.getOne(userId).then((data) => {
  console.log("single user", data);
});

/** Create */
userService.create(user).then((res) => {
  console.log({ res });
});


