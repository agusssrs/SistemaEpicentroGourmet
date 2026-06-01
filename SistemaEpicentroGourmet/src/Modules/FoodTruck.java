package Modules;

public class FoodTruck extends UnidadVenta {
	private int patente;
	private boolean usoElectricidad;
	private float costoElectricidad;

	public FoodTruck(int idUnidadVenta, String nombre, String responsable, float superficie, char codigo, int patente, boolean usoElectricidad, float costoElectricidad) {
		super(idUnidadVenta, nombre, responsable, superficie, codigo);
		this.patente = patente;
		this.usoElectricidad = usoElectricidad;
		this.costoElectricidad = costoElectricidad;
	}
	
	//Agustin Nicolas Mancini
	@Override
	public float calcularCanon(ConfiguracionCostos costos) {
		float canon = superficie * costos.getCostoPorSuperficie();
		if (usoElectricidad) {
			canon += costoElectricidad;
		}
		return canon;
	}

	public int getPatente() {
		return patente;
	}

	public void setPatente(int patente) {
		this.patente = patente;
	}

	public boolean isUsoElectricidad() {
		return usoElectricidad;
	}

	public void setUsoElectricidad(boolean usoElectricidad) {
		this.usoElectricidad = usoElectricidad;
	}

	public float getCostoElectricidad() {
		return costoElectricidad;
	}

	public void setCostoElectricidad(float costoElectricidad) {
		this.costoElectricidad = costoElectricidad;
	}

	@Override
	public String toString() {
		return "FoodTruck ["+ super.toString()+"patente=" + patente + ", usoElectricidad=" + usoElectricidad + ", costoElectricidad="
				+ costoElectricidad + "]";
	}
}