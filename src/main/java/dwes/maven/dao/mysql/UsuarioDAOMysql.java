package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.entidades.Usuario;

public class UsuarioDAOMysql implements UsuarioDAOInterfaz {

	private Connection conexion;

	public UsuarioDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void insert(Usuario u) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO persona (id, nombre, password, rol, dni) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, u.getId_usuario()); // posicion 1, valor 1
			pst.setString(2, u.getNombreUsuario());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getRol());
			pst.setString(5, u.getDni());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
	public void update(Usuario u) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id, nombre, password, rol FROM persona WHERE password > ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, 15);
			resultado = pst.executeQuery();

			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String nuevapass = resultado.getString("password");
				resultado.updateString("password", nuevapass + "xxx");
				resultado.updateRow();
				System.out
						.println("> La contraseña de " + nombre + " se modificado a " + resultado.getString("password"));
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
		String sqlDelete = "DELETE FROM Persona WHERE id = ?;";
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
	public ArrayList<Usuario> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;

	}
}
