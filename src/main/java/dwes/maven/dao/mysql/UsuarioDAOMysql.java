package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.entidades.Usuario;
import dwes.maven.utilities.PasswordUtils;

public class UsuarioDAOMysql implements UsuarioDAOInterfaz {
	private Connection conexion;

	public UsuarioDAOMysql() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public void login(Usuario u,String DNI, String password) {
		
		if(u.getDNI().equals(DNI) && PasswordUtils.verifyPassword(u.getPassword(), password)){
			
			
			
			
		} else {
			System.out.println("Usuario o contraseña inválidos");
		}
		
	}

	@Override
	public int insert(Usuario u) {
		int resul = 0;
		try {

			String sql = "INSERT INTO usuario (id_usuario, nombre, dni, password, rol) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);

			pst.setInt(1, u.getIdUsuario());
			pst.setString(2, u.getNombreUsuario());
			pst.setString(3, u.getDNI());
			pst.setString(4, PasswordUtils.hashPassword(u.getPassword()));
			pst.setString(5, u.getRol());

			resul = pst.executeUpdate();
			System.out.println("Resultado: " + resul);
			boolean existe = false;
			for (Usuario usu : listaUsuarios) {
				if (usu.getIdUsuario() == u.getIdUsuario()) {
					existe = true;
					break;
				}
			}

			if (!existe) {
				listaUsuarios.add(u);
			}
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
			resul = -1;
		} catch (Exception e) {
			System.out.println("> Error: " + e.getMessage());
			resul = -2;
		}
		return resul;
	}

	@Override
	public ArrayList<Usuario> findall() {
		return listaUsuarios;
	}

	@Override
	public Usuario findByDNI(String dni) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getDNI().equals(dni)) {
				return listaUsuarios.get(i);
			}
		}
		return null;
	}

	@Override
	public void login(String dni, String password) {

	}
}
