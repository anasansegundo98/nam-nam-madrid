package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.ZonasMadrid;

public class ZonasMadridDAO {
	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static ZonasMadridDAO instance = null;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ZonasMadridDAO() throws ClassNotFoundException, SQLException {

		conexion = ConnectionBD.getConnection();

	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ZonasMadridDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new ZonasMadridDAO();
		}

		return instance;
	}

	/**
	 * 
	 * @param z
	 * @throws SQLException
	 */
	public void insertar(ZonasMadrid z) throws SQLException {

		String insertar = "INSERT INTO zonas_madrid (idzonas_madrid, nombre) VALUES(?, ?)";

		PreparedStatement ps = conexion.prepareStatement(insertar);

		ps.setInt(1, z.getIdzonas_madrid());
		ps.setString(2, z.getNombre());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * 
	 * @param idusuario
	 * @throws SQLException
	 */
	public void eliminar(int idzonas_madrid) throws SQLException {

		String eliminar = "DELETE FROM zonas_madrid WHERE idzonas_madrid = ?";

		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idzonas_madrid);

		ps.executeUpdate();

		ps.close();

	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	public void modificar(ZonasMadrid z) throws SQLException {

		String modificar = "UPDATE zonas_madrid SET nombre=? WHERE idzonas_madrid=?";

		PreparedStatement ps = conexion.prepareStatement(modificar);

		ps.setString(1, z.getNombre());

		ps.setInt(2, z.getIdzonas_madrid());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * 
	 * @param idcategorias_cocina
	 * @return
	 * @throws SQLException
	 */
	public ZonasMadrid consultar(int idzonas_madrid) throws SQLException {

		String consultar = "SELECT * FROM zonas_madrid WHERE idzonas_madrid = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idzonas_madrid);

		ResultSet rs = ps.executeQuery();
		ZonasMadrid z = null;

		if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			z = new ZonasMadrid();
			z.setIdzonas_madrid(rs.getInt("idzonas_madrid"));
			z.setNombre(rs.getString("nombre"));
		}

		ps.close();
		return z;

	}

}
