package dwes.maven.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;


public class DBConnection {
	private static DBConnection Instance;
	Connection conexionMySQL = null;

	private  DBConnection() {
		try {

			MysqlDataSource dataSource = new MysqlDataSource();
			
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("src\\main\\resources\\conexion.properties");
			props.load(file);

			dataSource.setUrl(props.getProperty("url"));
			dataSource.setUser(props.getProperty("user"));
			dataSource.setPassword(props.getProperty("password"));
			file.close();

			conexionMySQL = dataSource.getConnection();
			System.out.println("> Conexión establecida correctamente");
		} catch (SQLException | IOException e) {
			System.err.println("> Error al conectar con mysql: " + e.getMessage());
		}
	}
	public static DBConnection getInstance() {
		if(Instance == null) {
			Instance = new DBConnection();
		}
		return Instance;
	}
	public Connection getConnection() {
		return Instance.conexionMySQL;
	}
}
