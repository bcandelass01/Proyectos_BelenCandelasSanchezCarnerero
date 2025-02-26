package proyecto_BelenCandelasSanchezCarnerero;

public class Ubicacion {
	// ATRIBUTOS
	private String descripcion;
	private boolean online;
	
	
	// CONSTRUCTOR
	public Ubicacion(String descripcion, boolean online) {
		this.descripcion = descripcion;
		this.online = online;
	}


	// GETTERS Y SETTERS
	// Descripcion
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Online
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
	
	// MÉTODOS	
	/**
	 * Método que te detalla si es online o presencial
	 * @return online/presencial (dependiendo de como sea el evento)
	 */
	public String detalles() {
		return online ? "Online - " + descripcion : "Presencial - " + descripcion;
	}
}
