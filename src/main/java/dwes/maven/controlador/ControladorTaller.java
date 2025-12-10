package dwes.maven.controlador;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import dwes.maven.dao.DAOFactory;
import dwes.maven.dao.interfaces.ClienteDAOInterfaz;
import dwes.maven.dao.interfaces.ReparacionDAOInterfaz;
import dwes.maven.dao.interfaces.UsuarioDAOInterfaz;
import dwes.maven.dao.interfaces.VehiculoDAOInterfaz;
import dwes.maven.entidades.Cliente;
import dwes.maven.entidades.Reparaciones;
import dwes.maven.entidades.Usuario;
import dwes.maven.entidades.Vehiculo;
import dwes.maven.utilities.PasswordUtils;

public class ControladorTaller {
    private static ControladorTaller instance;
    private Usuario usuarioSesion;

    private UsuarioDAOInterfaz usuarioDAO;
    private ClienteDAOInterfaz clienteDAO;
    private VehiculoDAOInterfaz vehiculoDAO;
    private ReparacionDAOInterfaz reparacionDAO;

    private ControladorTaller() {
        DAOFactory f = DAOFactory.getDAOFactory();
        this.usuarioDAO = f.getUsuarioDAOInterfaz();
        this.clienteDAO = f.getCLienteDAOInterfaz();
        this.vehiculoDAO = f.getVehiculoDAOInterfaz();
        this.reparacionDAO = f.getReparacionDAOInterfaz();
    }

    public static synchronized ControladorTaller getInstance() {
        if (instance == null) instance = new ControladorTaller();
        return instance;
    }

    public boolean login(String dni, String password) {
        Usuario u = usuarioDAO.findByDNI(dni);
        if (u == null) return false;
        if (PasswordUtils.verifyPassword(password, u.getPassword())) {
            this.usuarioSesion = u;
            return true;
        }
        return false;
    }

    public void logout() { this.usuarioSesion = null; }
    public Usuario getUsuarioSesion() { return usuarioSesion; }

    
    public List<Reparaciones> verReparacionesFinalizadas() {
        List<Reparaciones> l = reparacionDAO.findByEstado("finalizada");
        l.sort(Comparator.comparing(Reparaciones::getFechaEntrada).reversed());
        return l;
    }

    
    public boolean registrarReparacion(int vehiculoId, String descripcion, LocalDate fechaEntrada, double costeEstimado, Integer mecanicoId) {
        if (mecanicoId == null) { // require logged mechanic or admin
            if (usuarioSesion == null) return false;
            if (!"MECANICO".equalsIgnoreCase(usuarioSesion.getRol()) && !"ADMIN".equalsIgnoreCase(usuarioSesion.getRol())) return false;
            mecanicoId = usuarioSesion.getIdUsuario();
        }
        Reparaciones r = new Reparaciones();
        r.setVehiculoId(vehiculoId);
        r.setDescripcion(descripcion);
        r.setFechaEntrada(fechaEntrada);
        r.setCosteEstimado(costeEstimado);
        r.setEstado("pendiente");
        r.setMecanicoId(mecanicoId);
        reparacionDAO.insert(r);
        return r.getId_reparacion() > 0;
    }

    public boolean cambiarEstadoReparacion(int reparacionId, String nuevoEstado) {
        Reparaciones r = reparacionDAO.findById(reparacionId);
        if (r == null) return false;
        if (usuarioSesion == null) return false;
        if (!"MECANICO".equalsIgnoreCase(usuarioSesion.getRol()) && !"ADMIN".equalsIgnoreCase(usuarioSesion.getRol())) return false;
        if (!Arrays.asList("pendiente","en curso","finalizada").contains(nuevoEstado.toLowerCase())) return false;
        r.setEstado(nuevoEstado.toLowerCase());
        reparacionDAO.update(r);
        return true;
    }

    public boolean altaCliente(Cliente c) {
        if (!isAdmin()) return false;
        clienteDAO.insert(c); return c.getId_cliente() > 0;
    }
    
    public Cliente buscarClientePorDNI(String dni) {
        return clienteDAO.findByDni(dni);
    }

    public boolean modificarCliente(Cliente c) {
        if (!isAdmin()) return false;
        clienteDAO.update(c); return true;
    }
    public boolean bajaCliente(Cliente c) {
        if (!isAdmin()) return false;
        clienteDAO.delete(c); return true;
    }

    public boolean altaVehiculo(Vehiculo v) {
        if (!isAdmin()) return false;
        vehiculoDAO.insert(v); return v.getId_vehiculo() > 0;
    }
    public boolean modificarVehiculo(Vehiculo v) {
        if (!isAdmin()) return false;
        vehiculoDAO.update(v); return true;
    }
    public boolean bajaVehiculo(Vehiculo v) {
        if (!isAdmin()) return false;
        vehiculoDAO.delete(v); return true;
    }

    public Map<String, Long> reparacionesPorEstado() {
        List<Reparaciones> all = reparacionDAO.findAll();
        return all.stream().collect(Collectors.groupingBy(r -> r.getEstado(), Collectors.counting()));
    }

    public OptionalDouble costeMedio() {
        return reparacionDAO.costeMedio();
    }


    private boolean isAdmin() {
        return usuarioSesion != null && "ADMIN".equalsIgnoreCase(usuarioSesion.getRol());
    }
}
