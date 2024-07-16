# Mapeo y Consultas con Hibernate

Este proyecto consiste en mapear las tablas de una base de datos MySQL/MariaDB utilizando el ORM Hibernate y realizar consultas utilizando HQL.

## Base de datos

La base de datos contiene las siguientes tablas necesarias para la gestión de una empresa:

- **Tabla `departamento`:** Contiene información de los diferentes departamentos de la empresa. La clave principal es `id`.
- **Tabla `empleado`:** Contiene información de los empleados de la empresa. Tiene como clave principal `id` y una clave ajena `departamento` que relaciona con la tabla `departamentos`.

La creación de estas tablas y sus relaciones se encuentra en el archivo `test_hibernate.sql` adjunto.

## Hibernate

Para mapear las tablas con Hibernate, se utilizó Eclipse como IDE y se crearon las siguientes clases con las anotaciones correspondientes:

- `Departamento.java`
- `Empleado.java`

Además, se configuró el archivo `hibernate.cfg.xml` con los datos de conexión a la base de datos y las referencias a las clases mapeadas.

## Consultas HQL

Se realizaron las siguientes consultas utilizando HQL:

1. **Operaciones CRUD:** Se implementaron operaciones de Crear, Leer, Actualizar y Borrar sobre la tabla `empleado`.
   
2. **Listar empleados y departamentos por separado:** Utilizando HQL, se listaron los valores de la tabla `empleado` y `departamento` por separado.

3. **Listado con join de empleado y departamento:** Se utilizó HQL para obtener un listado que muestre `id(empleado)`, `nombre(empleado)`, `sueldo` y `nombre(departamento)`. Esto se logró mediante un inner join entre las tablas `empleado` y `departamento`.

---

Este proyecto proporciona un ejemplo práctico de cómo utilizar Hibernate para el mapeo de objetos a bases de datos relacionales y realizar consultas utilizando HQL. Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos.

