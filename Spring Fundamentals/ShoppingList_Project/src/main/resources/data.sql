INSERT INTO categories(id, name)
VALUES (1, "FOOD"),
       (2, "DRINK"),
       (3, "HOUSEHOLD"),
       (4, "OTHER");

INSERT INTO users (id, username, password, email)
VALUES (1, 'angel', 121212, 'angel@abv.bg'),
       (2, 'alex', 123123, 'hercules@abv.bg');

INSERT INTO products(id, name, description, price, needed_before, category_id)
VALUES (1, 'Cola', 'Carbonated drink', 3, CURRENT_TIMESTAMP, 2),
       (2, 'Cake', 'Red Velvet', 5, CURRENT_TIMESTAMP, 1),
       (3, 'Brush', 'Extendable dust remover', 12, CURRENT_TIMESTAMP, 3),
       (4, 'DollHouse', 'For children', 30, CURRENT_TIMESTAMP, 4);