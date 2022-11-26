import { get, put, del, post } from './api.js'

export async function getAllPosts() {
    return get('/data/posts?sortBy=_createdOn%20desc');
}

export async function getAllPostsByOwner(userId) {
    return get(`/data/posts?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
}

export async function getPostById(id) {
    return get('/data/posts/' + id);
}

export async function deletePostById(id) {
    return del('/data/posts/' + id);
}

export async function createPost(pos) {
    return post('/data/posts', pos);
}

export async function updatePost(id, pos) {
    return put('/data/posts/' + id, pos);
}