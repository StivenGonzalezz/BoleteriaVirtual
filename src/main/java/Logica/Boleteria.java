package Logica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
                    ExecutorService executorService = Executors.newFixedThreadPool(3);
                    String nombreEventoBus = JOptionPane.showInputDialog(null, "¿Cuál es el nombre del evento al que quiere asistir?");
                    boolean eventoEncontrado = false;

                    for (Evento evento : baseDatosEventos) {
                        if (evento.getNombre().equalsIgnoreCase(nombreEventoBus)) {
                            if (contador <= evento.getCanEscenario()) {
                                Runnable tarea = new Hilos.miTarera("tarea" + contador);
                                executorService.execute(tarea);
                                executorService.shutdown();
                                contador++;
                                eventoEncontrado = true;
                                break;
                            }
                        }
                    }

                    if (!eventoEncontrado) {
                        JOptionPane.showMessageDialog(null, "Evento no encontrado o no hay cupo disponible");
                    }
                    break;
                case 2:
                    mostrarEventos(baseDatosEventos);
                    break;
                case 3:
                    String documento = JOptionPane.showInputDialog(null, "Documento:");
                    boolean usuarioExistente = false;

                    for (Usuario usuario : baseDatosUsuarios) {
                        if (usuario.getDocumento().equals(documento)) {
                            usuarioExistente = true;
                            JOptionPane.showMessageDialog(null, "El usuario ya existe. No se puede agregar.");
                            break;
                        }
                    }

                    if (!usuarioExistente) {
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
                    //JOptionPane.showMessageDialog(null, "Saliendo del panel admin");
                    break;
                case 1:
                    // Implementa la lógica de "Apertura de taquilla"
                    break;
                case 2:
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
                            JOptionPane.showMessageDialog(null, "El evento ya existe. No se puede agregar.");
                            break;
                        }
                    }

                    if (!eventoExistente) {
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