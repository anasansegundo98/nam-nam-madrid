package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {
	
	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static UsuarioDAO instance = null;
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		
		conexion = ConnectionBD.getConnection();	
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static UsuarioDAO getInstance() throws ClassNotFoundException, SQLException {
		
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void insertar(Usuario u) throws SQLException {
		
		String insertar = "INSERT INTO usuario (idusuario, nombre_usuario, email, contrasena, rol) VALUES(?, ?, ?, ?, ?)";
	
		PreparedStatement ps = conexion.prepareStatement(insertar);
		
		ps.setInt(1, u.getIdusuario());	
		ps.setString(2, u.getNombre_usuario());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getContrasena());
		ps.setString(5, u.getRol());
			
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * 
	 * @param idusuario
	 * @throws SQLException
	 */
	public void eliminar(int idusuario) throws SQLException {
		
		String eliminar = "DELETE FROM usuario WHERE idusuario = ?";
		
		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idusuario);
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void modificar(Usuario u) throws SQLException {
		
		String modificar = "UPDATE usuario SET nombre_usuario=?, email=?, contrasena=?, rol=? WHERE idusuario=?";

		
		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setString(1, u.getNombre_usuario());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getContrasena());
		ps.setString(4, u.getRol());
		ps.setInt(5, u.getIdusuario());	

		
		ps.executeUpdate();
		ps.close();
		
	}
	
	public Usuario consultar(int idusuario) throws SQLException {
		String consultar = "SELECT * FROM usuario WHERE idusuario = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idusuario);
		
		ResultSet rs = ps.executeQuery();
	    Usuario u = null; 
	    
	    if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			u = new Usuario();
	        u.setIdusuario(rs.getInt("idusuario"));
		    u.setNombre_usuario("idusuario");
		    u.setEmail(rs.getString("email"));
		    u.setContrasena(rs.getString("contrasena"));
		    u.setRol(rs.getString("rol"));
		
		}
		
		ps.close();
		
		return u;
	
	}
}
