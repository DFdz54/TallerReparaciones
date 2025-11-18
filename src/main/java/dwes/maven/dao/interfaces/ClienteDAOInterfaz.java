package dwes.maven.dao.interfaces;

import java.util.ArrayList;


import dwes.maven.entidades.Cliente;
import dwes.maven.entidades.Usuario;

public interface ClienteDAOInterfaz {

	void insert(Cliente c);
	void update(Cliente c);
	void delete(String dni);
	ArrayList <Cliente> ListaCliente = new ArrayList<Cliente>();
	ArrayList<Cliente> findall();
	Cliente findByDni(String dni);
}
