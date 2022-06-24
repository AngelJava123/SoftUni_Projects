INSERT INTO categories (id, name)
VALUES (1, 'BATTLE'),
       (2, "CARGO"),
       (3, "PATROL");

INSERT INTO users (id, username, full_name, password, email)
VALUES (1, 'angel', 'angelV', 121212, 'angel@abv.bg'),
       (2, 'tashev', 'valentinov', 123123, 'hercules@abv.bg');

INSERT INTO ships (id, created, health, name, power, category_id, user_id)
VALUES (1, CURRENT_DATE , 40, 'SpaceXShip', 35, 2, 2),
       (2, CURRENT_DATE, 50, 'SpaceOne', 45, 3, 2),
       (3, CURRENT_DATE, 300, 'SpaceTwo', 250, 1, 1)