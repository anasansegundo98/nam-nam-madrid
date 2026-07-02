package modelo;

public class ZonasMadrid {

	// Atributos

	private int idzonas_madrid;
	private String nombre;

	// Constructor

	public ZonasMadrid(int idzonas_madrid, String nombre) {
		super();
		this.idzonas_madrid = idzonas_madrid;
		this.nombre = nombre;
	}

	// Constructor vacío

	public ZonasMadrid() {
	}

	// Método que devuelve info de la persona

	/**
	 * 
	 * @return
	 */


	// Getters y setters

	public String informacion() {
		return "ID: " + idzonas_madrid + ", Nombre: " + nombre;
	}

	public int getIdzonas_madrid() {
		return idzonas_madrid;
	}

	public void setIdzonas_madrid(int idzonas_madrid) {
		this.idzonas_madrid = idzonas_madrid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
