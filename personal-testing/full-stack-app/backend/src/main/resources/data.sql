-- Insert products
INSERT INTO products (name, description, sex, featured, price) VALUES ('Hiking Boots', 'Holds your feet warm', 'unisex', 1, 2400);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Sweater', 'Holds the heat effectively', 'unisex', 1, 800);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Hat', 'Available with Norwegian and Swedish flag', 'unisex', 1, 200);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Water Bottle', 'Hook for easy attachment to a bag', 'unisex', 0, 120);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Clothes set for Dogs', 'Boots, pants, and a sweater', 'unisex', 0, 6670);

-- Insert details
-- Boots
INSERT INTO product_details (product_id, detail) VALUES (1, 'From -15C up to +25C');
INSERT INTO product_details (product_id, detail) VALUES (1, 'Easy to put on');

-- Sweater
INSERT INTO product_details (product_id, detail) VALUES (2, '100% wool');

-- Hat
INSERT INTO product_details (product_id, detail) VALUES (3, '80% Wool, 20% Nylon');
INSERT INTO product_details (product_id, detail) VALUES (3, 'Fits well on most heads');

-- Bottle
INSERT INTO product_details (product_id, detail) VALUES (4, 'Lightweight');
INSERT INTO product_details (product_id, detail) VALUES (4, 'Plastic');
INSERT INTO product_details (product_id, detail) VALUES (4, 'Volume: 0.7 liter');

-- Insert colors
INSERT INTO colors (color) VALUES ('black');
INSERT INTO colors (color) VALUES ('blue');
INSERT INTO colors (color) VALUES ('red');
INSERT INTO colors (color) VALUES ('green');
INSERT INTO colors (color) VALUES ('orange');
INSERT INTO colors (color) VALUES ('transparent');

-- Insert size
INSERT INTO sizes (size_value) VALUES ('37');
INSERT INTO sizes (size_value) VALUES ('38');
INSERT INTO sizes (size_value) VALUES ('39');
INSERT INTO sizes (size_value) VALUES ('40');
INSERT INTO sizes (size_value) VALUES ('41');
INSERT INTO sizes (size_value) VALUES ('42');
INSERT INTO sizes (size_value) VALUES ('43');
INSERT INTO sizes (size_value) VALUES ('44');
INSERT INTO sizes (size_value) VALUES ('45');
INSERT INTO sizes (size_value) VALUES ('46');
INSERT INTO sizes (size_value) VALUES ('47');
INSERT INTO sizes (size_value) VALUES ('XS');
INSERT INTO sizes (size_value) VALUES ('S');
INSERT INTO sizes (size_value) VALUES ('M');
INSERT INTO sizes (size_value) VALUES ('Fits all');

-- Insert boots into product entries
-- Boots, black
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 3, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 1, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 2, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 4, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 5, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 6, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 7, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 8, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 9, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 10, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 1, 11, 50);

-- Boots, blue
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 1, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 2, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 3, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 4, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 5, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 6, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 7, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 8, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 9, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 10, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 2, 11, 50);

-- Boots, red
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 1, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 2, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 3, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 4, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 5, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 6, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 7, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 8, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 9, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 10, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (1, 3, 11, 50);

-- Sweater, green
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 4, 12, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 4, 13, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 4, 14, 50);

-- Sweater, orange
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 5, 12, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 5, 13, 50);
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (2, 5, 14, 50);

-- Hat, black
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (3, 1, 15, 50);

-- Bottle, blue
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (4, 2, 15, 50);

-- Bottle, red
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (4, 3, 15, 50);

-- Bottle, transparent
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (4, 6, 15, 50);

-- Dog set, green
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (5, 4, 12, 50);

-- Dog set, orange
INSERT INTO product_entries (product_id, color_id, size_id, quantity) VALUES (5, 5, 12, 50);
