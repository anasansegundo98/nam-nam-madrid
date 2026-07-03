package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Restaurante;

public class RestauranteDAO {

	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static RestauranteDAO instance = null;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public RestauranteDAO() throws ClassNotFoundException, SQLException {

		conexion = ConnectionBD.getConnection();

	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static RestauranteDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new RestauranteDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 * @param r
	 * @throws SQLException
	 */
	public void insertar(Restaurante r) throws SQLException {
			
			String insertar = "INSERT INTO restaurantes (idrestaurante, nombre, zona_id, direccion, categoría_id, precio_medio, url_google_maps, descripcion, destacado, creado_por) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement ps = conexion.prepareStatement(insertar);
			
			ps.setInt(1, r.getIdrestaurante());	
			ps.setString(2, r.getNombre());
			ps.setInt(3, r.getZona_id());
			ps.setString(4, r.getDireccion());
			ps.setString(5, r.getCategoría_id());
			ps.setInt(6, r.getPrecio_medio());	
			ps.setString(7, r.getUrl_google_maps());
			ps.setString(8, r.getDescripcion());
			ps.setInt(9, r.getDestacado());
			ps.setInt(10, r.getCreado_por());
			
			ps.executeUpdate();
			ps.close();
			
		}
	
	/**
	 * 
	 * @param 
	 * @throws SQLException
	 */
	public void eliminar(int idrestaurante) throws SQLException {
		
		String eliminar = "DELETE FROM restaurantes WHERE idrestaurante = ?";
		
		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idrestaurante);
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * 
	 * @param r
	 * @throws SQLException
	 */
	public void modificar(Restaurante r) throws SQLException {
		
		String modificar = "UPDATE restaurantes SET nombre=?, zona_id=?, direccion=?, categoria_id=?, precio_medio=?, url_google_maps=?, descripcion=?, destacado=?, creado_por=? WHERE id=?";

		
		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setString(1, r.getNombre());
		ps.setInt(2, r.getZona_id());
		ps.setString(3, r.getDireccion());
		ps.setString(4, r.getCategoría_id());
		ps.setInt(5, r.getPrecio_medio());
		ps.setString(6, r.getUrl_google_maps());
		ps.setString(7, r.getDescripcion());
		ps.setInt(8, r.getDestacado());
		ps.setInt(9, r.getCreado_por());
					
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * 
	 * @param idrestaurante
	 * @return
	 * @throws SQLException
	 */
	public Restaurante consultar(int idrestaurante) throws SQLException {
		
		String consultar = "SELECT * FROM restaurantes WHERE idrestaurante = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idrestaurante);
		
		ResultSet rs = ps.executeQuery();
	    Restaurante r = null; 
	    
	    if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			r = new Restaurante();

			r.setIdrestaurante(rs.getInt("idrestaurante"));
			r.setNombre(rs.getString("nombre"));
			r.setZona_id(rs.getInt("zona_id"));
			r.setDireccion(rs.getString("direccion"));
			r.setCategoría_id(rs.getString("categoria_id"));
			r.setPrecio_medio(rs.getInt("precio_medio"));
			r.setUrl_google_maps(rs.getString("url_google_maps"));
			r.setDescripcion(rs.getString("descripcion"));
			r.setDestacado(rs.getInt("destacado"));
			r.setCreado_por(rs.getInt("creado_por"));
		
		}
		
		ps.close();
		
		return r;
	
	}
	
	
	
}
