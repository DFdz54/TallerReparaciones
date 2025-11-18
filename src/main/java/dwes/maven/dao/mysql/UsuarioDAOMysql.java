package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.MysqlDAOFactory;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.entidades.Reparaciones;
import dwes.maven.entidades.Usuario;
import dwes.maven.mysql.PasswordUtils;

public class UsuarioDAOMysql implements UsuarioDAOInterfaz {

	Scanner escaner = new Scanner (System.in);
	Scanner escaner2 = new Scanner (System.in);
    int opcion1;
	String opcion2;
    
    
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

			pst.setString(6, PasswordUtils.hashPassword(u.getPassword()));

			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
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
	
	
	public void verReparacionesFinalizadas() {
		try {
			String sql = "SELECT idReparacion, descripcion, fechaEntrada, costeEstimado, estado, vehiculoId, usuarioId FROM reparacion WHERE estado = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, "Finalizada");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idReparacion");
				String desc = rs.getString("descripcion");
				java.sql.Date fechaEntrada = rs.getDate("fechaEntrada");
				double coste = rs.getDouble("costeEstimado");
				int vehiculoId = rs.getInt("vehiculoId");
				int usuarioId = rs.getInt("usuarioId");
				System.out.println("ID: " + id + " | Descripcion: " + desc + " | Fecha Entrada: " + fechaEntrada + " | Coste: " + coste + " | VehiculoId: " + vehiculoId + " | UsuarioId: " + usuarioId);
			}
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
	}

	@Override
	public void login(Usuario u, String dni, String password) {

		
		
		if (u.getDni().equals(dni) && PasswordUtils.verifyPassword(password, u.getPassword())
				&& u.getRol().equalsIgnoreCase("mecanico")) {
			
			System.out.println("OPCION 1 (MECANICO): Registrar Nueva Reparacion");
			System.out.println("OPCION 2 (MECANICO): Modificar Estado de la Reparacion");
			System.out.println("OPCION 3 (MECANICO): Consultar Reparaciones");
			System.out.println("OPCION 4 (MECANICO): Salir");
			
			opcion1 = escaner.nextInt();
		     escaner.nextLine();
			
			switch (opcion1) {
			case 1:
				
				
				
				MysqlDAOFactory df1 = new MysqlDAOFactory();
				System.out.println("INTRODUCE LA DESCRIPCION");
				String desc;
				desc = escaner2.nextLine();
				System.out.println("INTRODUCE EL COSTE");
				int cost;
				cost  = escaner2.nextInt();
				escaner2.nextLine();
				System.out.println("INTRODUCE EL ESTADO DE LA REPARACION");
				String est;
				est = escaner2.nextLine();
				System.out.println("INTRODUCE LA MATRICULA DEL VEHICULO");
				String matri;
				matri = escaner2.nextLine();
				
				Reparaciones r1 = new Reparaciones(desc, cost, est, matri);
				
				df1.getReparacionDAOInterfaz().insert(r1);
				break;
				
			case 2:
				
				MysqlDAOFactory df2 = new MysqlDAOFactory();
				
				break;
			
			case 3:
				
				MysqlDAOFactory df3 = new MysqlDAOFactory();
				
				df3.getReparacionDAOInterfaz().findall();
				break;
				
			case 4:
				
				break;
			}
			

		} else if (u.getDni().equals(dni) && PasswordUtils.verifyPassword(password, u.getPassword())
				&& u.getRol().equalsIgnoreCase("admin")) {

			
			
		} else {
			
			System.out.println("Usuario no valido, prueba otra vez");
			
		}

	}
}
