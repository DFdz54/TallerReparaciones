package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.entidades.Vehiculo;

public class VehiculoDAOMysql implements VehiculoDAOInterfaz {

	private Connection conexion;

	public VehiculoDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void insert(Vehiculo v) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO vehiculo (idVehiculo, matricula, marca, modelo, cliente) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, v.getId_vehiculo()); // posicion 1, valor 1
			pst.setString(2, v.getMatricula());
			pst.setString(3, v.getMarca());
			pst.setString(4, v.getModelo());
			pst.setInt(5, v.getCliente_id());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
	public void update(Vehiculo v) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT idVehiculo, marca, modelo, cliente FROM vehiculo WHERE matricula > ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, 15);
			resultado = pst.executeQuery();

			while (resultado.next()) {
				String idv = resultado.getString("idVehiculo");
				String newmatr = resultado.getString("matricula");
				resultado.updateString("matricula", newmatr + "XxX");
				resultado.updateRow();
				System.out.println(
						"> La email de la persona " + idv + " se modificado a " + resultado.getString("matricula"));
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
	public void delete(String matricula) {
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
	public ArrayList<Vehiculo> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

}
