-- ALTER TABLE productos DISABLE TRIGGER ALL;
-- ALTER TABLE productos_caracteristicas DISABLE TRIGGER ALL;
-- ALTER TABLE productos_especificaciones DISABLE TRIGGER ALL;
-- ALTER TABLE imagenes_productos DISABLE TRIGGER ALL;

INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (1,'Bolas de papel para decorar el árbol de navidad o la estancia');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (7,'Estrellas de papel en 3D para decorar el árbol o la estancia');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (11,'Estrellas de papel en 2D para decorar el árbol o la estancia');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (15,'Corazones de papel para decorar el árbol');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (20,'Servilleteros para decorar la mesa de Navidad');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (26,'Posavasos para la mesa de Navidad');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (31,'Copos de nieve de resina con efecto de perla, para decoración de árbol o estancia');
INSERT INTO productos_caracteristicas (id_producto_caracteristicas,descripcion) VALUES (36,'Magnífico árbol para recrear una estancia navideña, con set de adornos de bolas y guirnaldas');



INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES ('Decoración',NOW(),'Bolas de Papel para árbol',3.99,NULL,1);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Decoracion',NOW(),'Estrellas de Papel 3D',5.99,NULL,7);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Decoración',NOW(),'Estrellas de Papel 2D',4.99,NULL,11);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Decoración',NOW(),'Corazones de Papel',6.99,NULL,15);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Accesorios',NOW(),'Servilleteros',8.99,NULL,20);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Accesorios',NOW(),'Posavasos',3.99,NULL,26);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Decoración',NOW(),'Copos de Nieve',9.99,NULL,31);
INSERT INTO productos (categoria,create_at,nombre,precio,valoracion,fk_id_producto_caracteristicas) VALUES('Arboles',NOW(),'Arbol Delux',25.99,NULL,36);
	 
	 

INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(2,'Pack','6 bolas',1);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(3,'Material','Papel e hilo',1);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(8,'Pack','4 estrellas de papel',7);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(12,'Pack','4 estrellas de papel',11);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(16,'Pack','4 corazones',15);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(17,'Colores','Rojo y Blanco',15);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(21,'Material','madera',20);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(22,'Colores','Rojo y Blanco',20);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(23,'Pack','6 servilleteros',20);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES(27,'Pack','6 posavasos',26);

INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (28,'Material','madera',26);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (32,'Material','resina',31);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (33,'Pack','2 Copos',31);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (37,'altura','1,80',36);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (38,'peso','7 kg',36);
INSERT INTO productos_especificaciones (id_producto_especificacion,clave_especificacion,descripcion_especificacion,fk_id_producto_especificacion) VALUES (39,'Complementos','Bolas y Guirnaldas',36);
	 

INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (4,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',1);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (6,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',1);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (9,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',7);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (10,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',7);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (13,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',11);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (14,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',11);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (18,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',15);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (19,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',15);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (24,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',20);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (25,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',20);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (29,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',26);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (30,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',26);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (34,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',31);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (35,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',31);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (43,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',36);
INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (44,'undefined','5877141_3013686.jpg','5877141_3013686.jpg',36);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (4,'undefined','cc64c31a-6b3e-4bd3-953b-f287e9d4479f_adornoPapel.jfif','adornoPapel.jfif',1);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (6,'undefined','7f7d0d92-8ff6-47a7-b0cb-65d6b9c0662e_adornoPapel2.jfif','adornoPapel2.jfif',1);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (9,'undefined','20622252-1cf3-4286-a96a-de81d9740819_adornoPapel3.jfif','adornoPapel3.jfif',7);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (10,'undefined','37d48f86-344a-4518-b40f-c3c9b4db9cb4_adornoPapel4.jfif','adornoPapel4.jfif',7);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (13,'undefined','1614516f-183d-4fb2-89af-254085d8f636_adornoPapel5.jfif','adornoPapel5.jfif',11);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (14,'undefined','40f2a96b-1005-4fb2-bdb0-f33a9fb93cf5_adornoPapel6.jfif','adornoPapel6.jfif',11);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (18,'undefined','f4ca8c6b-e835-47d1-a1e7-163d4f0348e5_adornoPapel9.jfif','adornoPapel9.jfif',15);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (19,'undefined','b671f1b8-5f0f-46d3-b64d-6a6aaa57d68f_adornoPapel10.jfif','adornoPapel10.jfif',15);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (24,'undefined','6ecaf9ab-a282-4e83-9579-bd9ce256ddaa_adornoPapel11.jfif','adornoPapel11.jfif',20);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (25,'undefined','13cb64ed-54f8-464c-952f-3fc3cae8c4dd_adornoPapel12.jfif','adornoPapel12.jfif',20);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (29,'undefined','2cfb9b32-2345-4c35-9d0b-f348f2ee6f97_adornoPapel13.jfif','adornoPapel13.jfif',26);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (30,'undefined','cfcccfcd-246b-48bb-a3dd-2f5d71544c8f_adornoPapel14.jfif','adornoPapel14.jfif',26);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (34,'undefined','5014395c-8f4f-49b6-ab8f-9f5e1a85e55b_adornoPapel16.jfif','adornoPapel16.jfif',31);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (35,'undefined','43ab089c-01f4-415f-82ba-bd077f8e2921_adornoPapel15.jfif','adornoPapel15.jfif',31);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (43,'undefined','1cc05574-e1be-4b93-ac91-2c72d9bea9e7_arbol20_reducido.jpg','arbol20_reducido.jpg',36);
-- INSERT INTO imagenes_productos (id_imagen_producto,descripcion_imagen,imagen,nombre_imagen,fk_id_imagen_producto) VALUES (44,'undefined','b8983ff0-bc82-4250-9324-d6715e4bb898_arbol22reducido.jpg','arbol22reducido.jpg',36);


	
-- ALTER TABLE productos ENABLE TRIGGER ALL;
-- ALTER TABLE productos_caracteristicas ENABLE TRIGGER ALL;
-- ALTER TABLE productos_especificaciones ENABLE TRIGGER ALL;
-- ALTER TABLE imagenes_productos ENABLE TRIGGER ALL;