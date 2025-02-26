package proyecto_BelenCandelasSanchezCarnerero.SinPOO;
import java.util.Scanner;


public class MainSinPOO {
	// Defino las categorías de los eventos como constantes
	final int CONFERENCIA = 0;
	final int TALLER = 1;
	final int ACTIVIDAD_SOSTENIBLE = 2;

	// Creo estructuras de datos para todos los valores necesarios
	final static int MAX_EVENTOS = 50;
	final static int MAX_USUARIOS = 100;

	static String[] nombreEventos = new String[MAX_EVENTOS];
	static String[] fechaEventos = new String[MAX_EVENTOS];
	static int[] duracionEventos = new int[MAX_EVENTOS];
	static String[] ubicacionEventos = new String[MAX_EVENTOS];
	static int[] categoriaEventos = new int[MAX_EVENTOS];
	static boolean[] eventosActivos = new boolean[MAX_EVENTOS];
	static String[][] inscritosEventos = new String[MAX_EVENTOS][MAX_USUARIOS];
	static int[] numInscritosEventos = new int[MAX_EVENTOS];
	static String[] organizadorEventos = new String[MAX_EVENTOS];
	static int numEventos = 0;

	static String[] nombreUsuarios = new String[MAX_USUARIOS];
	static String[] correoUsuarios = new String[MAX_USUARIOS];
	static String[] contrasenaUsuarios = new String[MAX_USUARIOS];
	static int numUsuarios = 0;


	/**
	 * Función para que sea posible crear un evento
	 * @param nombre (nombre del evento a crear)
	 * @param fecha (fecha del evento a crear)
	 * @param duracion (duración del evento a crear)
	 * @param ubicacion (ubicación del evento a crear)
	 * @param categoria (categoría del evento a crear)
	 * @param organizador (organizador del evento a crear)
	 */
	static void crearEvento(String nombre, String fecha, int duracion, String ubicacion, int categoria, String organizador) {
		if (numEventos < MAX_EVENTOS) {
			nombreEventos[numEventos] = nombre;
			fechaEventos[numEventos] = fecha;
			duracionEventos[numEventos] = duracion;
			ubicacionEventos[numEventos] = ubicacion;
			categoriaEventos[numEventos] = categoria;
			eventosActivos[numEventos] = true;
			organizadorEventos[numEventos] = organizador;
			numInscritosEventos[numEventos] = 0;
			numEventos ++;
			System.out.println("Evento: " + nombre + ". Ha sido creado correctamente");
			System.out.println();
		} else {
			System.out.println("No se pueden crear más eventos");
			System.out.println();
		}
	}

	
	/**
	 * Función que permite a un usuario registrarse
	 * @param nombre (nombre del usuario a registrar)
	 * @param correo (correo del usuario a registrar)
	 * @param contrasena (contraseña del usuario a registrar)
	 */
	static void registrarUsuario(String nombre, String correo, String contrasena) {
		if (numUsuarios < MAX_USUARIOS) {
			nombreUsuarios[numUsuarios] = nombre;
			correoUsuarios[numUsuarios] = correo;
			contrasenaUsuarios[numUsuarios] = contrasena;
			numUsuarios ++;
			System.out.println("El usuario: " + nombre + ". Ha sido registrado correctamente");
			System.out.println();
		} else {
			System.out.println("No se pueden registrar más usuarios");
			System.out.println();
		}
	}


	/**
	 * Función que permite a un usuario inscribirse
	 * @param eventoIndex (índice del evento)
	 * @param nombreUsuario (nombre del usuario que se quiere inscribir a un evento)
	 */
	static void inscribirUsuario(int eventoIndex, String nombreUsuario) {
		if(eventoIndex != -1 && eventosActivos[eventoIndex] && numInscritosEventos[eventoIndex] < MAX_USUARIOS) {
			inscritosEventos[eventoIndex][numInscritosEventos[eventoIndex]] = nombreUsuario;
			numInscritosEventos[eventoIndex] ++;
			System.out.println(nombreUsuario + " se ha inscrito al evento " + nombreEventos[eventoIndex] + " correctamente");
			System.out.println();
		} else {
			System.out.println("No se puede inscribir al evento");
			System.out.println();
		}
	}


	/**
	 * Función que permite cancelar un evento
	 * @param eventoIndex (índice del evento a cancelar)
	 */
	static void cancelarEvento(int eventoIndex) {
		if (eventoIndex != -1) {
			eventosActivos[eventoIndex] = false;
			System.out.println("El evento: " + nombreEventos[eventoIndex] + ". Ha sido cancelado correctamente");
			System.out.println();
		} else {
			System.out.println("El evento no ha sido encontrado");
			System.out.println();
		}
	}


