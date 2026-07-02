package modelo;

public class Restaurante {
	
	
	// Atributos

		private int idrestaurante;
		private String nombre;
		private int  zona_id;
		private String direccion;
		private String categoría_id;
		private int precio_medio;
		private String url_google_maps;
		private String descripcion;
		private int destacado;
		private int creado_por;
		
		
		// Constructor
		
		public Restaurante(int idrestaurante, String nombre, int zona_id, String direccion, String categoria_id, int precio_medio,String url_google_maps, String descripcion,
		int destacado, int creado_por) {
			this.idrestaurante = idrestaurante;
			this.nombre = nombre;
			this.zona_id = zona_id;
			this.direccion = direccion;
			this.precio_medio = precio_medio;
			this.url_google_maps = url_google_maps;
			this.descripcion = descripcion;
			this.destacado = destacado;
			this.creado_por = creado_por;
		}
		
		
		// Constructor vacío
		
			public Restaurante() {}
			
		// Método que devuelve info de la persona
			
			/**
			 * 
			 * @return
			 */
			public String informacion() {
			    return "ID: " + idrestaurante +
			           ", Nombre: " + nombre +
			           ", Zona: " + zona_id +
			           ", Dirección: " + direccion +
			           ", Precio medio: " + precio_medio + " €" +
			           ", Google Maps: " + url_google_maps +
			           ", Descripción: " + descripcion +
			           ", Destacado: " + destacado +
			           ", Creado por: " + creado_por;
			}
			
			
			
		// Getters y setters

			
			public int getIdrestaurante() {
				return idrestaurante;
			}

			public void setIdrestaurante(int idrestaurante) {
				this.idrestaurante = idrestaurante;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public int getZona_id() {
				return zona_id;
			}

			public void setZona_id(int zona_id) {
				this.zona_id = zona_id;
			}

			public String getDireccion() {
				return direccion;
			}

			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			public String getCategoría_id() {
				return categoría_id;
			}

			public void setCategoría_id(String categoría_id) {
				this.categoría_id = categoría_id;
			}

			public int getPrecio_medio() {
				return precio_medio;
			}

			public void setPrecio_medio(int precio_medio) {
				this.precio_medio = precio_medio;
			}

			public String getUrl_google_maps() {
				return url_google_maps;
			}

			public void setUrl_google_maps(String url_google_maps) {
				this.url_google_maps = url_google_maps;
			}

			public String getDescripcion() {
				return descripcion;
			}

			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}

			public int getDestacado() {
				return destacado;
			}

			public void setDestacado(int destacado) {
				this.destacado = destacado;
			}

			public int getCreado_por() {
				return creado_por;
			}

			public void setCreado_por(int creado_por) {
				this.creado_por = creado_por;
			}

			
			

}
