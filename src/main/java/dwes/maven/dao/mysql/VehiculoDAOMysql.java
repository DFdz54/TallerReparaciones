package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
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

	}

	@Override
	public ArrayList<Vehiculo> findall() {
		return listaVehiculos;

	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
		for (int i = 0; i < listaVehiculos.size(); i++) {
			if (listaVehiculos.get(i).getMatricula().equals(matricula)) {
				return listaVehiculos.get(i);
			}
		}
		return null;

	}

}
