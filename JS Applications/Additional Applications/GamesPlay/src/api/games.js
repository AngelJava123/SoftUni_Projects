import { get, put, del, post } from './api.js'

export async function getFirstThreeGames() {
    return get('/data/games?sortBy=_createdOn%20desc&distinct=category');
}

export async function getAllGames() {
    return get('/data/games?sortBy=_createdOn%20desc');
}

export async function getGameById(id) {
    return get('/data/games/' + id);
}

export async function getAllCommentsById(id) {
    return get(`/data/comments?where=gameId%3D%22${id}%22`);
}

export async function deleteGameById(id) {
    return del('/data/games/' + id);
}

export async function updateGame(id, game) {
    return put('/data/games/' + id, game);
}

export async function createGame(game) {
    return post('/data/games', game);
}
