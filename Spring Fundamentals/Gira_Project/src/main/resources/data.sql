INSERT INTO classifications(id, name)
VALUES (1, 'BUG'),
       (2, 'FEATURE'),
       (3, 'SUPPORT'),
       (4, 'OTHER');

INSERT INTO users(id, username, password, email)
VALUES (1, 'angel', '121212', 'angel@abv.bg');

INSERT INTO tasks(id, name, description, progress, due_date, classification_id, user_id)
VALUES (1, 'Laptop Replacement', 'I need to change my laptop', 'OPEN', CURRENT_DATE, 3, 1)