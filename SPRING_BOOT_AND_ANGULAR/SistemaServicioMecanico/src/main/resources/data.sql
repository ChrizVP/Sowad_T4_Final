INSERT INTO user (user_id, create_date, apellidos, email, enabled, nombre, password, phone_number, role) VALUES (75, '2019-12-03 17:52:15', 'Villena Perez', 'summer@gmail.com', 1, 'Christian Raul', '$2a$10$axXlvfP6GwPSyj5A1QGmGeC3A.d18lVK89XLsQKWjvksbfou/hhSq', '123456789', 'ADMIN');

INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(100, 'Telesforo Filomeno', 'Epifania');
INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(101, 'Pancracio Teofilo', 'Ruperto');
INSERT INTO cliente(cliente_id, apellidos, nombre) VALUES(102, 'Vaca Oberon', 'Zoyla');

INSERT INTO personal(personal_id, apellidos, nombre) VALUES(201, 'Flores del Campo', 'Margarito');
INSERT INTO personal(personal_id, apellidos, nombre) VALUES(202, 'Gado Meza', 'Leandro');
INSERT INTO personal(personal_id, apellidos, nombre) VALUES(203, 'Eleuferio Policarpo', 'Bonifacio');

INSERT INTO servicio(servicio_id, monto, nombre) VALUES(301, 100 , 'Mantenimiento');
INSERT INTO servicio(servicio_id, monto, nombre) VALUES(302, 250 , 'Pintura');
INSERT INTO servicio(servicio_id, monto, nombre) VALUES(303, 300 , 'Planchado');