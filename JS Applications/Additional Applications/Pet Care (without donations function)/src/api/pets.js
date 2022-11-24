import { get, put, del, post } from './api.js'

export async function getAllPets() {
    return get('/data/pets?sortBy=_createdOn%20desc&distinct=name');
}

export async function getPetById(id) {
    return get('/data/pets/' + id);
}

export async function deletePetById(id) {
    return del('/data/pets/' + id);
}

export async function updatePet(id, pet) {
    return put('/data/pets/' + id, pet);
}

export async function createPet(pet) {
    return post('/data/pets', pet);
}