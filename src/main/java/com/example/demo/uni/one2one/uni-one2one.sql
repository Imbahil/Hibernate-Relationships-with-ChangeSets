CREATE TABLE addresses (
  id BIGINT PRIMARY KEY
);

CREATE TABLE users (
  id         BIGINT PRIMARY KEY,
  address_id BIGINT UNIQUE CONSTRAINT fk_addresses_user_id REFERENCES addresses (id) ON DELETE SET NULL
);


