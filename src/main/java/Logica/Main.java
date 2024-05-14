package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Evento> baseDatosEventos = new ArrayList<>();
        ArrayList<Usuario> baseDatosUsuarios = new ArrayList<>();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("Ingreso");
            System.out.println("");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            System.out.println("");
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema");
                    break; // Agregado
                case 1:
                    usuario(baseDatosUsuarios, baseDatosEventos);
                    break; // Agregado
                case 2:
                    administrador(baseDatosEventos);
                    break; // Agregado
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida");
                    break; // Agregado
            }
        }
        scanner.close();
    }



    private static void usuario(ArrayList<Usuario> baseDatosUsuarios, ArrayList<Evento> baseDatosEventos) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("");
            System.out.println("1. Iniciar sesion de usuario");
            System.out.println("2. Crear Usuario");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    opcion = 0;
                    break;
                case 1:
                    System.out.print("Ingrese el documento:");
                    String docBuscarAgregar = scanner.nextLine();
                    System.out.print("Ingrese su contraseña:");
                    String conBuscarAgregar = scanner.nextLine();
                    int i = 0;
                    while (i < baseDatosUsuarios.size()) {
                        Usuario usuario = baseDatosUsuarios.get(i);
                        if (usuario.getDocumento().equals(docBuscarAgregar) && usuario.getContrasena().equals(conBuscarAgregar)) {
                            System.out.println(usuario.getNombre());
                            System.out.println(usuario.getApellidos());
                            System.out.println(usuario.getDocumento());
                            System.out.println(usuario.getCorreo());
                            venderTiquetes(baseDatosEventos);
                            i = baseDatosUsuarios.size();
                        } else {
                            System.out.println("Usuario no encontrado");
                        }
                        i++;
                    }
                    break;
                case 2:
                    System.out.print("Nombres:");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos:");
                    String apellidos = scanner.nextLine();
                    System.out.print("Documento:");
                    String documento = scanner.next();
                    System.out.print("Contraseña:");
                    String contrasena = scanner.next();
                    System.out.print("Correo:");
                    String correo = scanner.next();
                    baseDatosUsuarios.add(new Usuario(nombre, apellidos, documento, contrasena, correo));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static int venderTiquetes(ArrayList<Evento> baseDatosEventos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es el nombre del evento al que quiere asistir:");
        String nombreEventoBus = scanner.nextLine();
        int i = 0;
        int total = 0;
        while (i < baseDatosEventos.size()) {
            Evento evento = baseDatosEventos.get(i);
            if (evento.getNombre().equalsIgnoreCase(nombreEventoBus)) {
                int cobre = evento.getPrecioCobre();
                int plata = evento.getPrecioPlata();
                int oro = evento.getPrecioOro();
                System.out.println("Bienvenido a la venta de boletos.");
                total = 0;
                int opcion = -1;
                int cantidad = 0;
                while (opcion != 0) {
                    System.out.println("¿Qué tipo de boleto desea comprar?");
                    System.out.println("1. Cobre");
                    System.out.println("2. Plata");
                    System.out.println("3. Oro");
                    System.out.println("0. Salir");
                    opcion = scanner.nextInt();
                    if (opcion != 0) {
                        System.out.println("¿Cuántos boletos desea comprar?");
                        cantidad = scanner.nextInt();
                    }
                    switch (opcion) {
                        case 1:
                            total = total + venderCobre(cantidad, cobre, baseDatosEventos);
                            break;
                        case 2:
                            total = total + venderPlata(cantidad, plata, baseDatosEventos);
                            break;
                        case 3:
                            total = total + venderOro(cantidad, oro, baseDatosEventos);
                            break;
                        case 0:
                            opcion = 0;
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                }
            }
            i++;
        }

        return total;
    }


    private static int venderCobre(int cantidad, int cobre, ArrayList<Evento> baseDatosEventos) {
        int totalCobre = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getCanEscenario() * 0.6) {
                evento.setCanEscenario(evento.getCanEscenario() - cantidad);
                totalCobre = cantidad * cobre;
                System.out.println("Se han vendido " + cantidad + " boletos cobre");
            } else {
                System.out.println("Ya no hay boletos cobre disponibles");
            }
        }
        return totalCobre;
    }

    private static int venderPlata(int cantidad, int plata, ArrayList<Evento> baseDatosEventos) {
        int totalPlata = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getCanEscenario() * 0.3) {
                evento.setCanEscenario(evento.getCanEscenario() - cantidad);
                totalPlata += cantidad * plata;
                System.out.println("Se han vendido " + cantidad + " boletos de plata.");
            } else {
                System.out.println("Ya no hay boletos plata disponibles");
            }
        }
        return totalPlata;
    }

    private static int venderOro(int cantidad, int oro, ArrayList<Evento> baseDatosEventos) {
        int totalOro = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getCanEscenario() * 0.1) {
                evento.setCanEscenario(evento.getCanEscenario() - cantidad);
                totalOro += cantidad * oro;
                System.out.println("Se han vendido " + cantidad + " boletos de oro.");
            } else {
                System.out.println("Ya no hay boletos oro disponibles");
            }
        }
        return totalOro;
    }

    private static void administrador(ArrayList<Evento> baseDatosEventos) {
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("Panel admin");
            System.out.println("");
            System.out.println("1. Registrar evento");
            System.out.println("2. Apertura de taquilla");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.print("Nombre:");
                    String nombre = scanner.nextLine();
                    System.out.print("Fecha:");
                    String fecha = scanner.nextLine();
                    System.out.print("Lugar:");
                    String lugar = scanner.nextLine();
                    System.out.print("Artistas:");
                    String artistas = scanner.nextLine();
                    System.out.print("Precio cobre:");
                    int precioCobre = scanner.nextInt();
                    System.out.print("Precio plata:");
                    int precioPlata = scanner.nextInt();
                    System.out.print("Precio oro:");
                    int precioOro = scanner.nextInt();
                    System.out.print("Capacidad:");
                    int capacidad = scanner.nextInt();
                    baseDatosEventos.add(new Evento(nombre, fecha, lugar, artistas, precioCobre, precioPlata, precioOro, capacidad));
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}
