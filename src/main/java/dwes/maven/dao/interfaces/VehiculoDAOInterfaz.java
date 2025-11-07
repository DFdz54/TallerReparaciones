package dwes.maven.dao.interfaces;

import java.util.ArrayList;

import dwes.maven.entidades.Vehiculo;

public interface VehiculoDAOInterfaz {

	void insert(Vehiculo v);
	void update(Vehiculo v);
	void delete(String matricula);
	ArrayList<Vehiculo> findall();
	Vehiculo findByMatricula(String matricula);
}