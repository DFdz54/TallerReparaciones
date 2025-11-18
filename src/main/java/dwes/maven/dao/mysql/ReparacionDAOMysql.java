package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.entidades.Reparaciones;

public class ReparacionDAOMysql implements ReparacionDAOInterfaz{

private Connection conexion; 
	
	
	public ReparacionDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void insert(Reparaciones r) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO reparacion (idReparacion, descripcion, fechaEntrada, costeEstimado, estado, vehiculoId, usuarioId) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, r.getId_reparacion()); // posicion 1, valor 1
			pst.setString(2, r.getDescripcion());
			pst.setDate(3, java.sql.Date.valueOf(r.getFechaEntrada()));
			pst.setDouble(4, r.getCosteEstimado());
			pst.setString(5, r.getEstado());
			pst.setInt(6, r.getVehiculoId());
			pst.setInt(7, r.getUsuarioId());

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	public void update(Reparaciones r) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT idReparacion, descripcion, estado FROM reparacion WHERE fechaEntrada > ?";
			PreparedStatement pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a
																									// cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar

			pst.setInt(1, 15);
			resultado = pst.executeQuery();

			while (resultado.next()) {
				String id = resultado.getString("idReparacion");
				resultado.updateString("estado", "Finalizada");
				resultado.updateRow();
				System.out
						.println("> La estado de la reparacion con id " + id + " se modificado a " + resultado.getString("estado"));
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
	public void delete(Reparaciones r) {
		String sqlDelete = "DELETE FROM reparacion WHERE id = ?;";
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
	public ArrayList<Reparaciones> findall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
