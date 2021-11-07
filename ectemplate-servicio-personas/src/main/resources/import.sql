INSERT INTO usuarios (nombre, apellidos, edad, username, password) VALUES ('nombre1', 'apellidos1', 10, 'usuario1', '$2a$10$LvAwaKD26jWjfZo6MgEWQelW84CzVJTurGZyxZXmaOwxdsEcyzyNK');
INSERT INTO usuarios (nombre, apellidos, edad, username, password) VALUES ('nombre2', 'apellidos2', 20, 'usuario2', '$2a$10$fn6ca7Wl8JVVaQQxOnuY.eEOkzNyZFeUSH8uRztCYtM2ycxCBnwM.');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);
