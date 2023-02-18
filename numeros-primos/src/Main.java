import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("VERIFICADOR DE NÚMEROS PRIMOS");
		System.out.println("-----------------------------");

		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese un número: ");
		String cadena = leer.next();
		int numero = 0;
		
		if (cadena.chars().allMatch( Character::isDigit )) {
			numero = Integer.valueOf(cadena);
			String resultado = (esprimo(numero)) ? "Es " : "No es ";
			System.out.println(resultado + "Primo");
		} else {
			System.out.print("Ingrese solo números enteros");
		}
	}

	static boolean esprimo(int numero) {
		
		ArrayList<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < numero; i++) {
			numeros.add(i + 1);
		}
		int divisores = 0;

		for (int i : numeros) {
			if (i == 1 || i == numero)
				continue;

			if (numero % i == 0)
				divisores++;
		}

		return (numero <= 1 || divisores > 0) ? false : true;
	}

}
