package Modules;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int idPedido;
	private LocalDate fechaTransaccion;
	private Festival festival;
	private UnidadVenta unidadVenta;
	private List<ItemPedido> listaPedido;

	public Pedido(int idPedido, LocalDate fechaTransaccion, Festival festival, UnidadVenta unidadVenta) {
		this.idPedido = idPedido;
		this.fechaTransaccion = fechaTransaccion;
		this.festival = festival;
		this.unidadVenta = unidadVenta;
		listaPedido = new ArrayList<ItemPedido>();
	}

	//Orion Quimey Jaime Adell
		public boolean agregarItem(Plato plato, int cantidad) {
			int id = 1;
			if (listaPedido.size() > 0) {
				id = listaPedido.get(listaPedido.size() - 1).getCantidad() + 1;
			}
			return listaPedido.add(new ItemPedido(id, plato, cantidad));
		}
	
	//Orion Quimey Jaime Adell
	public float total() {
		float total = 0;
		for (int i = 0; i < listaPedido.size(); i++) {
			total += listaPedido.get(i).subTotal();
		}
		return total;
	}
	
	//Orion Quimey Jaime Adell
	public float totalCostosPlatos() {
		float total = 0;
		for (int i = 0; i < listaPedido.size(); i++) {
			total += listaPedido.get(i).subTotalCosto();
		}
		return total;
	}
	
	//Orion Quimey Jaime Adell
	public boolean esDeUnidad(UnidadVenta unidad) {
		return unidadVenta.getIdUnidadVenta() == unidad.getIdUnidadVenta();
	}

	//Orion Quimey Jaime Adell
	public boolean esDeFestival(Festival festival) {
		return this.festival.getId() == festival.getId();
	}

	//Orion Quimey Jaime Adell
	public int cantidadPedidaDePlato(Plato plato) {
		int cantidad = 0;
		for (int i = 0; i < listaPedido.size(); i++) {
			if (listaPedido.get(i).getPlato().getIdPlato() == plato.getIdPlato()) {
				cantidad += listaPedido.get(i).getCantidad();
			}
		}
		return cantidad;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public List<ItemPedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<ItemPedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", festival=" + festival
				+ ", unidadVenta=" + unidadVenta + ", listaPedido=" + listaPedido + "]";
	}
}