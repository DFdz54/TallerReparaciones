package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.entidades.Vehiculo;

public class VehiculoDAOMysql implements VehiculoDAOInterfaz {
<<<<<<< HEAD

=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	private Connection conexion;

	public VehiculoDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
<<<<<<< HEAD
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
=======
	public void insert(Vehiculo vehiculo) {
		try {
			String sql = "INSERT INTO vehiculo (id_vehiculo, matricula, marca, modelo, cliente_id) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, vehiculo.getId_vehiculo()); // posicion 1, valor 1
			pst.setString(2, vehiculo.getMatricula());
			pst.setString(3, vehiculo.getMarca());
			pst.setString(4, vehiculo.getModelo());
			pst.setInt(5, vehiculo.getCliente_id());

			boolean existe = false;
			for (Vehiculo v : listaVehiculos) {
				if (v.getId_vehiculo() == vehiculo.getId_vehiculo()) {
					existe = true;
					break;
				}
			}

			if (!existe) {
				listaVehiculos.add(vehiculo);
			}

			int resul = pst.executeUpdate();
			System.out.println("resultado:" + resul);
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
<<<<<<< HEAD
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
=======
	 public void update(Vehiculo v) {
        String sql = "UPDATE vehiculo SET matricula=?, marca=?, modelo=?, cliente_id=? WHERE id_vehiculo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1,v.getMatricula()); ps.setString(2,v.getMarca());
            ps.setString(3,v.getModelo()); ps.setInt(4,v.getCliente_id());
            ps.setInt(5,v.getId_vehiculo());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

	@Override
	public void delete(Vehiculo vehiculo) {
		String sqlDelete = "DELETE FROM vehiculo WHERE id_vehiculo = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, vehiculo.getId_vehiculo()); // borrar id
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. cliente con id" + vehiculo.getId_vehiculo() + " eliminada correctamente.");
				listaVehiculos.remove(vehiculo);
			} else {
				System.out.println(
						"> NOK. cliente con id" + vehiculo.getId_vehiculo() + " no se encuentra para la eliminacion.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	}

	@Override
	public ArrayList<Vehiculo> findall() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		return listaVehiculos;

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		for (int i = 0; i < listaVehiculos.size(); i++) {
			if (listaVehiculos.get(i).getMatricula().equals(matricula)) {
				return listaVehiculos.get(i);
			}
		}
		return null;

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	}

}
