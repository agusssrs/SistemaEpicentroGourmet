package Modules;

import java.time.LocalDate;

public abstract class Personal {
	protected int idPersonal;
	protected int edad;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected float sueldoBase;
	protected LocalDate fechaActual;

	public Personal(int idPersonal, String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, float sueldoBase) {

		this.idPersonal = idPersonal;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.fechaActual = LocalDate.now();

		setFechaNacimiento(fechaNacimiento);
	}
	
	//Alejo Tomas Machado Prieto 
		public int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
			int edad = fechaActual.getYear() - fechaNacimiento.getYear();

			if(fechaActual.getMonthValue() < fechaNacimiento.getMonthValue() || (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue() && fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
				edad--;
			}

			return edad;
		}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	// Agustin Nicolas Mancini
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		int edadCalculada = calcularEdad(fechaNacimiento, LocalDate.now());

		if(edadCalculada < 18) {
			throw new IllegalArgumentException("El personal debe ser mayor de edad");
		}

		this.fechaNacimiento = fechaNacimiento;
		this.edad = edadCalculada;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", edad=" + edad + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso
				+ ", sueldoBase=" + sueldoBase + ", fechaActual=" + fechaActual + "]";
	}
	
	
}