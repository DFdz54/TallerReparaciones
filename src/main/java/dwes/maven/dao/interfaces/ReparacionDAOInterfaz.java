package dwes.maven.dao.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import dwes.maven.entidades.Reparaciones;

public interface ReparacionDAOInterfaz {
	void insert(Reparaciones r);
	void delete(Reparaciones r);
	 ArrayList<Reparaciones> listaReparaciones = new ArrayList<Reparaciones>();
	List<Reparaciones> findByEstado(String string);
	void update(Reparaciones r);
	Reparaciones findById(int id);
	ArrayList<Reparaciones> findAll();
	 OptionalDouble costeMedio();

}
