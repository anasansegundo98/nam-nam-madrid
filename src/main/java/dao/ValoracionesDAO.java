package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Valoraciones;

public class ValoracionesDAO {

	
	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static ValoracionesDAO instance = null;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ValoracionesDAO() throws ClassNotFoundException, SQLException {

		conexion = ConnectionBD.getConnection();

	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ValoracionesDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new ValoracionesDAO();
		}
		
		return instance;
	}
	
	
	/**
	 * 
	 * @param v
	 * @throws SQLException
	 */
	public void insertar(Valoraciones v) throws SQLException {
			
			String insertar = "INSERT INTO valoraciones (idvaloraciones, restaurante_id, usuario_id, rating, visitado, fecha_visita, notas_privadas) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement ps = conexion.prepareStatement(insertar);
			
			ps.setInt(1, v.getRestaurante_id());
			ps.setInt(2, v.getUsuario_id());
			ps.setDouble(3, v.getRating());
			ps.setInt(4, v.getVisitado());
			ps.setDate(5, java.sql.Date.valueOf(v.getFecha_visita()));
			ps.setString(6, v.getNotas_privadas());
			
			ps.executeUpdate();
			ps.close();
			
		}
	
	/**
	 * 
	 * @param idusuario
	 * @throws SQLException
	 */
	public void eliminar(int idvaloraciones) throws SQLException {
		
		String eliminar = "DELETE FROM valoraciones WHERE idvaloraciones = ?";
		
		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idvaloraciones);
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * 
	 * @param r
	 * @throws SQLException
	 */
	public void modificar(Valoraciones v) throws SQLException {
		
		String modificar = "UPDATE valoraciones SET nombre=?, zona_id=?, direccion=?, categoria_id=?, precio_medio=?, url_google_maps=?, descripcion=?, destacado=?, creado_por=? WHERE idvaloraciones=?";

		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setInt(1, v.getRestaurante_id());
		ps.setInt(2, v.getUsuario_id());
		ps.setDouble(3, v.getRating());
		ps.setInt(4, v.getVisitado());
		ps.setDate(5, java.sql.Date.valueOf(v.getFecha_visita()));
		ps.setString(6, v.getNotas_privadas());
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * 
	 * @param idrestaurante
	 * @return
	 * @throws SQLException
	 */
	public Valoraciones consultar(int idvaloraciones) throws SQLException {
		
		String consultar = "SELECT * FROM valoraciones WHERE idvaloraciones = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idvaloraciones);
		
		ResultSet rs = ps.executeQuery();
	    Valoraciones v = null; 
	    
	    if (rs.next()) {
	    	v = new Valoraciones();
	    	
	    	v.setIdvaloraciones(rs.getInt("idvaloraciones"));
	    	v.setRestaurante_id(rs.getInt("restaurante_id"));
	    	v.setUsuario_id(rs.getInt("usuario_id"));
	    	v.setRating(rs.getDouble("rating"));
	    	v.setVisitado(rs.getInt("visitado"));
	    	v.setFecha_visita(rs.getDate("fecha_visita").toLocalDate());
	    	v.setNotas_privadas(rs.getString("notas_privadas"));
	    }
		
		ps.close();
		
		return v;
	
	}
}
