package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.FotosComida;

public class FotosComidaDAO {

	
	private Connection conexion = null;
	
	
	private static FotosComidaDAO instance = null;
	
	
	public FotosComidaDAO() throws ClassNotFoundException, SQLException {
		conexion = ConnectionBD.getConnection();	
	}
	
	public static FotosComidaDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new FotosComidaDAO();
		}
		
		return instance;
	}
	
	
	
	public void insertar(FotosComida f) throws SQLException {
		
		String insertar = "INSERT INTO fotos_comida (idfotos_comida, restaurante_id, usuario_id, url_imagen, descripcion) VALUES(?, ?, ?, ?, ?)";
	
		PreparedStatement ps = conexion.prepareStatement(insertar);
		
		ps.setInt(1, f.getIdfotos_comida());	
		ps.setInt(2, f.getRestaurante_id());
		ps.setInt(3, f.getUsuario_id());
		ps.setString(4, f.getUrl_imagen());
		ps.setString(5, f.getDescripcion());
			
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	
	public void eliminar(int idfotos_comida) throws SQLException {
		
		String eliminar = "DELETE FROM fotos_comida WHERE idfotos_comida = ?";
		
		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idfotos_comida);
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	
	
	public void modificar(FotosComida f) throws SQLException {
		
		String modificar = "UPDATE fotos_comida SET restaurante_id=?, usuario_id=?, url_imagen=?, descripcion=? WHERE idfotos_comida=?";
		
		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setInt(1, f.getRestaurante_id());	
		ps.setInt(2, f.getUsuario_id());
		ps.setString(3, f.getUrl_imagen());
		ps.setString(4, f.getDescripcion());
		ps.setInt(5, f.getIdfotos_comida());	

		
		ps.executeUpdate();
		ps.close();
	}
	
	
	public FotosComida consultar(int idfotos_comida) throws SQLException {
		String consultar = "SELECT * FROM fotos_comida WHERE idfotos_comida = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idfotos_comida);
		
		ResultSet rs = ps.executeQuery();
	    FotosComida f = null; 
	    
	    if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			f = new FotosComida();
			 f.setIdfotos_comida(rs.getInt("idfotos_comida"));
		     f.setRestaurante_id(rs.getInt("restaurante_id"));
		     f.setUsuario_id(rs.getInt("usuario_id"));
		     f.setUrl_imagen(rs.getString("url_imagen"));
		     f.setDescripcion(rs.getString("descripcion"));
		
		}
		
		ps.close();
		
		return f;
	
	}
	
	
	
	
	
}
