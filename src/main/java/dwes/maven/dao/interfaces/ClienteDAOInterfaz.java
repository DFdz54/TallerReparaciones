package dwes.maven.dao.interfaces;

import java.util.ArrayList;


import dwes.maven.entidades.Cliente;

public interface ClienteDAOInterfaz {

	void insert(Cliente c);
	void update(Cliente c);
	void delete(String dni);
	ArrayList<Cliente> findall();
	Cliente findByDni(String dni);
}
