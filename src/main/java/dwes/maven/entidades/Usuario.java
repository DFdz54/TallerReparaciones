package dwes.maven.entidades;

public class Usuario {

	
	private int id_usuario;
	private int sUsuario = 1;
	private String dni;
	private String nombreUsuario;
	private String password;
	private String rol;
	public Usuario(String dni, String nombreUsuario, String password, String rol) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
		this.id_usuario = sUsuario;
		sUsuario++;
	}
	
	
}
