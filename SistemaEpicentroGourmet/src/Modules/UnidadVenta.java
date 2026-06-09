package Modules;

import java.util.ArrayList;
import java.util.List;

public abstract class UnidadVenta {
	protected int idUnidadVenta;
	protected String nombre;
	protected String responsable;
	protected float superficie;
	protected char codigo;
	protected List<Plato> menu;
	protected List<Personal> staff;

	public UnidadVenta(int idUnidadVenta, String nombre, String responsable, float superficie, char codigo) {
		this.idUnidadVenta = idUnidadVenta;
		this.nombre = nombre;
		this.responsable = responsable;
		this.superficie = superficie;
		this.codigo = codigo;
		validarCodigo();
		menu = new ArrayList<Plato>();
		staff = new ArrayList<Personal>();
	}

	//Orion Quimey Jaime Adell
	public void validarCodigo() {
		if (!Character.isLetterOrDigit(codigo)) {
			throw new IllegalArgumentException("Codigo invalido");
		}
	}
	

	//Agustin Nicolas Mancini
	public abstract float calcularCanon(ConfiguracionCostos costos);
	
	//Alejo Tomas Machado Prieto 
	public boolean agregarPersonal(Personal personal) {
			return staff.add(personal);
	}

	public int getIdUnidadVenta() {
		return idUnidadVenta;
	}

	public void setIdUnidadVenta(int idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public List<Plato> getMenu() {
		return menu;
	}

	public void setMenu(List<Plato> menu) {
		this.menu = menu;
	}

	public List<Personal> getStaff() {
		return staff;
	}

	public void setStaff(List<Personal> staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombre=" + nombre + ", responsable=" + responsable
				+ ", superficie=" + superficie + ", codigo=" + codigo + ", menu=" + menu + ", staff=" + staff + "]";
	}
}
