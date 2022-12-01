import { get, put, del, post } from './api.js'

export async function getAllShoes() {
    return get('/data/shoes?sortBy=_createdOn%20desc');
}

export async function getShoeById(id) {
    return get('/data/shoes/' + id);
}

export async function deleteShoeById(id) {
    return del('/data/shoes/' + id);
}

export async function createShoes(shoe) {
    return post('/data/shoes', shoe);
}

export async function updateShoe(id, shoe) {
    return put('/data/shoes/' + id, shoe);
}