package adivina;

import java.util.Scanner;

public class Main {

	static Nivel[] nivel = new Nivel[] { 
			new Nivel(0, "", 0), 
			new Nivel(1, "Muy fácil: ", 10),
			new Nivel(2, "Fácil", 8), 
			new Nivel(3, "Medio", 6),
			new Nivel(4, "Difícil", 5),
			new Nivel(5, "Muy difícil", 4) };
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("=========  ADIVINA EL NÚMERO  =========");
			System.out.println("---------------------------------------");
			for(int i = 1; i < nivel.length; i++) {
				System.out.println(i+" -> "+ nivel[i].nombreNivel);
			}
			System.out.println(nivel.length+" -> SALIR \n");
			
			try {
				Scanner leer = new Scanner(System.in);
				System.out.print("Escribe la opción: ");
				int opcion = leer.nextInt();
				if(opcion == nivel.length) {
					System.out.println("");
					System.out.println("HASTA PRONTO...");
					break;
				} else if(opcion > 0 && opcion < nivel.length) {
					adivinador(nivel[opcion].vidas);
				} 
			} catch (Exception e) {
				System.out.println("No es una opción válida");
			}
		}
	}

	static void adivinador(int vidas) {
		int aleatorio = (int) (Math.random() * 101);
		int numero = -1;
		Scanner leer = new Scanner(System.in);

		externo:
		while (aleatorio != numero) {
			System.out.print("Ingrese un número entre el 1 y el 100: ");
			numero = leer.nextInt();
			if (aleatorio < numero) {
				System.out.println("El número es menor");
				vidas--;
			} else if (aleatorio > numero) {
				System.out.println("El número es mayor");
				vidas--;
			}

			if (vidas == 0) {
				System.out.printf("Te quedan %d vidas \n", vidas);
				System.out.println("GAME OVER");
				System.out.println("");
				break externo;
			} else {
				System.out.printf("Te quedan %d vidas \n", vidas);
			}

		}
		if(aleatorio == numero) {
			System.out.println("*********************************");
			System.out.println("VICTORIA: " + aleatorio + " es el número correcto");
			System.out.println("*********************************");
			System.out.println("");
		}
		
	}

}
