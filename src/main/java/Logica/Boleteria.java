package Logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Boleteria {

    public void inicio() {

        Scanner scanner = new Scanner(System.in);
        Persistencia archivos = new Persistencia();
        Taquilla taquilla = new Taquilla();
        createLoggFile();

        ArrayList<Usuario> baseDatosUsuarios = archivos.leerArchivoUsers();
        ArrayList<Evento> baseDatosEventos = new ArrayList<>();
        archivos.crearArchivoTexto();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nIngreso\n");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("0. Salir\n");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            System.out.println("");
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema");
                    logger.info("Cliente escoge opcion de salida del sistema");
                    break;
                case 1:
                    usuario(baseDatosUsuarios, baseDatosEventos, archivos, taquilla);
                    logger.info("Cliente escoge opcion de ingreso al menu de usuario");
                    break;
                case 2:
                    administrador(baseDatosEventos);
                    logger.info("liente escoge opcion de ingreso al menu adminstrativo");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida");
                    logger.info("Cliente digita opcion incorrecta");
                    break;
            }
        }
        scanner.close();
    }

    private static void usuario(ArrayList<Usuario> baseDatosUsuarios, ArrayList<Evento> baseDatosEventos,  Persistencia archivos, Taquilla taquilla) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Panel usuario\n");
            System.out.println("1. Iniciar sesión de usuario");
            System.out.println("2. Crear Usuario");
            System.out.println("0. Volver\n");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del panel usuario");
                    break;
                case 1:
                    taquilla.venderTiquetes(baseDatosEventos);

                    break;
                case 2:
                    System.out.print("Documento:");
                    String documento = scanner.nextLine();

                    boolean usuarioExistente = false;
                    for (Usuario usuario : baseDatosUsuarios) {
                        if (usuario.getDocumento().equals(documento)) {
                            usuarioExistente = true;
                            System.out.println("El usuario ya existe. No se puede agregar.");
                            break;
                        }
                    }

                    if (!usuarioExistente) {
                        System.out.print("Nombres:");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellidos:");
                        String apellidos = scanner.nextLine();
                        System.out.print("Contraseña:");
                        String contrasena = scanner.next();
                        System.out.print("Correo:");
                        String correo = scanner.next();
                        baseDatosUsuarios.add(new Usuario(nombre, apellidos, documento, contrasena, correo));
                        archivos.escribirArchivoUsers(baseDatosUsuarios);
                        System.out.println("Usuario agregado correctamente.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida");
                    break;
            }
        }
    }

    private static void administrador(ArrayList<Evento> baseDatosEventos) {
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("Panel admin\n");
            System.out.println("1. Apertura de taquilla");
            System.out.println("2. Registrar evento");
            System.out.println("0. Volver\n");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del panel admin");
                    break;
                case 1:

                    break;
                case 2:
                    System.out.print("Nombre:");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la fecha (Año-Mes-Dia):");
                    String fechaInput = scanner.nextLine();
                    LocalDate fecha= null;
                    try {
                        fecha = LocalDate.parse(fechaInput);
                    } catch (DateTimeParseException e) {
                        System.out.println("La Fecha ingresada no es válida. Por favor ingrese en formato HH:mm.");
                    }

                    System.out.print("Hora (HH:mm): ");
                    String horaInput = scanner.nextLine();
                    LocalTime hora = null;
                    try {
                        hora = LocalTime.parse(horaInput);
                    } catch (DateTimeParseException e) {
                        System.out.println("La hora ingresada no es válida. Por favor ingrese en formato HH:mm.");
                    }

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
                    baseDatosEventos.add(new Evento(nombre, fecha, hora, lugar, artistas, precioCobre, precioPlata, precioOro, capacidad));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    //SECCION Y COMANDOS DE LOGGS
    private static Logger logger = Logger.getLogger("MyLog");

    private static void createLoggFile() {
        FileHandler fh;
        try {
            //ruta donde se guardara el logg
            fh = new FileHandler("src\\main\\java\\DataBase\\MyLoggerFile.log");

            //Bloque de inicializacion del documento donde se guardaran los Loggs
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Creando logger");
        }catch (Exception e){
            logger.log(Level.WARNING,"Exception ::",e);
        }
        logger.info("Logger creado\n\n");
    }

    private static void addLogg(String msg, Exception e){
        logger.log(Level.WARNING,msg,e);
    }
}
