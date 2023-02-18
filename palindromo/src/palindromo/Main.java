package palindromo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese una palabra: ");
		String cadena = leer.nextLine();

		String resultado = palindromo(cadena) ? "Si es un " : "No es un ";

		System.out.println(resultado + "Palíndromo");
	}

	static boolean palindromo(String cadena) {

		cadena = cadena.replace(" ", "");
		cadena = cadena.toLowerCase();

		StringBuilder cadenaInvertida = new StringBuilder();

		for (int i = cadena.length() - 1; i >= 0; i--) {
			cadenaInvertida.append(cadena.charAt(i));
		}
		return cadena.equals(cadenaInvertida.toString());
	}
}
