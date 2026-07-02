package modelo;

public class CategoriasCocina {

	// Atributos

	private int idcategorias_cocina;
	private String nombre;

	// Constructor

	public CategoriasCocina(int idcategorias_cocina, String nombre) {
			this.idcategorias_cocina = idcategorias_cocina;
			this.nombre = nombre;
	}

		// Constructor vacío

	public CategoriasCocina() {}

	// Método que devuelve info de la persona

	/**
	 * 
	 * @return
	 */
	public String informacion() {
		return "ID: " + idcategorias_cocina + ", Nombre: " + nombre;
	}

	// Getters y setters

	public int getIdcategorias_cocina() {
		return idcategorias_cocina;
	}

	public void setIdcategorias_cocina(int idcategorias_cocina) {
		this.idcategorias_cocina = idcategorias_cocina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
