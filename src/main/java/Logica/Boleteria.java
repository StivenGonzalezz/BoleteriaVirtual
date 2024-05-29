package Logica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Boleteria {

    public void inicio() {
        Persistencia archivos = new Persistencia();
        Taquilla taquilla = new Taquilla();
        createLoggFile();
        archivos.crearArchivoTexto();
        ArrayList<Usuario> baseDatosUsuarios = archivos.leerArchivoUsers();
        ArrayList<Evento> baseDatosEventos = archivos.leerArchivoEvents();
        int contador = 1;
        String contrasenaAdmin="1234";
        String idAdmin="1234";

        int opcion = -1;

        while (opcion != 0) {
            String opcionStr = JOptionPane.showInputDialog(null,
                    "Ingreso\n\n" +
                            "1. Usuario\n" +
                            "2. Administrador\n" +
                            "0. Salir\n\n" +
                            "Ingrese su opción:");
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    logger.info("Cliente escoge opción de salida del sistema");
                    break;
                case 1:
                    usuario(baseDatosUsuarios, baseDatosEventos, archivos, taquilla, contador);
                    break;
                case 2:
                    String regsiterPaswordAdmin = JOptionPane.showInputDialog(null, "Contraseña del admin:");
                    String registerIDAdmin = JOptionPane.showInputDialog(null, "ID del admin:");
                    if(contrasenaAdmin.equals(regsiterPaswordAdmin) && idAdmin.equals(registerIDAdmin)){
                        administrador(baseDatosEventos, archivos);
                    }else
                        JOptionPane.showMessageDialog(null, "Contraseña o ID no coinciden");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor ingrese una opción válida");
                    break;
            }
        }
    }

    private void usuario(ArrayList<Usuario> baseDatosUsuarios, ArrayList<Evento> baseDatosEventos,
                         Persistencia archivos, Taquilla taquilla, int contador) {
        int opcion = -1;
        while (opcion != 0) {
            String opcionStr = JOptionPane.showInputDialog(null,
                    "Panel usuario\n\n" +
                            "1. Comprar Tiquetes\n" +
                            "2. Información de eventos\n" +
                            "3. Crear Usuario\n" +
                            "0. Volver\n\n" +
                            "Ingrese su opción:");
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 0:
                    //JOptionPane.showMessageDialog(null, "Saliendo del panel usuario");
                    break;
                case 1:
                   taquilla.venderTiquetes(baseDatosEventos, baseDatosUsuarios,archivos);

                    String opcionCompra = JOptionPane.showInputDialog(null,
                            "Panel usuario\n\n" +
                                    "1. VisaNacional\n" +
                                    "2. MastercardNacional\n" +
                                    "3. AmericanExpressNacional\n" +
                                    "4. payvalida\n" +
                                    "5. Efecty\n" +
                                    "6. PSE\n" +
                                    "7. SafetyPay\n" +
                                    "8. Visa\n" +
                                    "9. MasterCard\n" +
                                    "0. volver\n" +
                                    "Ingrese su opción:");

                    int opcionPago = Integer.parseInt(opcionStr);
                    switch (opcionPago){
                        case 1:
                            System.out.println("se pago con VisaNacional");
                            break;
                        case 2:
                            System.out.println("se pago con MastercardNacional");
                            break;
                        case 3:
                            System.out.println("se pago con AmericanExpressNacional");
                            break;
                        case 4:
                            System.out.println("se pago con payvalida");
                            break;
                        case 5:
                            System.out.println("se pago con Efecty");
                            break;
                        case 6:
                            System.out.println("se pago con PSE");
                            break;
                        case 7:
                            System.out.println("se pago con SafetyPay");
                            break;
                        case 8:
                                System.out.println("se pago con Visa");
                                break;
                        case 9:
                            System.out.println("se pago con MasterCard");
                            break;

                        case 0:
                            System.out.println("no se pago");
                    }
                   break;



                case 2:
                    logger.info("usuario ingresa opcion de mostrar eventos");
                    mostrarEventos(baseDatosEventos);
                    break;
                case 3:
                    String documento = JOptionPane.showInputDialog(null, "Documento:");
                    boolean usuarioExistente = false;

                    for (Usuario usuario : baseDatosUsuarios) {
                        if (usuario.getDocumento().equals(documento)) {
                            usuarioExistente = true;
                            logger.info("error al crear usuario");
                            JOptionPane.showMessageDialog(null, "El usuario ya existe. No se puede agregar.");
                            break;
                        }
                    }

                    if (!usuarioExistente) {
                        logger.info("usuario creado");
                        String nombre = JOptionPane.showInputDialog(null, "Nombres:");
                        String apellidos = JOptionPane.showInputDialog(null, "Apellidos:");
                        String contrasena = JOptionPane.showInputDialog(null, "Contraseña:");
                        String correo = JOptionPane.showInputDialog(null, "Correo:");

                        baseDatosUsuarios.add(new Usuario(nombre, apellidos, documento, contrasena, correo));
                        archivos.escribirArchivoUsers(baseDatosUsuarios);
                        JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor ingrese una opción válida");
                    break;
            }
        }
    }

    private void administrador(ArrayList<Evento> baseDatosEventos, Persistencia archivos) {
        int opcion = -1;
        while (opcion != 0) {
            String opcionStr = JOptionPane.showInputDialog(null,
                    "Panel admin\n\n" +
                            "1. Apertura de taquilla\n" +
                            "2. Registrar evento\n" +
                            "0. Volver\n\n" +
                            "Ingrese su opción:");
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del panel admin");
                    break;
                case 1:
                    // Implementa la lógica de "Apertura de taquilla"
                    break;
                case 2:
                    logger.info("usuario ingresa opcion de crear evento");
                    String lugar = JOptionPane.showInputDialog(null, "Lugar:");
                    String fechaInput = JOptionPane.showInputDialog(null, "Ingrese la fecha (Año-Mes-Dia):");
                    LocalDate fecha = null;
                    try {
                        fecha = LocalDate.parse(fechaInput);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "La Fecha ingresada no es válida. Por favor ingrese en formato YYYY-MM-DD.");
                        continue;
                    }

                    String horaInput = JOptionPane.showInputDialog(null, "Hora (HH:mm):");
                    LocalTime hora = null;
                    try {
                        hora = LocalTime.parse(horaInput);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "La hora ingresada no es válida. Por favor ingrese en formato HH:mm.");
                        continue;
                    }

                    boolean eventoExistente = false;
                    for (Evento evento : baseDatosEventos) {
                        if (evento.getLugar().equals(lugar) && evento.getFecha().equals(fecha) && evento.getHora().equals(hora)) {
                            eventoExistente = true;
                            logger.info("error al crear evento");
                            JOptionPane.showMessageDialog(null, "El evento ya existe. No se puede agregar.");
                            break;
                        }
                    }

                    if (!eventoExistente) {
                        logger.info("evento creado con exito");
                        String nombre = JOptionPane.showInputDialog(null, "Nombre:");
                        String artistas = JOptionPane.showInputDialog(null, "Artistas:");
                        int precioCobre = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio cobre:"));
                        int precioPlata = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio plata:"));
                        int precioOro = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio oro:"));
                        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidad:"));

                        baseDatosEventos.add(new Evento(nombre, fecha, hora, lugar, artistas, precioCobre, precioPlata, precioOro, capacidad, (int) (capacidad * 0.6), (int) (capacidad * 0.3), (int) (capacidad * 0.1)));
                        archivos.escribirArchivoEvents(baseDatosEventos);
                        JOptionPane.showMessageDialog(null, "Evento agregado correctamente");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private void mostrarEventos(ArrayList<Evento> eventos) {
        StringBuilder eventosStr = new StringBuilder("Eventos\n\n");
        for (Evento evento : eventos) {
            eventosStr.append("Nombre: ").append(evento.getNombre()).append("\n");
            eventosStr.append("Lugar: ").append(evento.getLugar()).append("\n");
            eventosStr.append("Fecha: ").append(evento.getFecha()).append("\n");
            eventosStr.append("Hora: ").append(evento.getHora()).append("\n");
            eventosStr.append("Artistas: ").append(evento.getArtista()).append("\n");
            eventosStr.append("Precio Cobre: ").append(evento.getPrecioCobre()).append("\n");
            eventosStr.append("Precio Plata: ").append(evento.getPrecioPlata()).append("\n");
            eventosStr.append("Precio Oro: ").append(evento.getPrecioOro()).append("\n");
            eventosStr.append("Capacidad: ").append(evento.getCanEscenario()).append("\n");
            eventosStr.append("Cobre Disponible: ").append(evento.getCobreDispo()).append("\n");
            eventosStr.append("Plata Disponible: ").append(evento.getPlataDispo()).append("\n");
            eventosStr.append("Oro Disponible: ").append(evento.getOroDispo()).append("\n");
            eventosStr.append("-----------------------------\n");
        }
        JOptionPane.showMessageDialog(null, eventosStr.toString());
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
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception ::", e);
        }
        logger.info("Logger creado\n\n");
    }

    private static void addLogg(String msg, Exception e) {
        logger.log(Level.WARNING, msg, e);
    }
}
