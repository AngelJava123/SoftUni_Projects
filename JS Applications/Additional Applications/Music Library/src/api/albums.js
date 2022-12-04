import { get, put, del, post } from './api.js'

export async function getAllAlbums() {
    return get('/data/albums?sortBy=_createdOn%20desc');
}

export async function getAlbumById(id) {
    return get('/data/albums/' + id);
}

export async function deleteAlbumById(id) {
    return del('/data/albums/' + id);
}

export async function createAlbum(album) {
    return post('/data/albums', album);
}

export async function updateAlbum(id, album) {
    return put('/data/albums/' + id, album);
}