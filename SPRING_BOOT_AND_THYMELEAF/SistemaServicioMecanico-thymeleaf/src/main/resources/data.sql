INSERT INTO user (user_id, password, username, nombre) VALUES (100, '$2a$10$nnMu97NKcxLcQpDPWV5mDei2xivSEUYf9iVvnSEnoRKB0tonMIV8y', 'summer@gmail.com', 'summer');
INSERT INTO role (role_id, role) VALUES (4, 'ADMIN');
INSERT INTO user_role (user_id, role_id) VALUES (100, 4);


INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(100, 'Telesforo Filomeno', 'Epifania');
INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(101, 'Pancracio Teofilo', 'Ruperto');
INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(102, 'Vaca Oberon', 'Zoyla');

INSERT INTO personal(personal_id, apellidos, nombre) VALUES(201, 'Flores del Campo', 'Margarito');
INSERT INTO personal(personal_id, apellidos, nombre) VALUES(202, 'Gado Meza', 'Leandro');
INSERT INTO personal(personal_id, apellidos, nombre) VALUES(203, 'Eleuferio Policarpo', 'Bonifacio');

INSERT INTO servicio(servicio_id, monto, nombre) VALUES(301, 100 , 'Mantenimiento');
INSERT INTO servicio(servicio_id, monto, nombre) VALUES(302, 250 , 'Pintura');
INSERT INTO servicio(servicio_id, monto, nombre) VALUES(303, 300 , 'Planchado');