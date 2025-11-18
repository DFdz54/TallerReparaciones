package dwes.maven.dao;

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;

public interface DAOFactory {

	public  ClienteDAOInterfaz getClienteDAOInterfaz();
	public  VehiculoDAOInterfaz getVehiculoDAOInterfaz();
	public  ReparacionDAOInterfaz getReparacionDAOInterfaz();
	public  UsuarioDAOInterfaz getUsuarioDAOInterfaz();

	
	
}
