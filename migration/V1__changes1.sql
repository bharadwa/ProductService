ALTER TABLE categories
    ADD `description` VARCHAR(255) NULL;

ALTER TABLE st_users
    MODIFY avg_rating DOUBLE NOT NULL;

ALTER TABLE st_users
    MODIFY number_of_sessions INT NOT NULL;