package dwes.maven.entidades;

public class Usuario {
	private int IdUsuario;
	private static int siguienteId = 1;
	private String DNI;
	private String nombreUsuario;
	private String password;
	private String rol;
<<<<<<< HEAD
	public Usuario(String dni, String nombreUsuario, String password, String rol) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
		this.id_usuario = sUsuario;
		sUsuario++;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	
		public Usuario(String DNI,String nombreUsuario, String password, String rol) {
			this.IdUsuario = siguienteId;
			siguienteId++;
			this.DNI = DNI;
			this.nombreUsuario = nombreUsuario;
			this.password = password;
			this.rol = rol;
		}

		public Usuario() {
			this.IdUsuario = siguienteId;
			siguienteId++;
		}

		public void setDNI(String dNI) {
			DNI = dNI;
		}

		public String getDNI() {
			return DNI;
		}

		public int getIdUsuario() {
			return IdUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			IdUsuario = idUsuario;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		
}
