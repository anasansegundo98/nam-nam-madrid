package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

	public static Connection instance = null;

	
	// Constructor vacío
	
	public ConnectionBD() {}
	
	
	// Patrón Singleton
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
	// PASO 1: Verificar si ya existe una conexión

		if (instance == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/namnam_madrid"; //  PASO 2: Preparar los datos de conexión -> jdbc:mysql://localhost:3306/  --> esa parte siempre es común, solo cambia el nombre de la DB
				String usuario = "root";
				String password = "";
				
				instance = DriverManager.getConnection(url, usuario, password); // PASO 3: CREAR LA CONEXIÓN
			}
			
			return instance; // PASO 4: Devolver la conexión
				
	}
	
	
	
	
}
