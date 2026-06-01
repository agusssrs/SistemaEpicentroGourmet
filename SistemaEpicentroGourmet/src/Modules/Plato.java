package Modules;

public class Plato {
	private int idPlato;
	private String nombrePlato;
	private float precioVenta;
	private float precioProduccion;

	public Plato(int idPlato, String nombrePlato, float precioVenta, float precioProduccion) {
		this.idPlato = idPlato;
		this.nombrePlato = nombrePlato;
		this.precioVenta = precioVenta;
		this.precioProduccion = precioProduccion;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getPrecioProduccion() {
		return precioProduccion;
	}

	public void setPrecioProduccion(float precioProduccion) {
		this.precioProduccion = precioProduccion;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioVenta=" + precioVenta
				+ ", precioProduccion=" + precioProduccion + "]";
	}
}