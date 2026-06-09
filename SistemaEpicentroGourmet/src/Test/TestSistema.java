package Test;

import java.time.LocalDate;


import Modules.Sistema;
import Modules.UnidadVenta;


public class TestSistema {
    public static void main(String[] args) {
    	Sistema s = new Sistema();

		try {

			s.agregarFestival("Sabores del Mundo", "Invierno", LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 20));

			s.agregarCocinero("Mario", "Gomez", 11111111, LocalDate.of(1985, 5, 12), LocalDate.of(2020, 3, 1),
					"Pastas", "Senior", 35000);

			s.agregarCocinero("Laura", "Perez", 22222222, LocalDate.of(1990, 8, 20), LocalDate.of(2022, 6, 15),
					"Parrilla", "Junior", 20000);

			s.agregarCajero("Tomas", "Lopez", 33333333, LocalDate.of(1998, 2, 10), LocalDate.of(2021, 4, 5),
					"Mañana");

			s.agregarCajero("Sofia", "Diaz", 44444444, LocalDate.of(1995, 11, 3), LocalDate.of(2019, 9, 12),
					"Noche");

			s.agregarFoodTruck("Burger House", "Mario Gomez", 20, 'A', 123456, true);
			s.agregarFoodTruck("Taco Truck", "Laura Perez", 15, 'B', 654321, false);
			s.agregarPuestoDesarmable("Pastas del Sur", "Tomas Lopez", 18, 'C', 3, 60);
			s.agregarPuestoDesarmable("Dulce Feria", "Sofia Diaz", 12, 'D', 2, 40);

			UnidadVenta u1 = s.traerUnidad('A');
			UnidadVenta u2 = s.traerUnidad('B');
			UnidadVenta u3 = s.traerUnidad('C');

			u1.agregarPersonal(s.traerPersonal(11111111));
			u1.agregarPersonal(s.traerPersonal(33333333));

			u2.agregarPersonal(s.traerPersonal(22222222));

			u3.agregarPersonal(s.traerPersonal(44444444));

			u1.agregarPlato("Hamburguesa completa", 8500, 3500);
			u1.agregarPlato("Papas cheddar", 4500, 1800);

			u2.agregarPlato("Taco mixto", 6000, 2500);
			u2.agregarPlato("Nachos", 5000, 2000);

			u3.agregarPlato("Ravioles", 7500, 3000);
			u3.agregarPlato("Ñoquis", 7000, 2800);

			s.agregarPedido(LocalDate.of(2026, 7, 11), u1);
			s.traerUltimoPedido().agregarItem(u1.traerPlato(1), 3);
			s.traerUltimoPedido().agregarItem(u1.traerPlato(2), 2);

			s.agregarPedido(LocalDate.of(2026, 7, 11), u1);
			s.traerUltimoPedido().agregarItem(u1.traerPlato(1), 2);

			s.agregarPedido(LocalDate.of(2026, 7, 12), u2);
			s.traerUltimoPedido().agregarItem(u2.traerPlato(1), 4);
			s.traerUltimoPedido().agregarItem(u2.traerPlato(2), 1);

			s.agregarPedido(LocalDate.of(2026, 7, 13), u3);
			s.traerUltimoPedido().agregarItem(u3.traerPlato(1), 2);
			s.traerUltimoPedido().agregarItem(u3.traerPlato(2), 3);

			System.out.println(s);

			System.out.println("\nPersonal por DNI:");
			System.out.println(s.traerPersonal(22222222));

			System.out.println("\nUnidad por codigo:");
			System.out.println(s.traerUnidad('A'));

			System.out.println("\nCanon Burger House:");
			System.out.println(u1.calcularCanon(s.getCostos()));

			System.out.println("\nRecaudacion por festival:");
			System.out.println(s.reporteRecaudacion(s.getFestival()));

			System.out.println("\nPersonal nacido entre fechas:");
			System.out.println(s.filtrarPersonalPorEdad(LocalDate.of(1980, 1, 1), LocalDate.of(1996, 12, 31)));

			System.out.println("\nRentabilidad neta Burger House:");
			System.out.println(s.calcularRentabilidadNeta(u1, s.getFestival()));

			System.out.println("\nRentabilidad neta Burger House entre fechas:");
			System.out.println(s.calcularRentabilidadNetaEntreFechas(u1, LocalDate.of(2026, 7, 10),
					LocalDate.of(2026, 7, 12)));

			System.out.println("\nRanking de unidades:");
			System.out.println(s.rankingUnidades(s.getFestival()));

			System.out.println("\nPlato estrella Burger House:");
			System.out.println(s.platoEstrella(u1, s.getFestival()));

			System.out.println("\nAuditoria personal festival:");
			System.out.println(s.auditoriaPersonalFestival(s.getFestival()));

			System.out.println("\nTop 3 mayor canon:");
			System.out.println(s.unidadesConMayorCanon(s.getFestival()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}