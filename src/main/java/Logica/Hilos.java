package Logica;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Hilos extends Thread {
    private final Semaphore semaphore;
    private final int id;
    private static final AtomicInteger waitingCount = new AtomicInteger(0);
    private static String nombreUser;
    private static String apellidosUser;
    private static String documentoeUser;
    private static String contrasenaUser;
    private static String correoUser;

    public Hilos(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + id + " está esperando en fila");
        int waiting = waitingCount.incrementAndGet();
        System.out.println("Clientes esperando: " + waiting);

        try {
            semaphore.acquire();
            waiting = waitingCount.decrementAndGet();
            System.out.println("Clientes esperando: " + waiting);

            System.out.println("Cliente " + id + " está en la ventanilla");

            // Proporcionar instancias de las bases de datos y la persistencia
            Persistencia archivos = new Persistencia();
            ArrayList<Evento> baseDatosEventos = archivos.leerArchivoEvents();
            ArrayList<Usuario> baseDatosUsuarios = archivos.leerArchivoUsers();

            int total = venderTiquetes(baseDatosEventos, baseDatosUsuarios, archivos);
            System.out.println("Total vendido por Cliente " + id + ": " + total);
            System.out.println("Cliente " + id + " ha salido de la ventanilla");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int venderTiquetes(ArrayList<Evento> baseDatosEventos, ArrayList<Usuario> baseDatosUsuarios, Persistencia archivos) {
        String nombreEventoBus = JOptionPane.showInputDialog("Cual es el nombre del evento al que quiere asistir:");
        int i = 0;
        int total = 0;
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
                    total = 0;
                    int opcion = -1;
                    int cantidad = 0;

                    while (opcion != 0) {
                        String[] options = {"Cobre", "Plata", "Oro", "Salir"};
                        opcion = JOptionPane.showOptionDialog(null, "¿Qué tipo de boleto desea comprar?\nCobre: " + evento.getCobreDispo() + ", Plata: " + evento.getPlataDispo() + ", Oro: " + evento.getOroDispo(), "Venta de boletos",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        if (opcion != 3) {
                            String cantidadStr = JOptionPane.showInputDialog("¿Cuántos boletos desea comprar?");
                            cantidad = Integer.parseInt(cantidadStr);
                        }

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
                            case 3:
                                opcion = 0;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida");
                                break;
                        }
                    }
                    archivos.escribirArchivoEvents(baseDatosEventos); // Guardar los cambios
                    archivos.escribirArchivoBoletas(boletosVendidos); // Guardar los boletos vendidos
                    break;
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

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            new Thread(new Hilos(semaphore, i)).start();
        }
    }
}