package dwes.maven.controlador;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import dwes.maven.entidades.Cliente;
import dwes.maven.entidades.Reparaciones;
import dwes.maven.entidades.Usuario;
import dwes.maven.entidades.Vehiculo;

public class VistaTaller {

    private final Scanner sc = new Scanner(System.in);
    private final ControladorTaller ctrl = ControladorTaller.getInstance();

    public void inicio() {
        while (true) {
            Usuario u = ctrl.getUsuarioSesion();

            System.out.println("\n========= TALLER DE REPARACIONES =========");
            if (u == null) {
                System.out.println("Perfil: INVITADO");
                menuInvitado();
            } else {
                System.out.println("Perfil: " + u.getRol());
                switch (u.getRol().toUpperCase()) {
                    case "MECANICO": menuMecanico(); break;
                    case "ADMIN": menuAdmin(); break;
                    default: menuInvitado(); break;
                }
            }
        }
    }

    private void menuInvitado() {
        System.out.println("1. Ver reparaciones finalizadas (CU1)");
        System.out.println("2. Login (CU2)");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        String op = sc.nextLine();

        switch (op) {
            case "1": mostrarReparacionesFinalizadas(); break;
            case "2": hacerLogin(); break;
            case "0": System.exit(0);
            default: System.out.println("Opción no válida.");
        }
    }

    private void menuMecanico() {
        System.out.println("1. Ver reparaciones finalizadas (CU1)");
        System.out.println("2. Registrar reparación (CU3)");
        System.out.println("3. Cambiar estado reparación (CU4)");
        System.out.println("4. Logout");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        String op = sc.nextLine();

        switch (op) {
            case "1": mostrarReparacionesFinalizadas(); break;
            case "2": registrarReparacion(); break;
            case "3": cambiarEstadoReparacion(); break;
            case "4": ctrl.logout(); System.out.println("Sesión cerrada."); break;
            case "0": System.exit(0);
            default: System.out.println("Opción no válida.");
        }
    }

    private void menuAdmin() {
        System.out.println("1. Ver reparaciones finalizadas (CU1)");
        System.out.println("2. Registrar reparación (CU3)");
        System.out.println("3. Cambiar estado reparación (CU4)");
        System.out.println("4. Gestionar clientes (CU5)");
        System.out.println("5. Gestionar vehículos (CU5)");
        System.out.println("6. Estadísticas (CU6)");
        System.out.println("7. Logout");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

        String op = sc.nextLine();
        switch (op) {
            case "1": mostrarReparacionesFinalizadas(); break;
            case "2": registrarReparacion(); break;
            case "3": cambiarEstadoReparacion(); break;
            case "4": gestionarClientes(); break;
            case "5": gestionarVehiculos(); break;
            case "6": mostrarEstadisticas(); break;
            case "7": ctrl.logout(); System.out.println("Sesión cerrada."); break;
            case "0": System.exit(0);
            default: System.out.println("Opción no válida.");
        }
    }

