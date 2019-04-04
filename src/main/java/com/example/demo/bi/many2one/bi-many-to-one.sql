CREATE TABLE addresses (
  id BIGINT PRIMARY KEY
);

CREATE TABLE users (
  id         BIGINT PRIMARY KEY,
  address_id BIGINT NOT NULL CONSTRAINT fk_addresses_users_addresses_id REFERENCES addresses (id) ON DELETE CASCADE
);


CREATE INDEX idx_users
  ON users (address_id);