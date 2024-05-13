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
                    break;
                case 1:
                    ingresoUsuario(baseDatosUsuarios);
                case 2:
                    administrador(baseDatosEventos);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida");
            }
        }
        scanner.close();
    }


    private static void ingresoUsuario(ArrayList<Usuario> baseDatosUsuarios) {
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("Panel Usuario");
            System.out.println("");
            System.out.println("1. Panel de usuario");
            System.out.println("2. Comprar boletas");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    usuario(baseDatosUsuarios);
                    break;
                case 2:
                    boletas();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }


    private static void usuario(ArrayList<Usuario> baseDatosUsuarios) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Actualizar Usuario");
            System.out.println("3. Buscar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1:
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
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void boletas() {


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
            }
        }
    }
}