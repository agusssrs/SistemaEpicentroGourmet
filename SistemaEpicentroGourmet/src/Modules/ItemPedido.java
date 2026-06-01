package Modules;

public class ItemPedido {
	private int idItemPedido;
	private Plato plato;
	private int cantidad;

	public ItemPedido(int idItemPedido, Plato plato, int cantidad) {
		this.idItemPedido = idItemPedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public float subTotal() {
		return plato.getPrecioVenta() * cantidad;
	}

	public float subTotalCosto() {
		return plato.getPrecioProduccion() * cantidad;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
}