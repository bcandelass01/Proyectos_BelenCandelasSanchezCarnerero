package proyecto_BelenCandelasSanchezCarnerero;

public class Evento {
	// ATRIBUTOS
	private String nombre;
	private String fecha;
	private int duracion;						// Duracion del evento en horas
	private Ubicacion ubicacion;
	private Categoria categoria;
	private boolean activo;
	private Usuario[] inscritos;
	private int numInscritos;
	private Organizador organizador;
	
	
	// CONSTRUCTOR
	public Evento(String nombre, String fecha, int duracion, Ubicacion ubicacion, Categoria categoria, Organizador organizador) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
		this.categoria = categoria;
		this.organizador = organizador;
		this.activo = true;
		this.inscritos = new Usuario[100];			// Pongo un máximo de 100 personas para inscribirse
		this.numInscritos = 0;
	}

	
	// GETTER NOMBRE
	public String getNombre() {
		return nombre;
	}

	
	// METODOS
	/**
	 * Método para registrar un usuario a un evento
	 * @param nombreUsuario (nombre del usuario a registrar)
	 */
	public void registrarUsuario(Usuario usuario) {
		if(activo && (numInscritos < inscritos.length)) {
			inscritos[numInscritos ++] = usuario;
			System.out.println(usuario.getNombre() + " se ha inscrito al evento: " + nombre);
		} else {
			System.out.println("No se puede inscribir, el evento está lleno o se ha cancelado");
		}
	}
	
	
	/**
	 * Método para cancelar la inscriptción de un usuario en un evento
	 * @param nombreUsuario (nombre del usuario a cancelar la inscripción)
	 */
	public void cancelarInscripcion(Usuario usuario) {
		for (int i = 0; i < numInscritos; i ++) {
			if(inscritos[i].equals(usuario)) {				
				inscritos[i] = inscritos[-- numInscritos];
				System.out.println(usuario.getNombre() + " ha cancelado su incripción en el evento: " + nombre);
				return;
			}
		}
		System.out.println(usuario.getNombre() + " no está inscrito en el evento: " + nombre);
	}
	
	
	/**
	 * Método que cancela un evento
	 */
	public void cancelarEvento() {
		this.activo = false;
		System.out.println("El evento " + nombre + " ha sido cancelado.");
	}
	
	
	/**
	 * Método que muestra todos los detalles de un evento
	 */
	public void mostrarDetalles() {
		System.out.println("--- Detalles del evento ---");
		System.out.println("Nombre: " + nombre);
		System.out.println("Fecha: " + fecha);
		System.out.println("Duración: " + duracion + " horas");
		System.out.println("Ubicación: " + ubicacion.getDescripcion());
		System.out.println("Categoría: " + categoria);
		System.out.println("Organizador: " + organizador.getNombre());
		System.out.println("Estado: " + (activo ? "Activo" : "Cancelado"));
	}
}
