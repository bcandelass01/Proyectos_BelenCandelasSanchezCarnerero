package proyecto_BelenCandelasSanchezCarnerero;

public class Organizador {
	// ATRIBUTOS
	private String nombre;
	private String contacto;
	private Evento[] eventosCreados;
	private int numEventos;
	
	
	// CONSTRUCTOR
	public Organizador(String nombre, String contacto) {
		this.nombre = nombre;
		this.contacto = contacto;
		this.eventosCreados = new Evento[50];					// Pongo un máximo de 50 eventos que pueda crear cada organizador
		this.numEventos = 0;
	}
	
	
	// GETTERS
	// Nombre
	public String getNombre() {
		return nombre;
	}
 
	// Contacto
	public String getContacto() {
		return contacto;
	}

	
	
	// METODOS
	/**
	 * Método que permite a un organizador crear un evento concreto
	 * @param nombreEvento (nombre del evento que se quiere crear)
	 * @param fecha (fecha en la que se realizará el evento)
	 * @param ubicacion (ubicación en la que se realizará el evento)
	 * @param categoria (categoría del evvento a crear)
	 * @return evento (evento ya creado con todas sus características)
	 */
	public Evento crearEvento(String nombreEvento, String fecha, int duracion, Ubicacion ubicacion, Categoria categoria) {
		// Comprobamos que no exista ningún evento con ese nombre
		for (int i = 0; i < numEventos; i ++) {
			if ((eventosCreados[i] != null) && (eventosCreados[i].getNombre().equalsIgnoreCase(nombreEvento))) {
				System.out.println("¡¡ERROR!! Ya existe un evento con el nombre : ' " + nombreEvento +" '");
				return null;
			}
		}
		Evento evento = new Evento(nombreEvento, fecha, duracion, ubicacion, categoria, this);
		eventosCreados[numEventos ++] = evento;
		System.out.println("Evento creado: " + nombreEvento);
		return evento;
	}
	
	
	/**
	 * Método que permite a un organizador cancelar un evento
	 * @param evento (nombre del evento a cancelar)
	 */
	public void cancelarEvento(Evento evento) {
		evento.cancelarEvento();
	}
}
