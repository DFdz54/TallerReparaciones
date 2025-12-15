package dwes.maven.dao.interfaces;

import java.util.ArrayList;

<<<<<<< HEAD

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
=======
import dwes.maven.entidades.Cliente;

public interface ClienteDAOInterfaz {
    void insert(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    ArrayList<Cliente> findAll();
    Cliente findByDni(String dni);
}
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
