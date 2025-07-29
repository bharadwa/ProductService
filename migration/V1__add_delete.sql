ALTER TABLE categories
    ADD deleted BIT(1) NULL;

ALTER TABLE categories_v2
    ADD deleted BIT(1) NULL;

ALTER TABLE products
    ADD deleted BIT(1) NULL;

ALTER TABLE products_v2
    ADD deleted BIT(1) NULL;

ALTER TABLE st_users
    MODIFY avg_rating DOUBLE NOT NULL;

ALTER TABLE st_users
    MODIFY number_of_sessions INT NOT NULL;