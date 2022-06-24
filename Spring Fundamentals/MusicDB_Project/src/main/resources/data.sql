INSERT INTO artists(id, name)
VALUES (1, "QUEEN"),
       (2, "METALLICA"),
       (3, "MADONNA");

INSERT INTO users (id, username, full_name, password, email)
VALUES (1, 'angel', 'angelTashev', 121212, 'angel@abv.bg'),
       (2, 'alex', 'alexAlex', 123123, 'hercules@abv.bg');

INSERT INTO albums(id, name, image_url, description, copies, price, release_date, producer, genre, artist_id,
                   added_from_id)
VALUES (1, 'Singleton album', '/img/madonna.jpg', 'The most popular album', 358509, 20, CURRENT_DATE, 'Simon Cowel',
        'POP', 3, 1),
       (2, 'Nothing else matters', '/img/metallica.jpg', 'The superior album', 140600, 15, CURRENT_DATE, 'John Michael',
        'ROCK', 2, 1);
