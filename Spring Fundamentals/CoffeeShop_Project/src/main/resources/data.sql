INSERT INTO categories(id, name, needed_time)
VALUES (1, "COFFEE", 2),
       (2, "CAKE", 10),
       (3, "DRINK", 1),
       (4, "OTHER", 5);

INSERT INTO users (id, username, first_name, last_name, password, email)
VALUES (1, 'angel', 'angel', 'tashev', 121212, 'angel@abv.bg'),
       (2, 'tashev', 'Mitko', 'Valentinov', 123123, 'hercules@abv.bg');

INSERT INTO orders (id, order_time, name, price, category_id, description, employee_id)
VALUES (1, CURRENT_TIMESTAMP, 'Cappucino', 3, 1, 'The best coffee in the world', 1),
       (2, CURRENT_TIMESTAMP, 'Cola', 4, 3, 'The best drink in the world', 1),
       (3, CURRENT_TIMESTAMP, 'RedVelvet', 7, 2, 'The best of the best', 2)