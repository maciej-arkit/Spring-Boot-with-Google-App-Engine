INSERT INTO shop (name, address) VALUES ('Shop-1', 'Test Street, New York');
INSERT INTO shop (name, address) VALUES ('Shop-2', 'Test Avenue, New York');

-- Roles
INSERT INTO role (role) values ("ROLE_USER");
INSERT INTO role (role) values ("ROLE_ADMIN");

-- Users
-- Password is "password"
INSERT INTO user (email, password, username) VALUES ('user@example.com', '$2a$10$zY0UtMQiV.8UBcYFxc4Dse/rxAnZeyP6Hioei1pfR9T0uVTpzr3Pm', 'user');
-- Password is "password"
INSERT INTO user (email, password, username) VALUES ('admin@example.com', '$2a$10$zY0UtMQiV.8UBcYFxc4Dse/rxAnZeyP6Hioei1pfR9T0uVTpzr3Pm', 'admin');

-- Assign roles to users
INSERT INTO user_roles (user_id, roles_id) VALUES ((SELECT id FROM user WHERE username='user'), (SELECT id FROM role WHERE role='ROLE_USER'));
INSERT INTO user_roles (user_id, roles_id) VALUES ((SELECT id FROM user WHERE username='admin'), (SELECT id FROM role WHERE role='ROLE_ADMIN'));
