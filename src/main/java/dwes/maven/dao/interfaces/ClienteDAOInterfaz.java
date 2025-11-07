package dwes.maven.dao.interfaces;

import dwes.maven.dao.mysql.ArrayList;
import dwes.maven.dao.mysql.cliente;

public interface ClienteDAOInterfaz {

	int insert(cliente c);
	int update(cliente c);
	int delete(String dni);
	ArrayList<cliente> findall();
	cliente findByDni(String dni);
}
