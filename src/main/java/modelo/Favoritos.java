package modelo;

public class Favoritos {

	// Atributos

	private int idfavoritos;
	private int usuario_id;
	private int restaurante_id;

	// Constructor

	public Favoritos(int idfavoritos, int usuario_id, int restaurante_id) {
		this.idfavoritos = idfavoritos;
		this.usuario_id = usuario_id;
		this.restaurante_id = restaurante_id;
		
	}

	// Constructor vacío

	public Favoritos() {
	}

	// Método que devuelve info de la persona

	/**
	 * 
	 * @return
	 */
	public String informacion() {
		return "ID valoración: " + idfavoritos + ", ID usuario: " + usuario_id + ", ID restaurante: " + restaurante_id;
	}

	

	// Getters y setters
	
	public int getIdfavoritos() {
		return idfavoritos;
	}

	public void setIdfavoritos(int idfavoritos) {
		this.idfavoritos = idfavoritos;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getRestaurante_id() {
		return restaurante_id;
	}

	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}
	
	

}
