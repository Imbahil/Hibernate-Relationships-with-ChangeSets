CREATE TABLE users (
  id BIGINT PRIMARY KEY
);

CREATE TABLE addresses (
  id      BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL CONSTRAINT fk_addresses_user_id REFERENCES users (id) ON DELETE CASCADE
);

CREATE INDEX idx_addresses ON addresses (user_id);