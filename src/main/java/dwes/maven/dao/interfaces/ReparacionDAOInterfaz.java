package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Reparaciones;
import dwes.maven.entidades.Usuario;

public interface ReparacionDAOInterfaz {

	void insert(Reparaciones r);
	void update(Reparaciones r);
	void delete(Reparaciones r);
	ArrayList <Reparaciones> ListaReparaciones = new ArrayList<Reparaciones>();
	ArrayList<Reparaciones> findall();
	
}
