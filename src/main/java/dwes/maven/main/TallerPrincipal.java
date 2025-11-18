package dwes.maven.main;

import java.util.Scanner;

public class TallerPrincipal {
	
	
	public static void main(String[] args) {
		Scanner escaner = new Scanner (System.in);
	    int opcion;
	do {
		
		
		System.out.println("OPCION 1: Ver reparaciones finalizadas");
		System.out.println("OPCION 2: Login");
		System.out.println("OPCION 3: Salir");
		
		 opcion = escaner.nextInt();
         escaner.nextLine();
		
		switch (opcion) {
		case 1:
			
			break;

		case 2:
			
			break;
			
		case 3:
			
			break;
		
		}
		
	} while (opcion >= 4);	
	
		
	}
}


/*do {
	
	
	System.out.println("OPCION 1: Ver reparaciones finalizadas");
	System.out.println("OPCION 2: Login");
	System.out.println("OPCION 3: Salir");
	
	 opcion = escaner.nextInt();
     escaner.nextLine();
	
	switch (opcion) {
	case 1:
			verRepFinalizadas();
		break;

	case 2:
			loginUsuario();
		break;
		
	case 3:
		
		break;
	
	}
	
} while (opcion >= 4);	

	
}*/