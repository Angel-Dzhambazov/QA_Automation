CREATE TABLE IF NOT EXISTS checklists (
    todo_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    cost DECIMAL (7,2),
    initiated_on VARCHAR(255),
    is_completed BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2000),
    list_price DECIMAL(9, 2),
    category_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    website VARCHAR(255),
    credit_limit DECIMAL(8, 2)
);

INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Riddikulus', 2468.7947760776037, '2020-10-14', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Gladys Eeya', '06042 Mammie Lock', 'www.joi-kovacek.org', 994.4532890340373);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Harrison Fire', 'Revelio', 392.90350373743536, 78);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Avada Kedavra', 6627.287051442771, '2021-07-15', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Olive Branch', '871 Julienne Village', 'www.don-volkman.com', 487.9727555420489);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Noah Lott', 'Stupefy', 52.42882687553496, 128);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Accio', 8221.695123669071, '2021-05-06', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Mel Loewe', '0603 Joana Mall', 'www.weldon-grimes.info', 199.47094880456552);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Candy Baskett', 'Wingardium Leviosa', 273.36538748807305, 169);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Expelliarmus', 385.0942933193769, '2020-10-17', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Nick O''Time', '792 Marlon Trail', 'www.jordon-weber.io', 750.9615994846445);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Bob Inforapples', 'Revelio', 282.55613672491836, 46);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Reparo', 4995.210265482756, '2020-11-25', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Pepe Roni', '27337 Ruthann Gateway', 'www.sanford-bahringer.biz', 689.8734707812316);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Bess Eaton', 'Sectumsempra', 332.2931192763568, 64);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Alohomora', 3994.0201089761076, '2021-07-25', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Phil DeGrave', '537 Tillman Shores', 'www.lenna-becker.io', 286.4570578401441);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Rose Bush', 'Alohomora', 40.194957852705194, 18);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Expecto Patronum', 283.7472721678892, '2021-09-07', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Claire DeAir', '7099 Tracy Burgs', 'www.ivory-gottlieb.co', 889.5657610080436);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Hein Noon', 'Confundo', 322.2071744673652, 105);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Confundo', 2255.0997707718316, '2021-06-06', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('P. Brain', '15983 Skiles Vista', 'www.long-hahn.biz', 132.73012383878216);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Helen Highwater', 'Riddikulus', 476.4651907884161, 131);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Expelliarmus', 1031.8426638451076, '2020-11-19', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Rick O''Shea', '37657 Bednar Field', 'www.tammy-fay.biz', 736.3256583856308);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Ray N. Carnation', 'Expelliarmus', 186.76726968938968, 90);
INSERT INTO checklists (name, cost, initiated_on, is_completed) VALUES ('Obliviate', 4669.960405095531, '2020-10-16', 0);
INSERT INTO customers (name, address, website, credit_limit) VALUES ('Emerald Stone', '677 Rhett Burg', 'www.cleo-bradtke.name', 472.2989757060925);
INSERT INTO products (name, description, list_price, category_id) VALUES ('Ricky T. Ladder', 'Alohomora', 221.4974217305628, 202);