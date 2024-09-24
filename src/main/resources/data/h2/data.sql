INSERT INTO PERSONAS (ID, DISCRIMINADOR, DNI, NOMBRE, APELLIDOS, DIRECCION, POBLACION, CODIGO_POSTAL, PROVINCIA, PAIS, TELEFONO_MOVIL, TELEFONO_FIJO, EMAIL) VALUES 
(50, 'TEC', '42009815L', 'Honorio', 'Martín Salvador', 'c/ Maquinista 4 2º 1ª', 'Barcelona', '08003', 'Barcelona', 'España', '687556092', NULL, 'honorio.martin@flashware.com'),
(51, 'CLI', 'B20090341', 'José Ramón', 'Piñeiro Bermúdez', 'Avda. De la Constitución, 24 2º', 'San Mateu', '70992', 'España', 'Castellón', '636892316', NULL, 'josepibe454@hotmail.com'),
(52, 'TEC', '23099012Y', 'Pepín', 'Gálvez Ridruejo', 'Plaza Juan Castellanos, 10', 'Madrid', '80840', 'Madrid', 'España', '635909090', '91 2214562', 'jose.galvez@flashware.com'),
(53, 'TEC', '32985562S', 'Carlota', 'Cifuentes Merino', 'Avda de la Industria 56 ático segunda', 'Móstoles', '80820', 'Madrid', 'España', '621217094', NULL, 'carlota.cifuentes@flashware.com'),
(54, 'CLI', 'B30023324', 'Anna', 'Garriga Oms', 'c/ San Carlos, s/n', 'Mataró', '98090', 'Barcelona', 'España', '207888891', NULL, 'metalcom.admin@metalcom.net'),
(55, 'TEC', '20981158H', 'Juan', 'Andujar Oliver', 'Avda. Del Expulsado, 14', 'Almería', '04001', 'Almería', 'España', '607892134', '952457671', 'andujar.oliver@flashware.com');

INSERT INTO PRODUCTOS (CODIGO, NOMBRE, DESCRIPCION, FECHA_ALTA, PRECIO, DESCATALOGADO, CATEGORIA) VALUES
(100, 'Impresora Laser HP 2P', 'Impresora Laser de gran calidad.', '2019-04-20', 240.50, FALSE, 'HARDWARE'),
(101, 'Alfombrilla Mouse Pocoyo', 'Fantástica alfombrilla de nuestro amigo Pocoyo', '2019-04-25', 10.00, FALSE, 'CONSUMIBLE'),
(102, 'ContaNerd Deluxe v3', 'Software de contabilidad y gestión.', '2020-07-14', 25.00, FALSE, 'SOFTWARE'),
(103, 'Procesador i7 13700K', 'Procesador de última generación para frikis del gamming!', '2023-07-15', 412.50, FALSE, 'HARDWARE'),
(104, 'Procesador i5 98700K', 'Procesador de última generación para frikis del gamming!', '2021-010-09', 217.75, FALSE, 'HARDWARE'),
(105, 'ContaNerd Lite v2', 'Software básico de contabilidad y gestión.', '2021-010-09', 14.99, FALSE, 'SOFTWARE'),
(106, 'Alfombrilla Mouse Bob Esponja', 'Fantástica alfombrilla de nuestro amigo Bob Esponja', '2019-04-25', 10.00, FALSE, 'CONSUMIBLE'),
(107, 'Alfombrilla Mouse Rayo McQueen', 'Fantástica alfombrilla de la película Cars', '2019-04-25', 10.00, FALSE, 'CONSUMIBLE'),
(108, 'Alfombrilla Mouse Torrente', 'Fantástica alfombrilla de nuestro amigo Torrente', '2019-04-25', 10.00, TRUE, 'CONSUMIBLE'),
(109, 'Alfombrilla Mouse The Penguin', 'Fantástica alfombrilla del personaje de Batman', '2019-04-25', 10.00, FALSE, 'CONSUMIBLE');

INSERT INTO ESTABLECIMIENTOS (ID, NOMBRE, DIRECCION, POBLACION, C_POSTAL, PROVINCIA, PAIS, TELEFONO_MOVIL, TELEFONO_FIJO, EMAIL) VALUES
(1000, 'FlashWare GRAN VIA II', 'Avda. De Les Corts Catalanes, 245', 'Barcelona', '08034', 'Barcelona', 'España', '620897056', '93 2209087', 'granvia@flashware.com'),
(1001, 'FlashWare La Vaguada', 'c/ Lope de Vega, 23', 'Madrid', '89077', 'Madrid', 'España', '629897052', '91 225 89 72', 'vaguada@flashware.com');
