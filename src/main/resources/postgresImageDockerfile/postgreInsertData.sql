CREATE TABLE IF NOT EXISTS checklists (
    todo_id INT PRIMARY KEY,
    name VARCHAR(255),
    cost DECIMAL (7,2),
    initiated_on VARCHAR(255),
    is_completed INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2000),
    list_price DECIMAL(9, 2),
    category_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    website VARCHAR(255),
    credit_limit DECIMAL(8, 2)
);

INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (1, 'Riddikulus', 2468.7947760776037, '2020-10-14', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (1, 'Gladys Eeya', '06042 Mammie Lock', 'www.joi-kovacek.org', 994.4532890340373);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (1, 'Harrison Fire', 'Revelio', 392.90350373743536, 78);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (2, 'Avada Kedavra', 6627.287051442771, '2021-07-15', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (2, 'Olive Branch', '871 Julienne Village', 'www.don-volkman.com', 487.9727555420489);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (2, 'Noah Lott', 'Stupefy', 52.42882687553496, 128);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (3, 'Accio', 8221.695123669071, '2021-05-06', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (3, 'Mel Loewe', '0603 Joana Mall', 'www.weldon-grimes.info', 199.47094880456552);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (3, 'Candy Baskett', 'Wingardium Leviosa', 273.36538748807305, 169);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (4, 'Expelliarmus', 385.0942933193769, '2020-10-17', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (4, 'Nick O''Time', '792 Marlon Trail', 'www.jordon-weber.io', 750.9615994846445);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (4, 'Bob Inforapples', 'Revelio', 282.55613672491836, 46);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (5, 'Reparo', 4995.210265482756, '2020-11-25', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (5, 'Pepe Roni', '27337 Ruthann Gateway', 'www.sanford-bahringer.biz', 689.8734707812316);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (5, 'Bess Eaton', 'Sectumsempra', 332.2931192763568, 64);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (6, 'Alohomora', 3994.0201089761076, '2021-07-25', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (6, 'Phil DeGrave', '537 Tillman Shores', 'www.lenna-becker.io', 286.4570578401441);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (6, 'Rose Bush', 'Alohomora', 40.194957852705194, 18);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (7, 'Expecto Patronum', 283.7472721678892, '2021-09-07', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (7, 'Claire DeAir', '7099 Tracy Burgs', 'www.ivory-gottlieb.co', 889.5657610080436);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (7, 'Hein Noon', 'Confundo', 322.2071744673652, 105);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (8, 'Confundo', 2255.0997707718316, '2021-06-06', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (8, 'P. Brain', '15983 Skiles Vista', 'www.long-hahn.biz', 132.73012383878216);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (8, 'Helen Highwater', 'Riddikulus', 476.4651907884161, 131);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (9, 'Expelliarmus', 1031.8426638451076, '2020-11-19', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (9, 'Rick O''Shea', '37657 Bednar Field', 'www.tammy-fay.biz', 736.3256583856308);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (9, 'Ray N. Carnation', 'Expelliarmus', 186.76726968938968, 90);
INSERT INTO checklists (todo_id, name, cost, initiated_on, is_completed) VALUES (10, 'Obliviate', 4669.960405095531, '2020-10-16', 0);
INSERT INTO customers (customer_id, name, address, website, credit_limit) VALUES (10, 'Emerald Stone', '677 Rhett Burg', 'www.cleo-bradtke.name', 472.2989757060925);
INSERT INTO products (product_id, name, description, list_price, category_id) VALUES (10, 'Ricky T. Ladder', 'Alohomora', 221.4974217305628, 202);