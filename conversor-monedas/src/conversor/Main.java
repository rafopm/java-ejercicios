package conversor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Moneda[] moneda = new Moneda[] { 
				new Moneda(0, "", 0.00), 
				new Moneda(1, "Soles Peruano", 3.82),
				new Moneda(2, "Pesos Colombianos", 4883.09), 
				new Moneda(3, "Pesos Mexicanos", 18.36),
				new Moneda(4, "Pesos Argentinos", 192.62) };

		EXTERNA:
		while (true) {
			System.out.println("");
			System.out.println("**** CONVIERTE TU MONEDA A DÓLARES ****");
			System.out.println("---------------------------------------");
			System.out.println(
				"1 -> " + moneda[1].nombreMoneda + " \n" 
			+ 	"2 -> " + moneda[2].nombreMoneda + " \n" 
			+ 	"3 -> " + moneda[3].nombreMoneda + " \n"
			+ 	"4 -> " + moneda[4].nombreMoneda + " \n"
			+ 	"5 -> SALIR \n");
			
			Scanner leer = new Scanner(System.in);
			System.out.print("Escribe la opción: ");
			char opcion = leer.next().charAt(0);

			switch (opcion) {
				case '1':
					convertidor(moneda[1].tipoDeCambio, moneda[1].nombreMoneda);
					break;
				case '2':
					convertidor(moneda[1].tipoDeCambio, moneda[2].nombreMoneda);
					break;
				case '3':
					convertidor(moneda[1].tipoDeCambio, moneda[3].nombreMoneda);
					break;
				case '4':
					convertidor(moneda[1].tipoDeCambio, moneda[4].nombreMoneda);
					break;
				case '5':
					System.out.println("");
					System.out.println("HASTA PRONTO...");
					break EXTERNA;
				default:
					System.out.println("No es una opción válida");
					break;
			}
		}
	}

	static void convertidor(Double tipoDeCambio, String moneda) {
		Scanner leer = new Scanner(System.in);
		System.out.printf("Ingresa la cantidad de %s: ", moneda);
		Double cantidadMoneda = leer.nextDouble();
		Double cambio = (Double) (Math.round(cantidadMoneda / tipoDeCambio * 100) / 100d);
		System.out.println("==> Son "+cambio + " Dólares Américanos");
	}
}
