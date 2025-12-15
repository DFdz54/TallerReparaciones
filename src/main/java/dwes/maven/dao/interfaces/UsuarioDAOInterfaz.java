package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Usuario;

<<<<<<< HEAD
public interface UsuarioDAOInterfaz  {

	void insert(Usuario u);
	void login(Usuario u, String dni, String password);
	ArrayList <Usuario> ListaUsuarios = new ArrayList<Usuario>();
	ArrayList<Usuario> findall();
	Usuario findByDni(String dni);
=======
public interface UsuarioDAOInterfaz {
	void login(String dni, String password);
	int insert(Usuario u);
	 ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	ArrayList<Usuario> findall();
	Usuario findByDNI(String dni);
	void login(Usuario u, String dni, String password);
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
}
