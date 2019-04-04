CREATE TABLE users (
  id BIGINT PRIMARY KEY
);

CREATE TABLE addresses (
  id BIGINT PRIMARY KEY
);

CREATE TABLE users_addresses (
  user_id    BIGINT NOT NULL CONSTRAINT fk_users_addresses_user_id REFERENCES users (id) ON DELETE CASCADE,
  address_id BIGINT NOT NULL CONSTRAINT fk_users_addresses_address_id REFERENCES addresses (id) ON DELETE CASCADE
);

CREATE INDEX idx_users_addresses
  ON users_addresses (user_id);

