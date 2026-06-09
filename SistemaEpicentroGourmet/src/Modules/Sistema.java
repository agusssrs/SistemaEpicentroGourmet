package Modules;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sistema {
	private List<Personal> personal;
	private Festival festival;
	private List<UnidadVenta> unidadesVentas;
	private List<Pedido> pedidos;
	private ConfiguracionCostos costos;

	public Sistema() {
		personal = new ArrayList<Personal>();
		unidadesVentas = new ArrayList<UnidadVenta>();
		pedidos = new ArrayList<Pedido>();
		costos = new ConfiguracionCostos();
	}
	
	//Agustin Nicolas Mancini
	public Personal traerPersonal(int dni) {
		Personal aux = null;
		int i = 0;

		while (i < personal.size() && aux == null) {
			if (personal.get(i).getDni() == dni) {
				aux = personal.get(i);
			}

			i++;
		}

		return aux;
	}
	
	//Agustin Nicolas Mancini
	public boolean agregarFoodTruck(String nombre, String responsable, float superficie, char codigo, int patente, boolean usoElectricidad) {
		int id = 1;

		if (unidadesVentas.size() > 0) {
			id = unidadesVentas.get(unidadesVentas.size() - 1).getIdUnidadVenta() + 1;
		}

		FoodTruck nuevo = new FoodTruck(id, nombre, responsable, superficie, codigo, patente, usoElectricidad, costos.getPlusElectricidad());
		return unidadesVentas.add(nuevo);
	}
	
	//Agustin Nicolas Mancini
	public boolean agregarPuestoDesarmable(String nombre, String responsable, float superficie, char codigo, int cantCarpas, int tiempoMontaje) {
		int id = 1;
		if (unidadesVentas.size() > 0) {
			id = unidadesVentas.get(unidadesVentas.size() - 1).getIdUnidadVenta() + 1;
		}

		PuestoDesarmable nuevo = new PuestoDesarmable(id, nombre, responsable, superficie, codigo, cantCarpas, tiempoMontaje);
		return unidadesVentas.add(nuevo);
	}

	//Agustin Nicolas Mancini
	public UnidadVenta traerUnidad(char codigo) {
		UnidadVenta aux = null;
		int i = 0;

		while (i < unidadesVentas.size() && aux == null) {
			if (unidadesVentas.get(i).getCodigo() == codigo) {
				aux = unidadesVentas.get(i);
			}

			i++;
		}

		return aux;
	}
	
	//Agustin Nicolas Mancini
	public List<Personal> filtrarPersonalPorEdad(LocalDate desde, LocalDate hasta) {
		List<Personal> listaAux = new ArrayList<Personal>();
		
		for (Personal p : personal) {
			if ((p.getFechaNacimiento().isEqual(desde) || p.getFechaNacimiento().isAfter(desde)) && (p.getFechaNacimiento().isEqual(hasta) || p.getFechaNacimiento().isBefore(hasta))) {
				listaAux.add(p);
			}
		}

		return listaAux;
	}

	//Agustin Nicolas Mancini
	public Pedido traerUltimoPedido() {
		Pedido pedido = null;

		if (pedidos.size() > 0) {
			pedido = pedidos.get(pedidos.size() - 1);
		}

		return pedido;
	}

	//Agustin Nicolas Mancini
	public float calcularRecaudacionUnidad(UnidadVenta unidadVenta, Festival festival) {
		float total = 0;

		for (Pedido p : pedidos) {
			if (p.esDeUnidad(unidadVenta) && p.esDeFestival(festival)) {
				total += p.total();
			}
		}

		return total;
	}

	//Agustin Nicolas Mancini
	public float calcularCostoPlatosUnidad(UnidadVenta unidadVenta, Festival festival) {
		float total = 0;
		
		for (Pedido p : pedidos) {
			if (p.esDeUnidad(unidadVenta) && p.esDeFestival(festival)) {
				total += p.totalCostosPlatos();
			}
		}

		return total;
	}


	//Agustin Nicolas Mancini
	public float calcularRentabilidadNetaEntreFechas(UnidadVenta unidadVenta, LocalDate desde, LocalDate hasta) {
		float totalVentas = 0;
		float totalCostos = 0;

		for (Pedido p : pedidos) {
			if (p.esDeUnidad(unidadVenta) && (p.getFechaTransaccion().isEqual(desde) || p.getFechaTransaccion().isAfter(desde)) && (p.getFechaTransaccion().isEqual(hasta) || p.getFechaTransaccion().isBefore(hasta))) {
				totalVentas += p.total();
				totalCostos += p.totalCostosPlatos();
			}
		}

		float rentabilidad = totalVentas - totalCostos - unidadVenta.totalSueldos() - unidadVenta.calcularCanon(costos);

		return rentabilidad;
	}

	//Agustin Nicolas Mancini
	public List<ReporteVenta> reporteRecaudacion(Festival festival) {
		List<ReporteVenta> listaAux = new ArrayList<ReporteVenta>();

		for (UnidadVenta u : unidadesVentas) {
			ReporteVenta reporte = new ReporteVenta(u, calcularRecaudacionUnidad(u, festival));
			listaAux.add(reporte);
		}

		return listaAux;
	}

	//Agustin Nicolas Mancini
	public List<ReporteVenta> rankingUnidades(Festival festival) {
		List<ReporteVenta> ranking = reporteRecaudacion(festival);
		Collections.sort(ranking, new Comparator<ReporteVenta>() {
			@Override
			public int compare(ReporteVenta r1, ReporteVenta r2) {
				return Float.compare(r2.getRecaudacionTotal(), r1.getRecaudacionTotal());
			}
		});

		return ranking;
	}

	//Agustin Nicolas Mancini
	public Plato platoEstrella(UnidadVenta unidadVenta, Festival festival) {
		Plato platoEstrella = null;
		int mayorCantidad = -1;
		
		for (Plato plato : unidadVenta.getMenu()) {
			int cantidad = 0;
			
			for (Pedido pedido : pedidos) {
				if (pedido.esDeUnidad(unidadVenta) && pedido.esDeFestival(festival)) {
					cantidad += pedido.cantidadPedidaDePlato(plato);
				}
			}
			
			if (cantidad > mayorCantidad) {
				mayorCantidad = cantidad;
				platoEstrella = plato;
			}
		}

		return platoEstrella;
	}

	
	//Agustin Nicolas Mancini
	public List<ReporteMayorCanon> unidadesConMayorCanon(Festival festival) {
		List<ReporteMayorCanon> lista = new ArrayList<ReporteMayorCanon>();
		List<ReporteMayorCanon> top3 = new ArrayList<ReporteMayorCanon>();
		
		for (UnidadVenta unidad : unidadesVentas) {
			String tipo = unidad.getClass().getSimpleName();
			ReporteMayorCanon reporte = new ReporteMayorCanon(
					unidad.getNombre(),
					unidad.getCodigo(),
					tipo,
					unidad.calcularCanon(costos));

			lista.add(reporte);
		}

		Collections.sort(lista, new Comparator<ReporteMayorCanon>() {
			@Override
			public int compare(ReporteMayorCanon r1, ReporteMayorCanon r2) {
				return Float.compare(r2.getCanon(), r1.getCanon());
			}
		});

		
		for (ReporteMayorCanon reporte : lista) {
			if (top3.size() < 3) {
				top3.add(reporte);
			}
		}

		return top3;
	}
	
	//Alejo Tomas Machado Prieto 
	public boolean agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
			festival = new Festival(1, nombre, temporada, fechaInicio, fechaFin);
			return true;
	}

		//Alejo Tomas Machado Prieto
	public boolean eliminarFestival() {
			festival = null;
			return true;
	}
		
		//Alejo Tomas Machado Prieto 
	public boolean agregarCocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String especialidad, String categoria, float plusFijo) {
			int id = 1;
			
			if (personal.size() > 0) {
				id = personal.get(personal.size() - 1).getIdPersonal() + 1;
			}

			Cocinero nuevo = new Cocinero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, costos.getSueldoBase(), especialidad, categoria, plusFijo);
			return personal.add(nuevo);
	}
		
		//Alejo Tomas Machado Prieto
	public boolean agregarCajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String turno)  {
			int id = 1;

			if (personal.size() > 0) {
				id = personal.get(personal.size() - 1).getIdPersonal() + 1;
			}

			Cajero nuevo = new Cajero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, costos.getSueldoBase(), turno);
			return personal.add(nuevo);
	}

		//Alejo Tomas Machado Prieto 
	public List<Personal> auditoriaPersonalFestival(Festival festival) {
		List<Personal> listaAux = new ArrayList<Personal>();

			for (UnidadVenta unidad : unidadesVentas) {
				for (Personal p : unidad.getStaff()) {
					if (!listaAux.contains(p)) {
						listaAux.add(p);
					}
				}
			}
			return listaAux;
	}

	
	//getters y setters
	public Festival getFestival() {
		return festival;
	}

	public List<Personal> getPersonal() {
		return personal;
	}

	public List<UnidadVenta> getUnidadesVentas() {
		return unidadesVentas;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public ConfiguracionCostos getCostos() {
		return costos;
	}

	public void setCostos(ConfiguracionCostos costos) {
		this.costos = costos;
	}

	@Override
	public String toString() {
		return "Sistema [personal=" + personal + ", festival=" + festival + ", unidadesVentas=" + unidadesVentas
				+ ", pedidos=" + pedidos + "]";
	}
}