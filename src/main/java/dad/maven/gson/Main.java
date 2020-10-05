package dad.maven.gson;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static boolean isNumeric(String cadena) {
		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException e) {
			resultado = false;
		}
		return resultado;
	}

	public static void main(String[] args) {
		Persona p = new Persona();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		p.nombre = scanner.nextLine();
		
		if (!p.nombre.isEmpty() && !p.nombre.isBlank()) {
			if (isNumeric(p.nombre) == false) {
				System.out.println("Introduce el apellido: ");
				p.apellidos = scanner.nextLine();
				
				if (!p.apellidos.isEmpty() && !p.apellidos.isBlank()) {
					if (isNumeric(p.apellidos) == false) {
						System.out.println("Introduce la edad: ");
						p.edad = scanner.nextInt();
						
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						String json = gson.toJson(p);
						System.out.println(json);
					}
				}
			}
		}

	}

}
