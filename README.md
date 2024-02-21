MapeoHibernate

Este proyecto consiste en mapear las tablas de una base de datos MySQL/MariaDB con el ORM Hibernate y realizar algunas consultas con HQL.

Base de datos
La base de datos contiene las tablas con la información necesaria para la gestión de una empresa. Las tablas son las siguientes:

Tabla departamento que contiene información de los diferentes departamentos que tiene la empresa. La clave principal es id.
Tabla empleado que contiene la información de los diferentes empleados que tiene la empresa. Tiene como clave principal id y ajena departamento que relaciona con la tabla departamentos.
La creación de las tablas y sus relaciones se dan en el fichero test_hibernate.sql que se adjunta.

Hibernate
Para mapear las tablas con Hibernate se utilizó Eclipse como IDE y se crearon las clases Departamento.java y Empleado.java con las anotaciones correspondientes. También se creó el fichero de configuración hibernate.cfg.xml con los datos de conexión a la base de datos y las referencias a las clases mapeadas.

Consultas HQL
Se realizaron las siguientes consultas con HQL:

Realiza operaciones CRUD (Create, Read, Update y Delete) sobre la tabla empleado.
Utilizando HQL lista los valores de empleado por un lado y de departamento por otro.
Utilizando HQL obtén un listado de las tablas empleado y departamento en el que se visualice id(empleado), nombre(empleado), sueldo y nombre (departamento). Para realizar esto tendrás que hacer un inner join.
