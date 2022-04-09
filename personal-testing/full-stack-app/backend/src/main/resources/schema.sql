CREATE TABLE IF NOT EXISTS products (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    sex VARCHAR(255) NOT NULL,
    featured INT NOT NULL,
    price FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS colors (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS sizes (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    size_value VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product_entries (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    product_id INTEGER NOT NULL,
    color_id INTEGER NOT NULL,
    size_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    foreign key (product_id) references products(id),
    foreign key (color_id) references colors(id),
    foreign key (size_id) references sizes(id)
);

CREATE TABLE IF NOT EXISTS product_details (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    product_id INTEGER NOT NULL,
    detail VARCHAR(255) NOT NULL,
    foreign key (product_id) references products(id)
);