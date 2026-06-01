package Modules;

public class ReporteMayorCanon {
	private String nombreComercial;
	private char codigo;
	private String tipoUnidad;
	private float canon;

	public ReporteMayorCanon(String nombreComercial, char codigo, String tipoUnidad, float canon) {
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.tipoUnidad = tipoUnidad;
		this.canon = canon;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public float getCanon() {
		return canon;
	}

	public void setCanon(float canon) {
		this.canon = canon;
	}

	@Override
	public String toString() {
		return "ReporteMayorCanon [nombreComercial=" + nombreComercial + ", codigo=" + codigo + ", tipoUnidad="
				+ tipoUnidad + ", canon=" + canon + "]";
	}
}
