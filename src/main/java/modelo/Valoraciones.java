package modelo;

import java.time.LocalDate;

public class Valoraciones {
	
	// Atributos

	private int idvaloraciones;
	private int restaurante_id;
	private int usuario_id;
	private double rating;
	private int visitado;
	private LocalDate fecha_visita;
	private String notas_privadas;

	// Constructor

	public Valoraciones(int idvaloraciones, int restaurante_id, int usuario_id, double rating, int visitado,
			LocalDate fecha_visita, String notas_privadas) {
		super();
		this.idvaloraciones = idvaloraciones;
		this.restaurante_id = restaurante_id;
		this.usuario_id = usuario_id;
		this.rating = rating;
		this.visitado = visitado;
		this.fecha_visita = fecha_visita;
		this.notas_privadas = notas_privadas;
	}

	// Constructor vacío

	public Valoraciones() {
	}

	

	// Método que devuelve info de las valoraciones

	/**
	 * 
	 * @return atributos de la valoración
	 */
	public String informacion() {
		return "Valoración{" +
				"id=" + idvaloraciones +
				", restaurante=" + restaurante_id +
				", usuario=" + usuario_id +
				", rating=" + rating +
				", visitado=" + visitado +
				", fecha=" + fecha_visita +
				", notas='" + notas_privadas + '\'' +
				'}';
	}
	
	// Getters y setters

	public int getIdvaloraciones() {
		return idvaloraciones;
	}

	public void setIdvaloraciones(int idvaloraciones) {
		this.idvaloraciones = idvaloraciones;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getVisitado() {
		return visitado;
	}

	public void setVisitado(int visitado) {
		this.visitado = visitado;
	}

	public LocalDate getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(LocalDate fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

	public String getNotas_privadas() {
		return notas_privadas;
	}

	public void setNotas_privadas(String notas_privadas) {
		this.notas_privadas = notas_privadas;
	
	}
	
}
