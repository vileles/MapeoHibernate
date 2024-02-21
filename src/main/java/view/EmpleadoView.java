package view;

import controllers.ConsultasController;
import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {

		// Operaciones CRUD

		// String empleado = new EmpleadoController().createEmpleado("Ainhoa", 2, 1500);
		// String empleado = new EmpleadoController().deleteEmpleado(9);
		// String empleado = new EmpleadoController().updateEmpleado(10, "Xurxo");
		// String empleado = new EmpleadoController().getEmpleado(11);

		// System.out.println(empleado);

		// Mostrar tablas usando HQL(Tienen que existir datos en las tablas)
		// String consultasSelect = new ConsultasController().leerTablasHQL();
		// System.out.println(consultasSelect);

		// Inner usando HQL(Tienen que existir datos en las tablas)
		String consultaInner = new ConsultasController().innerJoinEmpDep();
		System.out.println(consultaInner);
	}

}
