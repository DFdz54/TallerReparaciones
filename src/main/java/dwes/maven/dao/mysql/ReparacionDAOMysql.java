package dwes.maven.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import dwes.maven.dao.DBConnection;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.entidades.Reparaciones;

public class ReparacionDAOMysql implements ReparacionDAOInterfaz {
	
	private Connection conexion;
	
	public ReparacionDAOMysql () {
		conexion = DBConnection.getInstance().getConnection();
	}
	

	@Override
	public void insert(Reparaciones r) {
		try {

			String sql = "INSERT INTO reparacion (id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id, mecanico_id) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, r.getId_reparacion()); // posicion 1, valor 1
			pst.setString(2, r.getDescripcion());
			pst.setDate(3, java.sql.Date.valueOf(r.getFechaEntrada()));
			pst.setDouble(4, r.getCosteEstimado());
			pst.setString(5, r.getEstado());
			pst.setInt(6,r.getIdVehiculo());
			pst.setInt(7, r.getMecanicoId());
			boolean existe = false;

			for (Reparaciones rep : listaReparaciones) {
			    if (rep.getId_reparacion() == r.getId_reparacion()) {
			        existe = true;
			        break;
			    }
			}

			if (!existe) {
			    listaReparaciones.add(r);
			}

			int resul = pst.executeUpdate();
			System.out.println("resultado:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		
	}

	@Override
	 public void update(Reparaciones r) {
	        String sql = "UPDATE reparacion SET vehiculo_id=?, descripcion=?, fecha_entrada=?, coste_estimado=?, estado=?, mecanico_id=? WHERE id_reparacion=?";
	        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
	            ps.setInt(1, r.getIdVehiculo());
	            ps.setString(2, r.getDescripcion());
	            ps.setDate(3, Date.valueOf(r.getFechaEntrada()));
	            ps.setDouble(4, r.getCosteEstimado());
	            ps.setString(5, r.getEstado());
	            if (r.getMecanicoId() == 0) ps.setNull(6, Types.INTEGER); else ps.setInt(6, r.getMecanicoId());
	            ps.setInt(7, r.getId_reparacion());
	            ps.executeUpdate();
	        } catch (SQLException e) { e.printStackTrace(); }
	    }

	@Override
	public void delete(Reparaciones r) {
		String sqlDelete = "DELETE FROM reparacion WHERE id_reparacion = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, r.getId_reparacion()); // borrar id
			int filas = pst.executeUpdate();

			if (filas > 0) {
				System.out.println("> OK. reparación con id" + r.getId_reparacion() + " eliminado correctamente.");
				listaReparaciones.remove(r);
			} else {
				System.out.println("> NOK. reparación con id" + r.getId_reparacion() + " no se encuentra para la eliminacion.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reparaciones> findAll() {
	    return listaReparaciones;
	}
	
	public ArrayList<Reparaciones> findByEstadoFinalizado() {
	    ArrayList<Reparaciones> listaFinalizados = new ArrayList<>();

	    String sql = "SELECT id_reparacion, descripcion, fecha_entrada, coste_estimado, estado, vehiculo_id, usuario_id FROM reparacion WHERE estado = ?";

	    try (PreparedStatement pst = conexion.prepareStatement(sql)) {

	        pst.setString(1, "finalizado");  

	        try (ResultSet rs = pst.executeQuery()) {
	            while (rs.next()) {

	                Reparaciones r = new Reparaciones(rs.getString("descripcion"), rs.getDouble("coste_estimado"), rs.getString("estado"), null);
	                r.setId_reparacion(rs.getInt("id_reparacion"));
	                r.setFechaEntrada(rs.getDate("fecha_entrada").toLocalDate());
	                r.setIdVehiculo(rs.getInt("vehiculo_id"));
	                r.setIdCliente(rs.getInt("cliente_id"));

	                listaFinalizados.add(r);
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("> Error obteniendo reparaciones finalizadas: " + e.getMessage());
	    }

	    return listaFinalizados;
	}
	
	
	
	public void VerReparacionesPorEstadisticas() {

	    String sql = 
	        "SELECT estado, COUNT(*) AS total, AVG(coste_estimado) AS coste_medio " +
	        "FROM reparacion " +
	        "GROUP BY estado";

	    try (PreparedStatement pst = conexion.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {

	        System.out.println("\n==== ESTADO DE LA REPARACION ====");

	        while (rs.next()) {
	            String estado = rs.getString("estado");
	            int total = rs.getInt("total");
	            double costeMedio = rs.getDouble("coste_medio");

	            System.out.println("> Estado: " + estado);
	            System.out.println("  Total reparaciones: " + total);
	            System.out.println("  Coste medio: " + costeMedio + " €");
	        }

	    } catch (SQLException e) {
	        System.out.println("> Error al obtener las estadísticas: " + e.getMessage());
	    }
	}

	   @Override
	    public Reparaciones findById(int id) {
	        String sql = "SELECT id_reparacion,vehiculo_id,descripcion,fecha_entrada,coste_estimado,estado,mecanico_id FROM reparacion WHERE id_reparacion=?";
	        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
	            ps.setInt(1,id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) return mapRow(rs);
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	        return null;
	    }


	@Override
	public List<Reparaciones> findByEstado(String estado) {
        String sql = "SELECT id_reparacion,vehiculo_id,descripcion,fecha_entrada,coste_estimado,estado,mecanico_id FROM reparacion WHERE estado=?";
        List<Reparaciones> list = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, estado);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
	
	private Reparaciones mapRow(ResultSet rs) throws SQLException {
        Reparaciones r = new Reparaciones();
        r.setId_reparacion(rs.getInt("id_reparacion"));
        r.setVehiculoId(rs.getInt("vehiculo_id"));
        r.setDescripcion(rs.getString("descripcion"));
        Date d = rs.getDate("fecha_entrada");
        if (d != null) r.setFechaEntrada(d.toLocalDate());
        r.setCosteEstimado(rs.getDouble("coste_estimado"));
        r.setEstado(rs.getString("estado"));
        int mec = rs.getInt("mecanico_id");
        if (!rs.wasNull()) r.setMecanicoId(mec);
        return r;
    }
	
	@Override
	public OptionalDouble costeMedio() {
	    String sql = "SELECT AVG(coste_estimado) AS media FROM reparacion WHERE coste_estimado IS NOT NULL";
	    try (PreparedStatement ps = conexion.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        if (rs.next()) {
	            double val = rs.getDouble("media");
	            if (rs.wasNull()) return OptionalDouble.empty();
	            return OptionalDouble.of(val);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return OptionalDouble.empty();
	}


}
