package passwordgenerator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(passwordGenerator());
	}

	static String passwordGenerator() {
		char[] minusculas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		char[] mayusculas = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		StringBuilder cadena = new StringBuilder();
		cadena.append(minusculas);
		cadena.append(mayusculas);
		cadena.append(numeros);

		StringBuilder password = new StringBuilder();

		for (int i = 0; i <= 15; i++) {
			int cantidadCaracteres = cadena.length();
			int numeroAleatorio = (int) (Math.random() * cantidadCaracteres);
			char caracter = cadena.toString().charAt(numeroAleatorio);

			password.append(caracter);
		}
		return password.toString();
	}
}
