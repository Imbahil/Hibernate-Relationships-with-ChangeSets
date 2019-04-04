CREATE TABLE users (
  id BIGINT PRIMARY KEY
);

CREATE TABLE addresses (
  id BIGINT PRIMARY KEY
);

CREATE TABLE users_addresses (
  user_id BIGINT CONSTRAINT fk_users_addresses_user_id REFERENCES users(id) ON DELETE CASCADE,
  address_id BIGINT CONSTRAINT fk_users_addresses_address_id REFERENCES addresses(id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, address_id)
);

CREATE INDEX idx_users_addresses ON users_addresses(user_id);