-- Insert products
INSERT INTO products (name, description, sex, featured, price) VALUES ('Hiking Boots', 'Holds your feet warm', 'unisex', 1, 2400);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Sweater', 'Holds the heat effectively', 'unisex', 1, 800);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Winter Hat', 'Available with Norwegian and Swedish flag', 'unisex', 1, 200);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Water Bottle', 'Hook for easy attachment to a bag', 'unisex', 0, 120);
INSERT INTO products (name, description, sex, featured, price) VALUES ('Clothes set for Dogs', 'Boots, pants, and a sweater', 'unisex', 0, 6670);

-- Insert colors for boots
INSERT INTO colors (color) VALUES ('black');
INSERT INTO colors (color) VALUES ('blue');
INSERT INTO colors (color) VALUES ('red');
INSERT INTO colors (color) VALUES ('green');
INSERT INTO colors (color) VALUES ('orange');
INSERT INTO colors (color) VALUES ('transparent');

-- Insert boots into product entries
-- Boots
INSERT INTO product_entries (product_id, color_id) VALUES (1, 1);
INSERT INTO product_entries (product_id, color_id) VALUES (1, 2);
INSERT INTO product_entries (product_id, color_id) VALUES (1, 3);

-- Sweater
INSERT INTO product_entries (product_id, color_id) VALUES (2, 4);
INSERT INTO product_entries (product_id, color_id) VALUES (2, 5);

-- Hat
INSERT INTO product_entries (product_id, color_id) VALUES (3, 1);

-- Bottle
INSERT INTO product_entries (product_id, color_id) VALUES (4, 2);
INSERT INTO product_entries (product_id, color_id) VALUES (4, 3);
INSERT INTO product_entries (product_id, color_id) VALUES (4, 6);

-- Dog set
INSERT INTO product_entries (product_id, color_id) VALUES (5, 4);
INSERT INTO product_entries (product_id, color_id) VALUES (5, 5);
