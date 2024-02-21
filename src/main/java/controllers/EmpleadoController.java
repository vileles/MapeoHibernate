package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;

import models.Empleado;
import models.Departamento;

public class EmpleadoController {

	// Método para crear un nuevo empleado en la base de datos
	public String createEmpleado(String nombre, int departamento, float sueldo) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			// Crear un objeto Empleado con los datos proporcionados
			Empleado empleado = new Empleado(nombre, departamento, sueldo);

			session.beginTransaction();
			// Guardar empleado en la base de datos
			session.save(empleado);

			session.getTransaction().commit();

			sessionFactory.close();

			return "Empleado creado";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ("Error al registrar empleado");

	}

	// Método para eliminar un empleado de la base de datos
	public String deleteEmpleado(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			// Obtener id del empleado y eliminarlo
			Empleado empleado = session.get(Empleado.class, id);
			session.delete(empleado);

			session.getTransaction().commit();

			sessionFactory.close();

			return "Empleado eliminado";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ("Error al eliminar empleado");

	}

	// Método para actualizar el nombre de un empleado en la base de datos
	public String updateEmpleado(int id, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			// Obtener el empleado por su id y actualizarlo
			Empleado empleado = session.get(Empleado.class, id);
			empleado.setNombre(nombre);
			session.update(empleado);

			session.getTransaction().commit();

			sessionFactory.close();

			return "Empleado actualizado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ("Error al actualizar empleado");

	}
	//Método para mostrar empleados de la base de datos
	public String getEmpleado(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();

			Empleado empleado = session.get(Empleado.class, id);

			session.getTransaction().commit();

			sessionFactory.close();

	        // Devolución del objeto Empleado en forma de cadena de texto
			return empleado.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ("Error al mostrar empleado");

	}

}
