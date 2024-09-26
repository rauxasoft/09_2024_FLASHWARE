INSERT INTO PERSONAS (ID, DISCRIMINADOR, DNI, NOMBRE, APELLIDOS, DIRECCION, POBLACION, CODIGO_POSTAL, PROVINCIA, PAIS, TELEFONO_MOVIL, TELEFONO_FIJO, EMAIL) VALUES 
(1, 'TEC', '11111111R', 'Nombre Técnico 1', 'Apellidos 1', 'c/ Técnico 1', 'Población 1', '08003', 'Provincia 1', 'Pais 1', '687556092', NULL, 'tecnico1@flashware.com'),
(2, 'TEC', '22222222S', 'Nombre Técnico 2', 'Apellidos 2', 'c/ Técnico 2', 'Población 2', '08003', 'Provincia 2', 'Pais 2', '687556092', NULL, 'tecnico2@flashware.com'),
(3, 'CLI', '33333333T', 'Nombre Cliente 3', 'Apellidos 3', 'c/ Técnico 3', 'Población 3', '70992', 'Provincia 3', 'Pais 3', '636892316', NULL, 'cliente3@hotmail.com'),
(4, 'CLI', '44444444U', 'Nombre Cliente 4', 'Apellidos 4', 'c/ Técnico 4', 'Población 4', '70992', 'Provincia 4', 'Pais 4', '636892316', NULL, 'cliente4@hotmail.com');

INSERT INTO PRODUCTOS (CODIGO, NOMBRE, DESCRIPCION, FECHA_ALTA, PRECIO, DESCATALOGADO, CATEGORIA) VALUES
(1, 'Producto 1', 'Descripción Producto 1', '2019-04-20',  240.50, FALSE, 'HARDWARE'),
(2, 'Producto 2', 'Descripción Producto 2', '2019-04-25',   10.00, FALSE, 'CONSUMIBLE'),
(3, 'Producto 3', 'Descripción Producto 3', '2020-07-14',   25.00, FALSE, 'SOFTWARE'),
(4, 'Producto 4', 'Descripción Producto 4', '2023-07-15',  412.50, FALSE, 'HARDWARE'),
(5, 'Producto 5', 'Descripción Producto 5', '2021-010-09', 217.75, TRUE,  'HARDWARE'),
(6, 'Producto 6', 'Descripción Producto 6', '2021-010-09',  14.99, FALSE, 'SOFTWARE');

INSERT INTO ESTABLECIMIENTOS (ID, NOMBRE, DIRECCION, POBLACION, C_POSTAL, PROVINCIA, PAIS, TELEFONO_MOVIL, TELEFONO_FIJO, EMAIL) VALUES
(1, 'Establecimiento 1', 'Avda. De Les Corts Catalanes, 245', 'Barcelona', '08034', 'Barcelona', 'España', '620897056', '93 2209087', 'granvia@flashware.com'),
(2, 'Establecimiento 2', 'c/ Lope de Vega, 23', 'Madrid', '89077', 'Madrid', 'España', '629897052', '91 225 89 72', 'vaguada@flashware.com');

INSERT INTO PEDIDOS (NUMERO, FECHA_HORA, ESTADO, ID_CLIENTE, ID_TECNICO, ID_ESTABLECIMIENTO, OBSERVACIONES) VALUES 
(1, {ts '2024-09-23 11:47'}, 'SERVIDO',       1, 3, 2, 'Observaciones Pedido 1'),
(2, {ts '2024-09-23 11:52'}, 'CANCELADO',  NULL, 3, 2, NULL),
(3, {ts '2024-09-23 11:58'}, 'SERVIDO',    NULL, 3, 2, NULL),
(4, {ts '2024-09-23 12:15'}, 'EN_PROCESO', NULL, 4, 1, 'Observaciones Pedido 4'),
(5, {ts '2024-09-23 12:21'}, 'NUEVO',         2, 3, 2, NULL);

INSERT INTO LINEAS_PEDIDO (NUMERO_PEDIDO, CODIGO_PRODUCTO, CANTIDAD, PRECIO) VALUES 
(1, 1, 	5, 240.50),
(1, 2, 10,  10.00),
(1, 6,  5,  14.99),
(2, 2,  1,  10.00),
(2, 3,  1,  25.00),
(3, 4,  1, 412.50),
(4, 2,  1,  10.50),
(5, 2,  1, 412.50);