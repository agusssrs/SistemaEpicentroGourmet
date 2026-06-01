package Modules;

import java.time.LocalDate;

public class Cajero extends Personal {
	private String turno;

	public Cajero(int idPersonal, String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, float sueldoBase, String turno) {
		super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.turno = turno;
	}


	

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "\nCajero [" + super.toString() + ", turno=" + turno + "]";
	}
}