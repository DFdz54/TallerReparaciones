package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Usuario;

public interface UsuarioDAOInterfaz  {

	void insert(Usuario u);
	void login(Usuario u, String dni, String password);
	ArrayList <Usuario> ListaUsuarios = new ArrayList<Usuario>();
	ArrayList<Usuario> findall();
	Usuario findByDni(String dni);
}