	/**
	 * Función que permite cancelar la inscripción en un evento a un usuario
	 * @param eventoIndex (índice del evento)
	 * @param usuario (nombre del usuario que se quiere cancelar)
	 */
	static void cancelarInscripcion(int eventoIndex, String usuario) {
		if (eventoIndex == -1) return;
		for (int i = 0; i < numInscritosEventos[eventoIndex]; i ++) {
			if((inscritosEventos[eventoIndex][i] != null) && (inscritosEventos[eventoIndex][i].equalsIgnoreCase(usuario))) {
				inscritosEventos[eventoIndex][i] = inscritosEventos[eventoIndex][numInscritosEventos[eventoIndex] - 1];
				numInscritosEventos[eventoIndex] --;
				System.out.println(usuario + " ha cancelado su inscripción en el evento " + nombreEventos[eventoIndex]);
				System.out.println();
				return;
			}
		}
		System.out.println("El usuario no está inscrito en este evento");
		System.out.println();
	}

	/**
	 * Función que permite convertir la categoría a texto
	 * @param categoria (categoría que se quiere pasar a texto)
	 * @return texto (categoría pasada a texto)
	 */
	static String categoriaToString(int categoria) {
		switch(categoria) {
		case 0: return "Conferencia";
		case 1: return "Taller";
		case 2: return "Actividad sostenible";
		default: return "No tiene categoría aún";
		}
	}
	
	
	
	// --------------------------- CLASE MAIN ---------------------------
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		// Meto datos de prueba para ver si funciona lo que hemos programado
		crearEvento("Bio feria", "30/04/2025", 2, "Plaza Principal", 1, "Pedro Núñez");
		registrarUsuario("Belén Candelas", "belencandelas@correo.com", "belencandelas1234");
		
		
		// Creo un menú para elegir las distintas opciones
		while(!salir) {
			System.out.println("--- Sistema de gestión de eventos ---");
			System.out.println("1. Ver detalles del evento");
			System.out.println("2. Inscribirse en un evento");
			System.out.println("3. Cancelar la inscripción en un evento");
			System.out.println("4. Cancelar un evento (opción única para organizadores)");
			System.out.println("5. Salir del menú");
			System.out.print("Elija una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			// Creo un switch para elegir la forma de actuar dependiendo de la opción elegida
			switch(opcion) {
			case 1:
				mostrarDetallesEvento();
				break;
				
			case 2:
				System.out.print("Teclea tu nombre por favor: ");
				String usuario = sc.nextLine();
				System.out.print("Teclea el nombre del evento por favor: ");
				String evento = sc.nextLine();
				inscribirUsuario(buscarEvento(evento), usuario);
				break;
				
			case 3:
				System.out.print("Teclea tu nombre por favor: ");
				String usuarioCancelar = sc.nextLine();
				System.out.print("Teclea el nombre del evento por favor: ");
				String eventoCancelar = sc.nextLine();
				cancelarInscripcion(buscarEvento(eventoCancelar), usuarioCancelar);
				break;
				
			case 4:
				System.out.print("Teclea el nombre del evento por favor: ");
				String eventoEliminar = sc.nextLine();
				cancelarEvento(buscarEvento(eventoEliminar));
				break;
				
			case 5:
				System.out.println("Saliendo del menú...");
				salir = true;
				break;
				
			default:
				System.out.println("Opción inválida, teclee otra por favor");
			}
		}
		
		sc.close();
	}
	
	
	/**
	 * Función que permite mostrar los distintos detalles de cada evento
	 */
	public static void mostrarDetallesEvento() {
		System.out.println();
		System.out.println("--- Lista de eventos ---");
		for (int i = 0; i < numEventos; i ++) {
			if(eventosActivos[i]) {
				System.out.println("Nombre: " +  nombreEventos[i]);
				System.out.println("Fecha: " +  fechaEventos[i]);
				System.out.println("Duración: " +  duracionEventos[i] + " horas");
				System.out.println("Ubicación: " +  ubicacionEventos[i]);
				System.out.println("Categoría: " +  categoriaToString(categoriaEventos[i]));
				System.out.println("Organizador: " +  organizadorEventos[i]);
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
	}


	/**
	 * Función que permite encontrar un evento por su nombre
	 * @param nombre (nombre del evento que se quiere encontrar
	 * @return i/-1 (dependiendo de si ha sido encontrado o no)
	 */
	public static int buscarEvento(String nombre) {
		for (int i = 0; i < numEventos; i ++) {
			if(nombreEventos[i].equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		System.out.println("El evento no ha sido encontrado");
		return -1;
	}
}
