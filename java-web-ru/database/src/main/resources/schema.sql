-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR,
    price INT
);

-- END
