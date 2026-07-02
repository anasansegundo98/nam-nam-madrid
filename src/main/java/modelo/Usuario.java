package modelo;

public class Usuario {

	// Atributos

	private int idusuario;
	private String nombre_usuario;
	private String email;
	private String contrasena;
	private String rol;
	
	
	// Constructor
	
	public Usuario(int idusuario, String nombre_usuario, String email, String contrasena, String rol) {
		this.idusuario = idusuario;
		this.nombre_usuario = nombre_usuario;
		this.email = email;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	// Constructor vacío
	
		public Usuario() {}
		
	// Método que devuelve info de la persona
		
		public String informacion() {
			return "Su nombre es "+ nombre_usuario + ", idusuario " + idusuario + ", email: " + email + "rol" + rol + "contraseña: " + contrasena;
		}

	// Getters y setters

	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}


	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}

