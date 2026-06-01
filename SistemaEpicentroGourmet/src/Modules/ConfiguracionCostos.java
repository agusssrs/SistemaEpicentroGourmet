package Modules;

public class ConfiguracionCostos {
	private float sueldoBase;
	private float costoPorSuperficie;
	private float plusElectricidad;
	private float costoMinutoMontaje;
	private float valorAnioAntiguedad;

	public ConfiguracionCostos() {
		sueldoBase = 100000;
		costoPorSuperficie = 500;
		plusElectricidad = 2000;
		costoMinutoMontaje = 10;
		valorAnioAntiguedad = 5000;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public float getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(float costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public float getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(float plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public float getCostoMinutoMontaje() {
		return costoMinutoMontaje;
	}

	public void setCostoMinutoMontaje(float costoMinutoMontaje) {
		this.costoMinutoMontaje = costoMinutoMontaje;
	}

	public float getValorAnioAntiguedad() {
		return valorAnioAntiguedad;
	}

	public void setValorAnioAntiguedad(float valorAnioAntiguedad) {
		this.valorAnioAntiguedad = valorAnioAntiguedad;
	}

	@Override
	public String toString() {
		return "ConfiguracionCostos [sueldoBase=" + sueldoBase + ", costoPorSuperficie=" + costoPorSuperficie
				+ ", plusElectricidad=" + plusElectricidad + ", costoMinutoMontaje=" + costoMinutoMontaje
				+ ", valorAnioAntiguedad=" + valorAnioAntiguedad + "]";
	}
}
