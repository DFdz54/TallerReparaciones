package dwes.maven.dao;

import java.sql.Connection;
<<<<<<< HEAD

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.dao.mysql.ClienteDAOMysql;
import dwes.maven.dao.mysql.ReparacionDAOMysql;
import dwes.maven.dao.mysql.UsuarioDAOMysql;
import dwes.maven.dao.mysql.VehiculoDAOMysql;

public class MysqlDAOFactory implements DAOFactory {
	
	
	private Connection conexion;
	public MysqlDAOFactory(Connection conexion) {
		this.conexion =  conexion;
	}
	

	@Override
	public ClienteDAOInterfaz getClienteDAOInterfaz() {			

		return new ClienteDAOMysql();
	}

	@Override	
	public VehiculoDAOInterfaz getVehiculoDAOInterfaz() {

		return new VehiculoDAOMysql();
	}

	@Override		
	public ReparacionDAOInterfaz getReparacionDAOInterfaz() {

		return new ReparacionDAOMysql();
	}

	@Override		
	public UsuarioDAOInterfaz getUsuarioDAOInterfaz() {

		return new UsuarioDAOMysql();
	}
=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7

import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.dao.mysql.ClienteDAOMysql;
import dwes.maven.dao.mysql.ReparacionDAOMysql;
import dwes.maven.dao.mysql.UsuarioDAOMysql;
import dwes.maven.dao.mysql.VehiculoDAOMysql;

public class MysqlDAOFactory implements DAOFactory{
	
	private Connection conexion;
	public MysqlDAOFactory(Connection conexion) {
		this.conexion = conexion;
	}

	public ClienteDAOInterfaz getCLienteDAOInterfaz() {
		return new ClienteDAOMysql();
	}
	
	public VehiculoDAOInterfaz getVehiculoDAOInterfaz() {
		return new VehiculoDAOMysql();
	}
	
	public UsuarioDAOInterfaz getUsuarioDAOInterfaz() {
		return new UsuarioDAOMysql();
	}
	
	public ReparacionDAOInterfaz getReparacionDAOInterfaz() {
		return new ReparacionDAOMysql();
	}
}
