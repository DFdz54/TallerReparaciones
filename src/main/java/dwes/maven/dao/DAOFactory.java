package dwes.maven.dao;

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;

public interface DAOFactory {

	public static ClienteDAOInterfaz getClienteDAOInterfaz() {

		return null;
	}

	public static VehiculoDAOInterfaz getVehiculoDAOInterfaz() {

		return null;
	}

	public static ReparacionDAOInterfaz getReparacionDAOInterfaz() {

		return null;
	}

	public static UsuarioDAOInterfaz getUsuarioDAOInterfaz() {

		return null;
	}

	
	
}
