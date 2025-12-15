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
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.entidades.Cliente;

public class ClienteDAOMysql implements ClienteDAOInterfaz {

<<<<<<< HEAD
	private Connection conexion; 
	
	
=======
	private Connection conexion;

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	public ClienteDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
<<<<<<< HEAD
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
		
=======
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

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	}

	@Override
	public void update(Cliente c) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
		return null;

	}
<<<<<<< HEAD

	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}



=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
}
