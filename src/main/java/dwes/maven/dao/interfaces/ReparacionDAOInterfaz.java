package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Reparaciones;

public interface ReparacionDAOInterfaz {

	void insert(Reparaciones r);
	void update(Reparaciones r);
	void delete(Reparaciones r);
	ArrayList<Reparaciones> findall();
	
}
