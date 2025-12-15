package dwes.maven.dao;

<<<<<<< HEAD
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;

public interface DAOFactory {

	public  ClienteDAOInterfaz getClienteDAOInterfaz();
	public  VehiculoDAOInterfaz getVehiculoDAOInterfaz();
	public  ReparacionDAOInterfaz getReparacionDAOInterfaz();
	public  UsuarioDAOInterfaz getUsuarioDAOInterfaz();

 //otro comentario random
=======
import java.sql.Connection;

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;

public interface DAOFactory {
	public  VehiculoDAOInterfaz getVehiculoDAOInterfaz();
	public ClienteDAOInterfaz getCLienteDAOInterfaz();
	public  UsuarioDAOInterfaz getUsuarioDAOInterfaz();
	public ReparacionDAOInterfaz getReparacionDAOInterfaz();
	  public static DAOFactory getDAOFactory() {
		  Connection c = DBConnection.getInstance().getConnection();
          return new MysqlDAOFactory(c);
	    }
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	
}
