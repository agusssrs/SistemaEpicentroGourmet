package Modules;

import java.time.LocalDate;

public class Cocinero extends Personal {
	private String especialidad;
	private String categoria;
	private float plusFijo;

	public Cocinero(int idPersonal, String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, float sueldoBase, String especialidad, String categoria, float plusFijo){
		super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.categoria = categoria;
		this.plusFijo = plusFijo;
	}


	@Override
	public String toString() {
		return "\nCocinero [" + super.toString() + ", especialidad=" + especialidad + ", categoria=" + categoria
				+ ", plusFijo=" + plusFijo + "]";
	}
}