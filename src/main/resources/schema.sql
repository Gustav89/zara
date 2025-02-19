

CREATE TABLE brands (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);



CREATE TABLE prices (
    id INT NOT NULL AUTO_INCREMENT,
    brand_id INT NOT NULL,
    start_date DATETIME  NOT NULL,
    end_date DATETIME  NOT NULL,
    price_list INT NOT NULL,
    product_id INT NOT NULL,
    priority INT DEFAULT 0,
    price DECIMAL(10,2) NOT NULL,
    curr CHAR(3) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES brands(id),
    CHECK (end_date > start_date)
);