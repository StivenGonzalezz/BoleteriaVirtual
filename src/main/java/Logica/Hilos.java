package Logica;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Hilos {

    private static String nombreUser;
    private static String apellidosUser;
    private static String documentoeUser;
    private static String contrasenaUser;
    private static String correoUser;
    private static String codigoConcatenado = "";

    public static class miTarera implements Runnable {

        private  String tarea;

        public miTarera(String tarea) {
            this.tarea = tarea;
        }

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName()+": "+tarea);
            Persistencia archivos = new Persistencia();
            ArrayList<Evento> baseDatosEventos = archivos.leerArchivoEvents();
            ArrayList<Usuario> baseDatosUsuarios = archivos.leerArchivoUsers();
            venderTiquetes(baseDatosEventos, baseDatosUsuarios, archivos);
        }

        public int venderTiquetes(ArrayList<Evento> baseDatosEventos, ArrayList<Usuario> baseDatosUsuarios, Persistencia archivos) {
            int total = 0;

            String nombreEventoBus = JOptionPane.showInputDialog("Cual es el nombre del evento al que quiere asistir:");
            int i = 0;
            ArrayList<Boleatas> boletosVendidos = new ArrayList<>();

            while (i < baseDatosEventos.size()) {
                Evento evento = baseDatosEventos.get(i);
                if (evento.getNombre().equalsIgnoreCase(nombreEventoBus)) {
                    nombreUser = JOptionPane.showInputDialog("Nombre de usuario:");
                    documentoeUser = JOptionPane.showInputDialog("Documento de usuario:");
                    contrasenaUser = JOptionPane.showInputDialog("Contraseña de usuario:");

                    boolean usuarioExistente = false;
                    for (Usuario usuario : baseDatosUsuarios) {
                        if (usuario.getNombre().equals(nombreUser) && usuario.getContrasena().equals(contrasenaUser) && usuario.getDocumento().equals(documentoeUser)) {
                            apellidosUser = usuario.getApellidos();
                            correoUser = usuario.getCorreo();
                            usuarioExistente = true;
                            break;
                        }
                    }

                    if (!usuarioExistente) {
                        JOptionPane.showMessageDialog(null, "Usuario no existe");
                    } else {
                        int cobre = evento.getPrecioCobre();
                        int plata = evento.getPrecioPlata();
                        int oro = evento.getPrecioOro();

                        JOptionPane.showMessageDialog(null, "Bienvenido a la venta de boletos.");

                        while (true) {
                            String[] opciones = {"Cobre", "Plata", "Oro", "Salir"};
                            int opcion = JOptionPane.showOptionDialog(null,
                                    "¿Qué tipo de boleto desea comprar?\nCobre: " + evento.getCobreDispo() + ", Plata: " + evento.getPlataDispo() + ", Oro: " + evento.getOroDispo(),
                                    "Venta de boletos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                            if (opcion == 3) {
                                break; // Salir del bucle si el usuario elige "Salir"
                            }

                            String cantidadStr = JOptionPane.showInputDialog("¿Cuántos boletos desea comprar?");
                            if (cantidadStr == null) {
                                continue; // Si el usuario cancela la entrada de cantidad, continuar en el bucle
                            }

                            try {
                                int cantidad = Integer.parseInt(cantidadStr);

                                switch (opcion) {
                                    case 0:
                                        total += venderCobre(cantidad, cobre, evento, boletosVendidos);
                                        break;
                                    case 1:
                                        total += venderPlata(cantidad, plata, evento, boletosVendidos);
                                        break;
                                    case 2:
                                        total += venderOro(cantidad, oro, evento, boletosVendidos);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opción no válida");
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Ingrese un número válido para la cantidad de boletos.");
                            }
                        }
                        archivos.escribirArchivoEvents(baseDatosEventos); // Guardar los cambios
                        archivos.escribirArchivoBoletas(boletosVendidos); // Guardar los boletos vendidos
                        break; // Salir del bucle de eventos
                    }
                }
                i++;
            }
            return total;
        }

        private int venderCobre(int cantidad, int cobre, Evento evento, ArrayList<Boleatas> boletosVendidos) {
            int totalCobre = 0;
            if (cantidad <= evento.getCobreDispo()) {
                evento.setCobreDispo(evento.getCobreDispo() - cantidad);
                totalCobre = cantidad * cobre;
                String codigo;
                for (int i = 0; i < cantidad; i++) {
                    codigo = evento.getNombre() + "-C-" + (evento.getCobreDispo() + i + 1);
                    boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, correoUser, codigo));
                }

                JOptionPane.showMessageDialog(null, "Se han vendido " + cantidad + " boletos de cobre.");
            } else if (evento.getCobreDispo() == 0) {
                JOptionPane.showMessageDialog(null, "Ya no hay boletos cobre disponibles.");
            } else {
                JOptionPane.showMessageDialog(null, "Quedan " + evento.getCobreDispo() + " tiquetes cobre, su venta de " + cantidad + " tiquetes cobre fue rechazada.");
            }
            return totalCobre;
        }

        private int venderPlata(int cantidad, int plata, Evento evento, ArrayList<Boleatas> boletosVendidos) {
            int totalPlata = 0;
            if (cantidad <= evento.getPlataDispo()) {
                evento.setPlataDispo(evento.getPlataDispo() - cantidad);
                totalPlata = cantidad * plata;
                String codigo;
                for (int i = 0; i < cantidad; i++) {
                    codigo = evento.getNombre() + "-P-" + (evento.getPlataDispo() + i + 1);
                    boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, correoUser, codigo));
                }
                JOptionPane.showMessageDialog(null, "Se han vendido " + cantidad + " boletos de plata.");
            } else if (evento.getPlataDispo() == 0) {
                JOptionPane.showMessageDialog(null, "Ya no hay boletos plata disponibles.");
            } else {
                JOptionPane.showMessageDialog(null, "Quedan " + evento.getPlataDispo() + " tiquetes plata, su venta de " + cantidad + " tiquetes plata fue rechazada.");
            }
            return totalPlata;
        }

        private int venderOro(int cantidad, int oro, Evento evento, ArrayList<Boleatas> boletosVendidos) {
            int totalOro = 0;
            if (cantidad <= evento.getOroDispo()) {
                evento.setOroDispo(evento.getOroDispo() - cantidad);
                totalOro = cantidad * oro;
                String codigo;
                for (int i = 0; i < cantidad; i++) {
                    codigo = evento.getNombre() + "-O-" + (evento.getOroDispo() + i + 1);
                    boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, correoUser, codigo));
                }
                JOptionPane.showMessageDialog(null, "Se han vendido " + cantidad + " boletos de oro.");
            } else if (evento.getOroDispo() == 0) {
                JOptionPane.showMessageDialog(null, "Ya no hay boletos oro disponibles.");
            } else {
                JOptionPane.showMessageDialog(null, "Quedan " + evento.getOroDispo() + " tiquetes oro, su venta de " + cantidad + " tiquetes oro fue rechazada.");
            }
            return totalOro;
        }

    }
}

