-- Insert products
INSERT INTO products (name, description, sex, featured, price) VALUES ('Hiking Boots', 'Holds your feet warm', 'unisex', 1, 2400);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Sweater', 'Holds the heat effectively', 'unisex', 1, 800);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Hat', 'Available with Norwegian and Swedish flag', 'unisex', 1, 200);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Water Bottle', 'Hook for easy attachment to a bag', 'unisex', 0, 120);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Clothes set for Dogs', 'Boots, pants, and a sweater', 'animal', 0, 6670);

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

-- Insert product entries
-- Boots, black
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '37', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '38', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '39', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '40', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '41', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '42', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '43', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '44', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '45', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '46', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'black', '47', 50);

-- Boots, blue
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '37', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '38',0);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '39', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '40', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '41', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '42', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '43', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '44', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '45', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '46', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'blue', '47', 50);

-- Boots, red
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '37', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '38', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '39', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '40', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '41', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '42', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '43', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '44', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '45', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '46', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (1, 'red', '47', 50);

-- Sweater, green
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'green', 'XS', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'green', 'S', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'green', 'M', 50);

-- Sweater, orange
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'orange', 'XS', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'orange', 'S', 50);
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (2, 'orange', 'M', 50);

-- Hat, black
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (3, 'black', 'Fits all', 50);

-- Bottle, blue
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (4, 'blue', 'Fits all', 50);

-- Bottle, red
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (4, 'red', 'Fits all', 50);

-- Bottle, transparent
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (4, 'transparent', 'Fits all', 50);

-- Dog set, green
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (5, 'green', 'Small dogs', 50);

-- Dog set, orange
INSERT INTO product_entries (product_id, color, size_value, quantity) VALUES (5, 'orange', 'Small dogs', 50);
