package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Favoritos;

public class FavoritosDAO {

	/**
	 * 
	 */
	private Connection conexion = null;

	/**
	 * 
	 */
	private static FavoritosDAO instance = null;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public FavoritosDAO() throws ClassNotFoundException, SQLException {

		conexion = ConnectionBD.getConnection();

	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static FavoritosDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new FavoritosDAO();
		}

		return instance;
	}

	/**
	 * 
	 * @param f
	 * @throws SQLException
	 */
	public void insertar(Favoritos f) throws SQLException {

		String insertar = "INSERT INTO favoritos (idfavoritos, usuario_id, restaurante_id) VALUES(?, ?)";

		PreparedStatement ps = conexion.prepareStatement(insertar);

		ps.setInt(2, f.getUsuario_id());
		ps.setInt(3, f.getRestaurante_id());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * 
	 * @param idusuario
	 * @throws SQLException
	 */
	public void eliminar(int idfavoritos) throws SQLException {

		String eliminar = "DELETE FROM favoritos WHERE idfavoritos = ?";

		PreparedStatement ps = conexion.prepareStatement(eliminar);

		ps.setInt(1, idfavoritos);

		ps.executeUpdate();

		ps.close();

	}

	/**
	 * 
	 * @param f
	 * @throws SQLException
	 */
	public void modificar(Favoritos f) throws SQLException { // que se tiene que modificar????

		String modificar = "UPDATE favoritos SET usuario_id=?, restaurante_id=? WHERE idfavoritos=?";

		PreparedStatement ps = conexion.prepareStatement(modificar);
		
		ps.setInt(2, f.getUsuario_id());
		ps.setInt(3, f.getRestaurante_id());
		ps.setInt(1, f.getIdfavoritos());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * 
	 * @param idrestaurante
	 * @return
	 * @throws SQLException
	 */
	public Favoritos consultar(int idfavoritos) throws SQLException {

		String consultar = "SELECT * FROM favoritos WHERE idfavoritos = ?";

		PreparedStatement ps = conexion.prepareStatement(consultar);
		ps.setInt(1, idfavoritos);

		ResultSet rs = ps.executeQuery();
		Favoritos f = null;

		if (rs.next()) { // Extraer datos del ResultSet y asignarlos al objeto
			f = new Favoritos();

			f.setIdfavoritos(rs.getInt("idfavoritos"));
			f.setUsuario_id(rs.getInt("usuario_id"));
			f.setRestaurante_id(rs.getInt("restaurante_id"));

		}

		ps.close();

		return f;

	}

}
