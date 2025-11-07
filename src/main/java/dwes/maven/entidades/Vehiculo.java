package dwes.maven.entidades;

public class Vehiculo {

	

	private int id_vehiculo;
	private int sVehiculo = 1;
	private String matricula;
	private String marca;
	private String modelo;
	private int cliente_id;
	private String dniCliente;
	
	public Vehiculo(String matricula, String marca, String modelo, String dniCliente) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente_id = cliente_id;
		this.dniCliente = dniCliente; // buscarClienteporDni.getId();
		// Pedir el dni del cliente en el constructor para buscar su id emdiabte el dni (cambiar el dniCliente en un futuro)
		this.id_vehiculo = sVehiculo;
		sVehiculo++;
	}

	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

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
	
	
}
