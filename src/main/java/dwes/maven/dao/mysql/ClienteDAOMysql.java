package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.entidades.Cliente;

public class ClienteDAOMysql implements ClienteDAOInterfaz {

	private Connection conexion; 
	
	
	public ClienteDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void insert(Cliente c) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO cliente (idCliente, nombre, email, dni, telefono) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, c.getId_cliente()); // posicion 1, valor 1
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getDni());
			pst.setString(5, c.getTelefono());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void update(Cliente c) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT idCliente, nombre, email, dni FROM cliente WHERE email > ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, 15);
			resultado = pst.executeQuery();

			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String newemail = resultado.getString("email");
				resultado.updateString("email", newemail + "XxX");
				resultado.updateRow();
				System.out
						.println("> La email de la persona " + nombre + " se modificado a " + resultado.getString("email"));
			}

			conexion.commit();
			System.out.println("> Cambios confirmados correctamente");

		} catch (SQLException e) {
			if (conexion != null) {
				try {
					conexion.rollback();
					System.out.println("> Cambios confirmados correctamente");
				} catch (SQLException e1) {
					System.out.println("> NOK:" + e.getMessage());
				}

			}
		} finally {
			if (conexion != null) {
				try {
					conexion.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}


	@Override
	public void delete(String dni) {
		String sqlDelete = "DELETE FROM cliente WHERE idCliente = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, 1); // borrar id
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. Persona con id 1 eliminada correctamente.");
			} else {
				System.out.println("> NOK. Persona con id 1 no se encuentra en la base de datos.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Cliente> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}



}
