INSERT INTO roles(id, role)
VALUES (1, "USER"),
       (2, "ADMIN");

INSERT INTO clubs(id, title, location, opening_hour, closing_hour, additional_amenities, image)
VALUES (1, 'LAS_TORTUGA', 'Ronda de Sant Pere, 35, 08010 Barcelona, Spain', '06:00:00', '22:00:00', 'SPA',
        'images/club1.jpg'),
       (2, 'MALAGA_PEARL', 'C.Comercial Alhamar, Ctra. Nacional 340, Málaga, Spain',
        '07:00:00', '21:30:00', 'SWIMMING_POOL', 'images/club2.jpg'),
       (3, 'ALICANTE_DIAMOND', 'C. Pablo Picasso, 03189 Playa Flamenca, Alicante, Spain', '06:30:00', '22:30:00',
        'SOLARIUM', 'images/club3.jpg'),
       (4, 'MADRID_MILLENNIAL', 'C. San Enrique, 22, 28020 Madrid, Spain', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club4.jpg'),
       (5, 'CASE_DE_SANTORINI', 'Via di Sant Agata de Goti, 19, 00184 Roma RM, Italy', '07:00:00', '22:00:00', 'SPA',
        'images/club5.jpg'),
       (6, 'VIVA_DE_FLORANCE', 'Via dei Fossi, 56, 50123 Firenze FI, Italy', '07:00:00', '21:30:00', 'SOLARIUM',
        'images/club6.jpg'),
       (7, 'CASE_VENEZIA', ' Calle de le Vele, 3974, 30121 Venezia VE, Italy', '06:30:00', '22:30:00', 'SWIMMING_POOL',
        'images/club7.jpg'),
       (8, 'MILANO_MILLENNIAL', 'Viale Regina Margherita, 28, 20122 Milano MI, Italy', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club8.jpg'),
       (9, 'WEST_MALLING', '10 Kings Hill Ave, Kings Hill, West Malling ME19 4AR, UK', '06:00:00', '22:00:00', 'SPA',
        'images/club9.jpg'),
       (10, 'LONDON_PEARL', '135 Borough High St, London SE1 1NP, UK', '07:00:00', '21:30:00', 'SWIMMING_POOL',
        'images/club10.jpg'),
       (11, 'ROYSTON_DIAMOND', 'Baldock Rd, Royston SG8 5BG, UK', '06:30:00', '22:30:00', 'SOLARIUM',
        'images/club11.jpg'),
       (12, 'LONDON_MILLENNIAL', '190 Kensington High St, London W8 7RG, UK', '07:00:00', '22:00:00',
        'SPA', 'images/club12.jpg'),
       (13, 'COLOMBES', '14 Rue de Mantes, 92700 Colombes, France', '06:00:00', '22:00:00', 'SPA', 'images/club13.jpg'),
       (14, 'HOUILLES', '16 Rue Charles Forest, 78800 Houilles, France', '07:00:00', '21:30:00', 'SWIMMING_POOL',
        'images/club14.jpg'),
       (15, 'PARIS_DIAMOND', '65 Quai dOrsay, 75007 Paris, France', '06:30:00', '22:30:00', 'SOLARIUM',
        'images/club15.jpg'),
       (16, 'AMIENS_MILLENNIAL', '39 Rue Chauvelin, 80000 Amiens, France', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club16.jpg'),
       (17, 'MANASTIRSKI_LIVADI', '132 "Bulgaria" Blvd., 1303 Manastirski Livadi quarter, Sofia', '06:00:00',
        '22:00:00', 'SPA', 'images/club17.jpg'),
       (18, 'MLADOST', 'Sofia Ring Road 251A, 1715 g.k. Mladost 4, Sofia', '07:00:00', '21:30:00', 'SPA',
        'images/club18.jpg'),
       (19, 'DELUXE', '12 National Assembly Square, 1000 Sofia Center, Sofia', '06:30:00', '22:30:00', 'SOLARIUM',
        'images/club19.jpg'),
       (20, 'RING_MALL', 'Sofia ring road 214, 1434 v.z. Simeonovo - north, Sofia', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club20.jpg'),
       (21, 'GRAFENWOHR', 'Gettysburg Avenue B170, 92655 Grafenwöhr, Germany', '06:00:00', '22:00:00', 'SPA',
        'images/club21.jpg'),
       (22, 'RAMSTEIN', 'Building 552, 66877 Ramstein-Miesenbach, Germany', '07:00:00', '21:30:00', 'SOLARIUM',
        'images/club22.jpg'),
       (23, 'WIESBADEN', 'Flugplatz Erbenheim 1631, 65205 Wiesbaden, Germany', '06:30:00', '22:30:00', 'SOLARIUM',
        'images/club23.jpg'),
       (24, 'BERLIN_PEARL', 'Paulsternstraße 22, 13629 Berlin, Germany', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club24.jpg'),
       (25, 'EINDHOVEN', 'Geestakker 548, 5625 XL Eindhoven, Netherlands', '06:00:00', '22:00:00', 'SPA',
        'images/club25.jpg'),
       (26, 'AMSTERDAM', 'Tolstraat 59, 1073 RW Amsterdam, Netherlands', '07:00:00', '21:30:00', 'SWIMMING_POOL',
        'images/club26.jpg'),
       (27, 'UTRECHT', 'Biltstraat 19, 3572 AB Utrecht, Netherlands', '06:30:00', '22:30:00', 'SOLARIUM',
        'images/club27.jpg'),
       (28, 'OOSTZAAN', 'Skoon 19/21, 1511 HV Oostzaan, Netherlands', '07:00:00', '22:00:00',
        'SWIMMING_POOL', 'images/club28.jpg');

INSERT INTO subscriptions(id, type, price, period, image)
VALUES (1, 'VIP', 153, 'ONE_MONTH', 'images/vip.jpg'),
       (2, 'STANDARD', 49, 'ONE_MONTH', 'images/standard.jpg'),
       (3, 'UNLIMITED_CLASSES', 69, 'ONE_MONTH', 'images/unlimited.jpg'),
       (4, 'EQUIPMENT_ONLY', 39, 'ONE_MONTH', 'images/equipment.jpg'),
       (5, 'ONE_MONTH', 49, 'ONE_MONTH', 'images/one_month.jpg'),
       (6, 'TREE_MONTHS', 140, 'TREE_MONTHS', 'images/tree_months.jpg'),
       (7, 'SIX_MONTHS', 275, 'SIX_MONTHS', 'images/six_months.jpg'),
       (8, 'ONE_YEAR', 550, 'ONE_YEAR', 'images/one_year.jpg');

INSERT INTO trainers(id, trainer_name, age, specialization, image)
VALUES (1, 'NICK_MITCHELL', 38, 'UPPER_BODY', 'images/man1.jpg'),
       (2, 'MATT_ROBERTS', 45, 'LOWER_BODY', 'images/man2.jpg'),
       (3, 'LOUISE_PARKER', 35, 'UPPER_BODY', 'images/woman1.jpg'),
       (4, 'SHAUN_STAFFORD', 47, 'UPPER_BODY', 'images/man3.jpg'),
       (5, 'SCOTT_LAIDLER', 29, 'LOWER_BODY', 'images/man4.jpg'),
       (6, 'EMMA_CHAN', 52, 'LOWER_BODY', 'images/woman2.jpg'),
       (7, 'NICOLE_STANFORD', 30, 'UPPER_BODY', 'images/woman3.jpg'),
       (8, 'SHANON_MICHAEL', 32, 'UPPER_BODY', 'images/woman4.jpg'),
       (9, 'JOHN_SIEMENS', 40, 'UPPER_BODY', 'images/man5.jpg'),
       (10, 'SANDRA_SIMONS', 36, 'LOWER_BODY', 'images/woman5.jpg'),
       (11, 'JESSICA_PORTERS', 42, 'UPPER_BODY', 'images/woman6.jpg'),
       (12, 'MICHAEL_SMITH', 41, 'LOWER_BODY', 'images/man6.jpg'),
       (13, 'SIMON_SAIGON', 52, 'LOWER_BODY', 'images/man7.jpg'),
       (14, 'DARA_MIKO', 39, 'LOWER_BODY', 'images/woman7.jpg'),
       (15, 'GAMET_GARADJ', 45, 'UPPER_BODY', 'images/man8.jpg'),
       (16, 'JACKIE_WARNER', 37, 'UPPER_BODY', 'images/woman8.jpg'),
       (17, 'ALEXIA_CLARK', 46, 'LOWER_BODY', 'images/woman9.jpg'),
       (18, 'JOE_DOWDELL', 32, 'LOWER_BODY', 'images/man9.jpg'),
       (19, 'KAYLA_ITSINES', 38, 'UPPER_BODY', 'images/woman10.jpg'),
       (20, 'CHRISTIAN_THIBAUDEAU', 28, 'LOWER_BODY', 'images/man10.jpg');

INSERT INTO training_plans(id, title, level, goal, muscle_group)
VALUES (1, 'FITNESS_MANIACS', 'ADVANCED', 'GET_SHREDDED', 'SHOULDER_AND_BACK'),
       (2, 'OPTIMIZED_TRAINING', 'INTERMEDIATE', 'LOST_WEIGHT', 'ABS'),
       (3, 'INSTRUCTIVELY', 'BEGINNER', 'GAIN_MUSCLE_MASS', 'ARM'),
       (4, 'ACTIVATE_ACADEMY', 'INTERMEDIATE', 'GET_SHREDDED', 'CHEST'),
       (5, 'INNER_GROWTH', 'ADVANCED', 'GAIN_MUSCLE_MASS', 'LEG'),
       (6, 'TIMELY_TRAINING', 'BEGINNER', 'LOST_WEIGHT', 'ABS'),
       (7, 'GRADE_POTENTIAL', 'ADVANCED', 'GET_SHREDDED', 'SHOULDER_AND_BACK'),
       (8, 'THE_WATCHERS', 'INTERMEDIATE', 'GAIN_MUSCLE_MASS', 'CHEST'),
       (9, 'COURSE_METHOD', 'ADVANCED', 'LOST_WEIGHT', 'CHEST'),
       (10, 'CORPORATE_BUILDERS', 'ADVANCED', 'GAIN_MUSCLE_MASS', 'LEG'),
       (11, 'COSMIC_BRAIN', 'BEGINNER', 'GET_SHREDDED', 'ABS'),
       (12, 'NANO_TRAINER', 'BEGINNER', 'GAIN_MUSCLE_MASS', 'CHEST'),
       (13, 'FLEX_ED', 'INTERMEDIATE', 'GET_SHREDDED', 'ARM'),
       (14, 'FOCUS_FITNESS', 'ADVANCED', 'GAIN_MUSCLE_MASS', 'SHOULDER_AND_BACK'),
       (15, 'LESSON_UP', 'BEGINNER', 'GET_SHREDDED', 'LEG');
