package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

    // Relación Many-to-One con la clase Departamento
	@ManyToOne(targetEntity = Departamento.class)
	@JoinColumn(name = "departamento", referencedColumnName = "id")
	private int departamento;

	@Column(name = "sueldo")
	private float sueldo;

	public Empleado() {
	}

	public Empleado(String nombre, int departamento, float sueldo) {

		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
	}

	public Empleado(int id, int departamento, String nombre, float sueldo) {
		this.id = id;
		this.departamento = departamento;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", sueldo=" + sueldo
				+ "]";
	}

}
