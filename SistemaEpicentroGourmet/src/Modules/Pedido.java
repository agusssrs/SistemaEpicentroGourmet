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