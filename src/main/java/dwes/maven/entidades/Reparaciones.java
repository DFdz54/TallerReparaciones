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
	
	
}
