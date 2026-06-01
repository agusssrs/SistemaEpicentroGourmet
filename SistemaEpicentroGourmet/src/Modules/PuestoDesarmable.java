package Modules;

public class PuestoDesarmable extends UnidadVenta {
	private int cantCarpas;
	private int tiempoMontaje;

	public PuestoDesarmable(int idUnidadVenta, String nombre, String responsable, float superficie, char codigo, int cantCarpas, int tiempoMontaje) {
		super(idUnidadVenta, nombre, responsable, superficie, codigo);
		this.cantCarpas = cantCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}

	//Agustin Nicolas Mancini
	@Override
	public float calcularCanon(ConfiguracionCostos costos) {
		return superficie * costos.getCostoPorSuperficie() - tiempoMontaje * costos.getCostoMinutoMontaje();
	}

	public int getCantCarpas() {
		return cantCarpas;
	}

	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}

	public int getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable ["+ super.toString()+"cantCarpas=" + cantCarpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
}