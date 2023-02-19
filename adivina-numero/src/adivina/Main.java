package adivina;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		adivinador(6);
	}

	static void adivinador(int vidas) {
		int aleatorio = (int) (Math.random() * 101);
		int numero = -1;
		Scanner leer = new Scanner(System.in);

		externo:
		while (aleatorio != numero) {
			System.out.println("Ingrese un número entre el 1 y el 100: ");
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
				System.out.println("PERDISTE");
				break externo;
			} else {
				System.out.printf("Te quedan %d vidas \n", vidas);
			}

		}
		if(aleatorio == numero) {
			System.out.println("VICTORIA: " + aleatorio + " es el número correcto");
		}
		
	}

}
