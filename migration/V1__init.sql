CREATE TABLE categories
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    updated_at VARCHAR(255) NULL,
    value      VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE categories_v2
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL
    updated_at    VARCHAR(255) NULL,
    value         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_categories_v2 PRIMARY KEY (id)
);

CREATE TABLE jt_instructors
(
    id             BIGINT NOT NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_instructors PRIMARY KEY (id)
);

CREATE TABLE jt_mentors
(
    id      BIGINT NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_jt_mentors PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id                 BIGINT NOT NULL,
    number_of_sessions INT    NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE msc_instructors
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_instructors PRIMARY KEY (id)
);

CREATE TABLE msc_mentors
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    CONSTRAINT pk_msc_mentors PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    updated_at    VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id   BIGINT NULL,
    image         VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE products_v2
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    updated_at    VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NULL,
    categoryv2_id BIGINT NULL,
    image         VARCHAR(255) NULL,
    CONSTRAINT pk_products_v2 PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    dtype              VARCHAR(31) NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    specialization     VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    company            VARCHAR(255) NULL,
    number_of_sessions INT         NOT NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE tpc_instructors
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_instructors PRIMARY KEY (id)
);

CREATE TABLE tpc_mentors
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentors PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT    NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_users PRIMARY KEY (id)
);

ALTER TABLE jt_instructors
    ADD CONSTRAINT FK_JT_INSTRUCTORS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FK_JT_MENTORS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE products_v2
    ADD CONSTRAINT FK_PRODUCTS_V2_ON_CATEGORYV2 FOREIGN KEY (categoryv2_id) REFERENCES categories_v2 (id);