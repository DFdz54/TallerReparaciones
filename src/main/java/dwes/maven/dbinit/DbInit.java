package dwes.maven.dbinit;

import java.time.LocalDate;
import java.util.List;

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

public class DbInit {
	private static int mecId;
    public static void init() {
        DAOFactory f = DAOFactory.getDAOFactory();
        UsuarioDAOInterfaz usuarioDAO = f.getUsuarioDAOInterfaz();
        ClienteDAOInterfaz clienteDAO = f.getCLienteDAOInterfaz();
        VehiculoDAOInterfaz vehiculoDAO = f.getVehiculoDAOInterfaz();
        ReparacionDAOInterfaz reparacionDAO = f.getReparacionDAOInterfaz();

        // USUARIOS
        List<Usuario> users = usuarioDAO.findall();
        if (users.isEmpty()) {
            System.out.println("Insertando prueba de usuarios");

            Usuario admin = new Usuario();
            admin.setDNI("12345678A");
            admin.setNombreUsuario("Administrador");
            admin.setPassword(PasswordUtils.hashPassword("admin123"));
            admin.setRol("ADMIN");
            usuarioDAO.insert(admin);

            Usuario mec = new Usuario();
            mec.setDNI("12345678B");
            mec.setNombreUsuario("Mecanico");
            mec.setPassword(PasswordUtils.hashPassword("meca123"));
            mec.setRol("MECANICO");
            usuarioDAO.insert(mec);
            
           
             mecId = mec.getIdUsuario();

            
        }

        // CLIENTES
        List<Cliente> clientes = clienteDAO.findAll();
        if (clientes.isEmpty()) {
            System.out.println("Insertando prueba de clientes");

            Cliente c1 = new Cliente();
            c1.setDni("12345678C");
            c1.setNombre("Dario Fernandez");
            c1.setTelefono(633787540);
            c1.setEmail("dario@gmail.com");
            clienteDAO.insert(c1);

            Cliente c2 = new Cliente();
            c2.setDni("12345678D");
            c2.setNombre("Pablo Fernandez");
            c2.setTelefono(654899612);
            c2.setEmail("pablo@gmail.com");
            clienteDAO.insert(c2);
        }

        clientes = clienteDAO.findAll();

        // VEHÍCULOS
        List<Vehiculo> vehs = vehiculoDAO.findall();
        if (vehs.isEmpty()) {
            System.out.println("Insertando prueba de vehiculos");

            Vehiculo v1 = new Vehiculo();
            v1.setMatricula("1234ABC");
            v1.setMarca("Seat");
            v1.setModelo("Cordoba");
            v1.setId_cliente(clientes.get(0).getId_cliente());
            vehiculoDAO.insert(v1);

            Vehiculo v2 = new Vehiculo();
            v2.setMatricula("5678DEF");
            v2.setMarca("Audi");
            v2.setModelo("A4");
            v2.setId_cliente(clientes.get(1).getId_cliente());
            vehiculoDAO.insert(v2);
        }

        vehs = vehiculoDAO.findall();

        // REPARACIONES
        List<Reparaciones> reps = reparacionDAO.findAll();
        if (reps.isEmpty()) {
            System.out.println("Insertando prueba de reparaciones");

            Reparaciones r1 = new Reparaciones();
            r1.setVehiculoId(vehs.get(0).getId_vehiculo());
            r1.setDescripcion("Sustitucion de faros defectuosos");
            r1.setFechaEntrada(LocalDate.now().minusDays(7));
            r1.setCosteEstimado(50);
            r1.setEstado("finalizada");
            r1.setMecanicoId(mecId);
            reparacionDAO.insert(r1);

            Reparaciones r2 = new Reparaciones();
            r2.setVehiculoId(vehs.get(1).getId_vehiculo());
            r2.setDescripcion("Limpieza del carburizante");
            r2.setFechaEntrada(LocalDate.now().minusDays(3));
            r2.setCosteEstimado(20);
            r2.setEstado("en curso");
            r2.setMecanicoId(mecId);
            reparacionDAO.insert(r2);

            Reparaciones r3 = new Reparaciones();
            r3.setVehiculoId(vehs.get(1).getId_vehiculo());
            r3.setDescripcion("Sustitucion de rueda de recambio");
            r3.setFechaEntrada(LocalDate.now().minusDays(1));
            r3.setCosteEstimado(80);
            r3.setEstado("pendiente");
            r3.setMecanicoId(mecId);
            reparacionDAO.insert(r3);
        }

        System.out.println("Datos iniciales listos.");
    }
}
