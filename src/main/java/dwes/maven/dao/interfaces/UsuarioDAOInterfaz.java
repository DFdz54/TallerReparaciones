package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Usuario;

public interface UsuarioDAOInterfaz {

	void insert(Usuario u);
	void update(Usuario u);
	void delete(String dni);
	ArrayList<Usuario> findall();
	Usuario findByDni(String dni);
}
