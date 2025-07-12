drop table if exists products CASCADE;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    account VARCHAR(20),
    balance numeric(20,2) NOT NULL DEFAULT 0.00,
    product_type varchar(100),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);