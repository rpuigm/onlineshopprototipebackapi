INSERT INTO usuarios (nombre, apellidos, edad, username, password) VALUES ('Cliente', 'ApellidoCliente', 10, 'cliente', '$2a$10$5dfOSR0v.wnEk8CHTtXQvudO.dM0/UIPSVFK71yZXojITFbR8Qfp.');
INSERT INTO usuarios (nombre, apellidos, edad, username, password) VALUES ('Empleado', 'ApellidoEmpleado', 20, 'empleado', '$2a$10$5dfOSR0v.wnEk8CHTtXQvudO.dM0/UIPSVFK71yZXojITFbR8Qfp.');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);
