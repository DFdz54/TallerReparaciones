package dwes.maven.entidades;

import java.time.LocalDate;

public class Reparaciones {
	private int Id_reparacion;
	private static int siguienteId = 1;
	private String descripcion;
	private LocalDate fechaEntrada;
	private double costeEstimado;
	private String estado;
	private int IdVehiculo;
	private int usuario_id;
	private int mecanico_id;
	
<<<<<<< HEAD
	public Reparaciones(String descripcion, double costeEstimado, String estado, String matriculaVehiculo) {
		super();
=======

	private int IdCliente;
	
	public Reparaciones(String descripcion,double costeEstimado, String estado,Vehiculo vehiculo) {
		this.Id_reparacion = siguienteId;
		siguienteId++;
>>>>>>> 7a9bc0e017aeaa2955764d54a87567c8972090f7
		this.descripcion = descripcion;
		this.fechaEntrada = LocalDate.now();
		this.costeEstimado = costeEstimado;
		this.estado = estado;
		this.IdVehiculo = vehiculo.getId_vehiculo();
		
	}
	public Reparaciones() {
		this.Id_reparacion = siguienteId;
		siguienteId++;
	}

	public void setId_reparacion(int id_reparacion) {
		Id_reparacion = id_reparacion;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setIdVehiculo(int idVehiculo) {
		IdVehiculo = idVehiculo;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public int getIdVehiculo() {
		return IdVehiculo;
	}


	public int getIdCliente() {
		return IdCliente;
	}


	public int getId_reparacion() {
		return Id_reparacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public double getCosteEstimado() {
		return costeEstimado;
	}

	public void setCosteEstimado(double costeEstimado) {
		this.costeEstimado = costeEstimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setVehiculoId(int vehiculoId) {
		this.IdVehiculo = vehiculoId;
		
	}
	public void setMecanicoId(int mecanicoId) {
		this.mecanico_id = mecanicoId;
		
	}
	public int getMecanicoId() {
		
		return mecanico_id;
	}

	public int getId_reparacion() {
		return id_reparacion;
	}

	public void setId_reparacion(int id_reparacion) {
		this.id_reparacion = id_reparacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public double getCosteEstimado() {
		return costeEstimado;
	}

	public void setCosteEstimado(double costeEstimado) {
		this.costeEstimado = costeEstimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(int vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getMatriculaVehiculo() {
		return matriculaVehiculo;
	}

	public void setMatriculaVehiculo(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
	}
	
	
	
}
