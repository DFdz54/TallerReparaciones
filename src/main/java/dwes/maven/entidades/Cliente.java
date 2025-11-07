package dwes.maven.entidades;

public class Cliente {

	private int id_cliente;
	private int sId = 1;
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	public Cliente(String dni, String nombre, String telefono, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.id_cliente = sId;
		sId++;
	}
	
	
	
}
