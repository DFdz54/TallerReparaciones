package dwes.maven.dao.interfaces;

import java.util.ArrayList;
<<<<<<< HEAD

import dwes.maven.entidades.Usuario;
import dwes.maven.entidades.Vehiculo;

public interface VehiculoDAOInterfaz {

	void insert(Vehiculo v);
	void update(Vehiculo v);
	void delete(String matricula);
	ArrayList <Vehiculo> ListaVehiculos = new ArrayList<Vehiculo>();
	ArrayList<Vehiculo> findall();
	Vehiculo findByMatricula(String matricula);
}
=======

import dwes.maven.entidades.Vehiculo;

public interface VehiculoDAOInterfaz {
	void insert(Vehiculo vehiculo);
	void update(Vehiculo vehiculo);
	void delete(Vehiculo vehiculo);
	 ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	ArrayList<Vehiculo> findall();
	Vehiculo findByMatricula(String matricula);
}
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
