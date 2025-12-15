package dwes.maven.dao.interfaces;

import java.util.ArrayList;
<<<<<<< HEAD

import dwes.maven.entidades.Reparaciones;
import dwes.maven.entidades.Usuario;
=======
import java.util.List;
import java.util.OptionalDouble;

import dwes.maven.entidades.Reparaciones;
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7

public interface ReparacionDAOInterfaz {
	void insert(Reparaciones r);
	void delete(Reparaciones r);
	 ArrayList<Reparaciones> listaReparaciones = new ArrayList<Reparaciones>();
	List<Reparaciones> findByEstado(String string);
	void update(Reparaciones r);
	Reparaciones findById(int id);
	ArrayList<Reparaciones> findAll();
	 OptionalDouble costeMedio();

	void insert(Reparaciones r);
	void update(Reparaciones r);
	void delete(Reparaciones r);
	ArrayList <Reparaciones> ListaReparaciones = new ArrayList<Reparaciones>();
	ArrayList<Reparaciones> findall();
	
}
