package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Departamento;
import models.Empleado;

public class ConsultasController {

	public String leerTablasHQL() {

		// Creamos sesión (anotando dos entidades)
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).addAnnotatedClass(Departamento.class).buildSessionFactory();

		// Abrimos sesión
		Session session = sessionFactory.openSession();

		try {
			// Iniciamos la transaccion
			session.beginTransaction();

			List<Empleado> listaEmpleados = (List<Empleado>) session.createQuery("FROM Empleado").list();
			List<Departamento> listaDepartamento = (List<Departamento>) session.createQuery("FROM Departamento").list();

			System.out.println("** Lecturas BD **");

			// Se muestran los empleados
			System.out.println("-- Empleados --");
			for (Empleado emp : listaEmpleados) {
				System.out.println(" Empleados: " + emp.toString());
			}

			// Se muestran los departamentos
			System.out.println("-- Departamentos --");
			for (Departamento dep : listaDepartamento) {
				System.out.println(" Departamentos: " + dep.toString());
			}

			session.getTransaction().commit();

			sessionFactory.close();

			return "Fin de las lecturas";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Error en las lecturas de la BD";
	}

	public String innerJoinEmpDep() {

		// Creamos la sesión (anotando dos entidades)
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Empleado.class).addAnnotatedClass(Departamento.class).buildSessionFactory();

		// Se abre la sesión
		Session session = sessionFactory.openSession();

		try {
			// Iniciamos la transaccion
			session.beginTransaction();

			// Esta query devuelve un array de objetos

			List<Object[]> listaEmpDep = (List<Object[]>) session.createQuery(
					"SELECT emp.id, emp.nombre, emp.sueldo, dep.nombre FROM Empleado as emp INNER JOIN emp.departamento dep")
					.list();

			System.out.println("** INNER JOIN de Empleado con Departameto **");

			// Se muestran los objetos del JOIN
			for (Object[] obj : listaEmpDep) {
				System.out.println(" Id empregado: " + obj[0]);
				System.out.println(" Nome: " + obj[1]);
				System.out.println(" Soldo: " + obj[2]);
				System.out.println(" Departamento: " + obj[3] + "\n");

			}

			session.getTransaction().commit();

			sessionFactory.close();

			return "Fin do INNER JOIN";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Erro ao nas lecturas da BD";
	}

}
