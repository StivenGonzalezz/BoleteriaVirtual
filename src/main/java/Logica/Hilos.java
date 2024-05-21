package Logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Hilos implements Runnable {

    private int usuarioId;
    private Semaphore semaforo;
    private Semaphore semaforoScanner;
    private ArrayList<Evento> baseDatosEventos;

    public Hilos(int usuarioId, Semaphore semaforo, Semaphore semaforoScanner, ArrayList<Evento> baseDatosEventos) {
        this.usuarioId = usuarioId;
        this.semaforo = semaforo;
        this.semaforoScanner = semaforoScanner;
        this.baseDatosEventos = baseDatosEventos;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("Usuario " + usuarioId + " está comprando boletos.");


            // Asegura que solo un hilo accede al Scanner a la vez
            semaforoScanner.acquire();
            venderTiquetes(baseDatosEventos);
            semaforoScanner.release();

            System.out.println("Usuario " + usuarioId + " ha terminado de comprar.");
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int venderTiquetes(ArrayList<Evento> baseDatosEventos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuario " + usuarioId + ": ¿Cuál es el nombre del evento al que quiere asistir?");
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
                            total += venderCobre(cantidad, cobre, baseDatosEventos);
                            break;
                        case 2:
                            total += venderPlata(cantidad, plata, baseDatosEventos);
                            break;
                        case 3:
                            total += venderOro(cantidad, oro, baseDatosEventos);
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

    private int venderCobre(int cantidad, int cobre, ArrayList<Evento> baseDatosEventos) {
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

    private int venderPlata(int cantidad, int plata, ArrayList<Evento> baseDatosEventos) {
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

    private int venderOro(int cantidad, int oro, ArrayList<Evento> baseDatosEventos) {
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

    public static void main(String[] args) {
        ArrayList<Evento> baseDatosEventos = new ArrayList<>();

        String nombre1 = "concierto A";
        LocalDate fecha1 = LocalDate.parse("2024-12-12");
        LocalTime hora1 = LocalTime.parse("10:20");;
        String lugar1 = "calarca";
        String artistas1 = "nxxz";
        int precioCobre1 = 1500;
        int precioPlata1 = 2000;
        int precioOro1 = 2500;
        int capacidad1 = 1250;

        String nombre2 = "concierto B";
        LocalDate fecha2 = LocalDate.parse("2023-12-10");
        LocalTime hora2 = LocalTime.parse("08:20");;
        String lugar2 = "Armenia";
        String artistas2 = "War";
        int precioCobre2 = 2000;
        int precioPlata2 = 2500;
        int precioOro2 = 3000;
        int capacidad2 = 1500;

        //baseDatosEventos.add(new Evento(nombre1, fecha1, hora1, lugar1, artistas1, precioCobre1, precioPlata1, precioOro1, capacidad1));
        //baseDatosEventos.add(new Evento(nombre2, fecha2, hora2, lugar2, artistas2, precioCobre2, precioPlata2, precioOro2, capacidad2));


        Semaphore semaforo = new Semaphore(1);
        Semaphore semaforoScanner = new Semaphore(1);


        Hilos hilo1 = new Hilos(1, semaforo, semaforoScanner, baseDatosEventos);
        Hilos hilo2 = new Hilos(2, semaforo, semaforoScanner, baseDatosEventos);


        Thread thread1 = new Thread(hilo1);
        Thread thread2 = new Thread(hilo2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los usuarios han terminado de comprar.");
    }
}
