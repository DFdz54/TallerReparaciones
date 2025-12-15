package dwes.maven.entidades;

public class Cliente {
	private int Id_cliente;
	private static int siguienteId = 1;
	private String nombre;
	private String email;
	private String DNI;
	private int telefono;

	public Cliente(String nombre, String email, String DNI,int telefono) {
		this.nombre = nombre;
		this.email = email;
		this.Id_cliente = siguienteId;
		this.DNI = DNI;
		this.telefono = telefono;
		siguienteId++;
	}
<<<<<<< HEAD
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
=======

	public Cliente() {
		this.Id_cliente = siguienteId;
		siguienteId++;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getId_cliente() {
		return Id_cliente;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDNI() {
		return DNI;
	}

	public void setId_cliente(int nuevoId) {
		this.Id_cliente = nuevoId;
		
	}

	public void setDni(String nuevoDNI) {
		this.DNI =  nuevoDNI;
		
	}

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
}
