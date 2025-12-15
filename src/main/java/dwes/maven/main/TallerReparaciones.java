package dwes.maven.main;

import dwes.maven.controlador.VistaTaller;
import dwes.maven.dbinit.DbInit;

public class TallerReparaciones {

	public static void main(String[] args) {
		
		 //Insercion de los datos iniciales
		 DbInit.init();
		 
		//Creacion de la vista junto con su inicializacion
		VistaTaller vista = new VistaTaller();
        vista.inicio();
	}
}
