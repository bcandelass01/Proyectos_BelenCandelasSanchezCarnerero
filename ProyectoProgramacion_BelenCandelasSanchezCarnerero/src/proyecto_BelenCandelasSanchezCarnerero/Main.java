package proyecto_BelenCandelasSanchezCarnerero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// EJEMPLO DE CLASE MAIN PARA VER EL FUNCIONAMIENTO DE LAS CLASES
		Scanner sc = new Scanner(System.in);
		
		// Creamos un organizador y un usuario
		Organizador organizador = new Organizador("EMPRESA ABC", "empresaABC@correo.com");
		Usuario usuario = new Usuario("Belen Candelas", "belencandelas@correo.com", "belen12345");
		
		// Creamos una ubicacion
		Ubicacion ubicacion = new Ubicacion("Online", true);
		
		// Creamos un evento
		Evento evento = organizador.crearEvento("Conferencia de sostenibilidad", "28-02-2025", 2, ubicacion, Categoria.CONFERENCIA);
		
		// Creamos un menú con distintas opciones
		int opcion;
		do {
			System.out.println("--- Sistema de gestión de eventos ---");
			System.out.println("1. Ver detalles del evento");
			System.out.println("2. Inscribirse en el evento");
			System.out.println("3. Cancelar la inscripción en el evento");
			System.out.println("4. Cancelar evento (opción de organizador)");
			System.out.println("5. Salir del menú");
			System.out.print("Elija una opción: ");
			opcion = sc.nextInt();
			System.out.println();
			
			// Creamos un switch para actuar dependiendo de la selección del menú
			switch(opcion) {
			case 1:
				evento.mostrarDetalles();
				System.out.println();
				break;
				
			case 2:
				usuario.inscribirse(evento);
				System.out.println();
				break;
				
			case 3:
				usuario.cancelarInscripcion(evento);
				System.out.println();
				break;
				
			case 4:
				organizador.cancelarEvento(evento);
				System.out.println();
				break;
				
			case 5:
				System.out.println("Saliendo del sistema...");
				
			default:
				System.out.println("Opción inválida.");
			}
		} while (opcion != 5);
		
		sc.close();
	}

}