    private void hacerLogin() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (ctrl.login(dni, pass)) {
            System.out.println("Login correcto.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void mostrarReparacionesFinalizadas() {
        List<Reparaciones> lista = ctrl.verReparacionesFinalizadas();
        if (lista.isEmpty()) {
            System.out.println("No hay reparaciones finalizadas.");
            return;
        }
        lista.forEach(r -> {
            System.out.printf("ID: %d Vehículo: %d Fecha: %s Coste: %.2f Desc: %s\n",
                r.getId_reparacion(), r.getIdVehiculo(),
                r.getFechaEntrada(), r.getCosteEstimado(), r.getDescripcion());
        });
    }

    private void registrarReparacion() {
        try {
            System.out.print("ID vehículo: ");
            int vehId = Integer.parseInt(sc.nextLine());

            System.out.print("Descripción: ");
            String desc = sc.nextLine();

            System.out.print("Fecha entrada (YYYY-MM-DD): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());

            System.out.print("Coste estimado: ");
            double coste = Double.parseDouble(sc.nextLine());

            boolean ok = ctrl.registrarReparacion(vehId, desc, fecha, coste, null);
            if (ok) System.out.println("Reparación registrada.");
            else System.out.println("Error al registrar.");
        } catch (Exception e) {
            System.out.println("Datos inválidos.");
        }
    }

    private void cambiarEstadoReparacion() {
        try {
            System.out.print("ID reparación: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nuevo estado (pendiente/en curso/finalizada): ");
            String est = sc.nextLine();

            boolean ok = ctrl.cambiarEstadoReparacion(id, est);
            if (ok) System.out.println("Estado actualizado.");
            else System.out.println("No se pudo actualizar el estado.");
        } catch (Exception e) {
            System.out.println("Datos inválidos.");
        }
    }

    private void gestionarClientes() {
        System.out.println("1. Alta cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Baja cliente");
        System.out.print("Opción: ");
        String op = sc.nextLine();

        switch (op) {
            case "1": altaCliente(); break;
            case "2": modificarCliente(); break;
            case "3": bajaCliente(); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private void altaCliente() {
        Cliente c = new Cliente();
        System.out.print("DNI: "); c.setDni(sc.nextLine());
        System.out.print("Nombre: "); c.setNombre(sc.nextLine());
        System.out.print("Teléfono: "); c.setTelefono(Integer.parseInt(sc.nextLine()));
        System.out.print("Email: "); c.setEmail(sc.nextLine());

        boolean ok = ctrl.altaCliente(c);
        System.out.println(ok ? "Cliente añadido." : "No se pudo añadir.");
    }

    private void modificarCliente() {
        System.out.print("DNI cliente: ");
        String dni  = sc.nextLine();

        Cliente c = ctrl.buscarClientePorDNI(dni);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Deja el campo vacío para no cambiarlo.");

        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isEmpty()) c.setNombre(nombre);

        System.out.print("Nuevo teléfono (" + c.getTelefono() + "): ");
        String tel = sc.nextLine().trim();
        if (!tel.isEmpty()) c.setTelefono(Integer.parseInt(tel));

        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) c.setEmail(email);


        boolean ok = ctrl.modificarCliente(c);
        System.out.println(ok ? "Cliente modificado." : "No se pudo modificar.");
    }


    private void bajaCliente() {
        Cliente c = new Cliente();
        System.out.print("ID cliente: "); c.setId_cliente(Integer.parseInt(sc.nextLine()));
        boolean ok = ctrl.bajaCliente(c);
        System.out.println(ok ? "Cliente eliminado." : "No se pudo eliminar.");
    }

    private void gestionarVehiculos() {
        System.out.println("1. Alta vehículo");
        System.out.println("2. Modificar vehículo");
        System.out.println("3. Baja vehículo");
        System.out.print("Opción: ");
        String op = sc.nextLine();

        switch (op) {
            case "1": altaVehiculo(); break;
            case "2": modificarVehiculo(); break;
            case "3": bajaVehiculo(); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private void altaVehiculo() {
        Vehiculo v = new Vehiculo();
        System.out.print("Matrícula: "); v.setMatricula(sc.nextLine());
        System.out.print("Marca: "); v.setMarca(sc.nextLine());
        System.out.print("Modelo: "); v.setModelo(sc.nextLine());
        System.out.print("ID cliente: "); v.setId_cliente(Integer.parseInt(sc.nextLine()));

        boolean ok = ctrl.altaVehiculo(v);
        System.out.println(ok ? "Vehículo añadido." : "No se pudo añadir.");
    }

    private void modificarVehiculo() {
        Vehiculo v = new Vehiculo();
        System.out.print("ID vehículo: "); v.setId_vehiculo(Integer.parseInt(sc.nextLine()));
        System.out.print("Nueva matrícula: "); v.setMatricula(sc.nextLine());
        System.out.print("Nueva marca: "); v.setMarca(sc.nextLine());
        System.out.print("Nuevo modelo: "); v.setModelo(sc.nextLine());
        System.out.print("Nuevo ID cliente: "); v.setId_cliente(Integer.parseInt(sc.nextLine()));

        boolean ok = ctrl.modificarVehiculo(v);
        System.out.println(ok ? "Vehículo modificado." : "No se pudo modificar.");
    }

    private void bajaVehiculo() {
        Vehiculo v = new Vehiculo();
        System.out.print("ID vehículo: "); v.setId_vehiculo(Integer.parseInt(sc.nextLine()));
        boolean ok = ctrl.bajaVehiculo(v);
        System.out.println(ok ? "Vehículo eliminado." : "No se pudo eliminar.");
    }

    private void mostrarEstadisticas() {
        Map<String, Long> estados = ctrl.reparacionesPorEstado();
        OptionalDouble medio = ctrl.costeMedio();

        System.out.println("\n--- Estadísticas (CU6) ---");
        System.out.println("Reparaciones por estado:");
        estados.forEach((estado, count) -> System.out.println(estado + ": " + count));

        if (medio.isPresent())
            System.out.println("Coste medio: " + medio.getAsDouble());
        else
            System.out.println("Coste medio: Sin datos");
    }
}

