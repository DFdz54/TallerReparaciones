package dwes.maven.dao.mysql;

import dwes.maven.dao.interfaces.ArrayList;
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.cliente;

public class ClienteDAOMysql implements ClienteDAOInterfaz {

	@Override
	public int insert(cliente c) {
		return 0;
	}

	@Override
	public int update(cliente c) {
		return 0;
	}

	@Override
	public int delete(String dni) {
		return 0;
	}

	@Override
	public ArrayList<cliente> findall() {
		return null;
	}

	@Override
	public cliente findByDni(String dni) {
		return null;
	}


}
