package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public void insert(Cliente cliente) {
		try {
			String sql = "INSERT INTO cliente (id_cliente, nombre, email, dni, telefono) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, cliente.getId_cliente());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getDNI());
			pst.setInt(5, cliente.getTelefono());
			
			boolean existe= false;
			
			for (Cliente cli : listaClientes) {
			    if (cli.getId_cliente() == cliente.getId_cliente()) {
			        existe = true;
			        break;
			    }
			}

			if (!existe) {
			    listaClientes.add(cliente);
			}


			int resul = pst.executeUpdate();
			System.out.println("resultado:" + resul);
			listaClientes.add(cliente);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}

	}

	@Override
	public void update(Cliente c) {
        String sql = "UPDATE cliente SET dni=?, nombre=?, telefono=?, email=? WHERE id_cliente=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1,c.getDNI()); ps.setString(2,c.getNombre());
            ps.setInt(3,c.getTelefono()); ps.setString(4,c.getEmail());
            ps.setInt(5,c.getId_cliente());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

	@Override
	public void delete(Cliente cliente) {
		String sqlDelete = "DELETE FROM cliente WHERE id_cliente = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, cliente.getId_cliente()); //borrar id 
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. cliente con id " + cliente.getId_cliente() +  " eliminado correctamente.");
				listaClientes.remove(cliente);
			} else {
				System.out.println("> NOK. cliente con id " + cliente.getId_cliente() +  "no se encuentra para la eliminacion.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Cliente> findAll() {
		return listaClientes;
	}

	@Override
	public Cliente findByDni(String dni) {

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getDNI().equals(dni)) {
				return listaClientes.get(i);
			}
		}
		return null;

	}
}
