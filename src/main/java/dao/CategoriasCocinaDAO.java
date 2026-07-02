package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.CategoriasCocina;

public class CategoriasCocinaDAO {


	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static CategoriasCocinaDAO instance = null;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public CategoriasCocinaDAO() throws ClassNotFoundException, SQLException {

		conexion = ConnectionBD.getConnection();

	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static CategoriasCocinaDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new CategoriasCocinaDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	public void insertar(CategoriasCocina c) throws SQLException {
			
			String insertar = "INSERT INTO categorias_cocina (idcategorias_cocina, nombre) VALUES(?, ?)";
		
			PreparedStatement ps = conexion.prepareStatement(insertar);
			
			ps.setInt(1, c.getIdcategorias_cocina());	
			ps.setString(2, c.getNombre());
			
			
			ps.executeUpdate();
			ps.close();
			
		}
	
	/**
	 * 
	 * @param idusuario
	 * @throws SQLException
	 */
	public void eliminar(int idcategorias_cocina) throws SQLException {
		
		String eliminar = "DELETE FROM categorias_cocina WHERE idcategorias_cocina = ?";
		
		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idcategorias_cocina);
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	public void modificar(CategoriasCocina c) throws SQLException {
		
		String modificar = "UPDATE categorias_cocina SET nombre=? WHERE idcategorias_cocina=?";
		
		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setInt(1, c.getIdcategorias_cocina());
		ps.setString(2, c.getNombre());
		
					
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * 
	 * @param idcategorias_cocina
	 * @return
	 * @throws SQLException
	 */
	public CategoriasCocina consultar(int idcategorias_cocina) throws SQLException {
		
		String consultar = "SELECT * FROM categorias_cocina WHERE idcategorias_cocina = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idcategorias_cocina);
		
		ResultSet rs = ps.executeQuery();
	    CategoriasCocina c = null; 
	    
	    if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			c = new CategoriasCocina();

			c.setIdcategorias_cocina(rs.getInt("idcategorias_cocina"));
			c.setNombre(rs.getString("nombre"));
			
		
		}
		
		ps.close();
		
		return c;
	
	}
	
	
}
