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
	
	
}
