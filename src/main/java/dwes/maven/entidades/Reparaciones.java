package dwes.maven.entidades;

import java.time.LocalDate;

public class Reparaciones {

	private int id_reparacion;
	private int sReparacion = 1;
	private String descripcion;
	private LocalDate fechaEntrada;
	private double costeEstimado;
	private String estado;
	private int vehiculoId;
	private int usuarioId;
	private String matriculaVehiculo;
	
	public Reparaciones(String descripcion, LocalDate fechaEntrada, double costeEstimado, String estado, String matriculaVehiculo) {
		super();
		this.descripcion = descripcion;
		this.fechaEntrada = fechaEntrada;
		this.costeEstimado = costeEstimado;
		this.estado = estado;
		this.matriculaVehiculo = matriculaVehiculo;
		this.id_reparacion = sReparacion;
		sReparacion++;
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
