package modelo;

public class FotosComida {

	// Atributos
	private int idfotos_comida;
	private int restaurante_id;
	private int usuario_id;
	private String url_imagen;
	private String descripcion;

	// Constructor

	public FotosComida(int idfotos_comida, int restaurante_id, int usuario_id, String url_imagen, String descripcion) {
		this.idfotos_comida = idfotos_comida;
		this.restaurante_id = restaurante_id;
		this.usuario_id = usuario_id;
		this.url_imagen = url_imagen;
		this.descripcion = descripcion;
	}

	// Constructor vacío

	public FotosComida() {
	}

	// Método que devuelve info de las fotos

	public String toString() {
		return "FotosComida{" + "idfotos_comida=" + idfotos_comida + ", restaurante_id=" + restaurante_id
				+ ", usuario_id=" + usuario_id + ", url_imagen='" + url_imagen + '\'' + ", descripcion='" + descripcion
				+ '\'' + '}';
	}

	// Getters y setters

	public int getIdfotos_comida() {
		return idfotos_comida;
	}

	public void setIdfotos_comida(int idfotos_comida) {
		this.idfotos_comida = idfotos_comida;
	}

	public int getRestaurante_id() {
		return restaurante_id;
	}

	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
