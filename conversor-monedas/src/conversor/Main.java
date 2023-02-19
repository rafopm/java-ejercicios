package conversor;

import java.util.Scanner;

public class Main {
	
	static Moneda[] moneda = new Moneda[] { 
			new Moneda(0, "", 0.00), 
			new Moneda(1, "Soles Peruanos", 3.82),
			new Moneda(2, "Pesos Colombianos", 4883.09), 
			new Moneda(3, "Pesos Mexicanos", 18.36),
			new Moneda(4, "Pesos Argentinos", 192.62),
			new Moneda(5, "Bolivianos", 6.85) };
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.println("");
			System.out.println("**** CONVIERTE TU MONEDA A DÓLARES ****");
			System.out.println("---------------------------------------");
			for(int i = 1; i < moneda.length; i++) {
				System.out.println(i+" -> "+ moneda[i].nombreMoneda);
			}
			System.out.println(moneda.length+" -> SALIR \n");
			
			try {
				Scanner leer = new Scanner(System.in);
				System.out.print("Escribe la opción: ");
				int opcion = leer.nextInt();
				if(opcion == moneda.length) {
					System.out.println("");
					System.out.println("HASTA PRONTO...");
					break;
				} else if(opcion > 0 && opcion < moneda.length) {
					convertidor(opcion);
				} 
			} catch (Exception e) {
				System.out.println("No es una opción válida");
			}
		}
	}

	static void convertidor(int opcion) {
		Scanner leer = new Scanner(System.in);
		System.out.printf("Ingresa la cantidad de %s: ", moneda[opcion].nombreMoneda);	
		try {
			Double cantidadMoneda = leer.nextDouble();
			Double cambio = (Double) (Math.round(cantidadMoneda / moneda[opcion].tipoDeCambio * 100) / 100d);
			System.out.println("==> Son "+cambio + " Dólares Américanos");
		} catch (Exception e) {
			System.out.println("No es un número válido");
			System.out.println("Ingrese un número con el siguiente formato 999,99");
		}
	}
}
