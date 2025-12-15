package dwes.maven.entidades;

public class Vehiculo {
	private int Id_vehiculo;
	private static int siguienteId = 1;
	private String matricula;
	private String marca;
	private String modelo;
	private int cliente_id;
	
	public Vehiculo(String matricula, String marca, String modelo, Cliente cliente) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.Id_vehiculo = siguienteId;
		siguienteId++;
		this.cliente_id= cliente.getId_cliente();	
	}

<<<<<<< HEAD
	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
=======
	public Vehiculo() {
		this.Id_vehiculo = siguienteId;
		siguienteId++;
	}

	public int getCliente_id() {
		return cliente_id;
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

<<<<<<< HEAD
	public String getMarca() {
		return marca;
	}

=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	public void setMarca(String marca) {
		this.marca = marca;
	}

<<<<<<< HEAD
	public String getModelo() {
		return modelo;
	}

=======
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

<<<<<<< HEAD
	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	
=======
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}


	public int getId_vehiculo() {
		return Id_vehiculo;
	}

	public void setId_vehiculo(int nuevoId) {
		this.Id_vehiculo = nuevoId;
		
	}

	public void setId_cliente(int nuevoId) {
		this.cliente_id = nuevoId;
		
	}

>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
}
