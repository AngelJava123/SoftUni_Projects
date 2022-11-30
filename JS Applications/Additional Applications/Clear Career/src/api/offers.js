import { get, put, del, post } from './api.js'

export async function getAllOffers() {
    return get('/data/offers?sortBy=_createdOn%20desc');
}

export async function getOfferById(id) {
    return get('/data/offers/' + id);
}

export async function deleteOfferById(id) {
    return del('/data/offers/' + id);
}

export async function updateOffer(id, offer) {
    return put('/data/offers/' + id, offer);
}

export async function createOffer(offer) {
    return post('/data/offers', offer);
}