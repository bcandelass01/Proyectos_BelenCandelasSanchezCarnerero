package proyecto_BelenCandelasSanchezCarnerero;

public class Usuario {
	// ATRIBUTOS
	private String nombre;
	private String correo;
	private String contrasenia;
	private Evento[] eventosInscritos;
	private int numEventos;
	
	
	// CONSTRUCTOR
	public Usuario(String nombre, String correo, String contrasenia) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.eventosInscritos = new Evento[50];					// Pongo un máximo de inscripción a 50 eventos
		this.numEventos = 0;
	}


	// GETTERS
	// Nombre
	public String getNombre() {
		return nombre;
	}
	
	// Correo
	public String getCorreo() {
		return correo;
	}
	
	// Contrasenia
	public String getContrasenia() {
		return contrasenia;
	}
	
	
	// METODOS
	/**
	 * Método que inscribe al usuario en un evento
	 * @param evento (evento al que se quiere inscribir el usuario)
	 */
	public void inscribirse(Evento evento) {
		if (evento != null) {
			evento.registrarUsuario(this);
			if (numEventos < eventosInscritos.length) {
				eventosInscritos[numEventos ++] = evento;
			}
		}
	}
	
	
	/**
	 * Método para cancelar la inscripción de un usario en un evento
	 * @param evento (evento del cual se quiere cancelar la inscripción)
	 */
	public void cancelarInscripcion(Evento evento) {
		for (int i = 0; i < numEventos; i ++) {
			if(eventosInscritos[i].equals(evento)) {
				evento.cancelarInscripcion(this);
				eventosInscritos[i] = eventosInscritos[-- numEventos];
				return;
			}
		}
		System.out.println("No estás inscrito en el evento: " + evento.getNombre());
	}
	
	/**
	 * Método que muestra a cuantos eventos está inscrito
	 * un usuario en concreto
	 */
	public void mostrarInscripciones() {
		System.out.println("--- Eventos a los que está inscrito " + nombre + " ---");
		for (int i = 0; i < numEventos; i ++) {
			System.out.println("- " +  eventosInscritos[i].getNombre());
		}
	}
}
