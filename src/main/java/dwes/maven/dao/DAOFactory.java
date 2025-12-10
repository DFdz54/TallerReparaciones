package dwes.maven.dao;

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
	
}
