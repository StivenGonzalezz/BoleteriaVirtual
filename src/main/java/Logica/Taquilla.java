package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Taquilla {

    public Taquilla() {

    }

    public int venderTiquetes(ArrayList<Evento> baseDatosEventos, Persistencia archivos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cual es el nombre del evento al que quiere asistir:");
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
                    System.out.println("Cobre:"+evento.getCobreDispo()+", Plata:"+evento.getPlataDispo()+", Oro:"+evento.getOroDispo());
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
                        case 0:
                            break;
                        case 1:
                            total += venderCobre(cantidad, cobre, baseDatosEventos);
                            break;
                        case 2:
                            total += venderPlata(cantidad, plata, baseDatosEventos);
                            break;
                        case 3:
                            total += venderOro(cantidad, oro, baseDatosEventos);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                }
                archivos.escribirArchivoEvents(baseDatosEventos); // Guardar los cambios
                break;
            }
            i++;
        }
        return total;
    }

    private static int venderCobre(int cantidad, int cobre, ArrayList<Evento> baseDatosEventos) {
        int totalCobre = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getCobreDispo()) {
                evento.setCobreDispo(evento.getCobreDispo() - cantidad);
                totalCobre = cantidad * cobre;
                System.out.println("Se han vendido " + cantidad + " boletos de cobre.");
            } else if (evento.getCobreDispo() == 0) {
                System.out.println("Ya no hay boletos cobre disponibles.");
            } else {
                System.out.println("Quedan " + evento.getCobreDispo() + " tiquetes cobre, su venta de " + cantidad + " tiquetes cobre fue rechazada.");
            }
        }
        return totalCobre;
    }

    private static int venderPlata(int cantidad, int plata, ArrayList<Evento> baseDatosEventos) {
        int totalPlata = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getPlataDispo()) {
                evento.setPlataDispo(evento.getPlataDispo() - cantidad);
                totalPlata = cantidad * plata;
                System.out.println("Se han vendido " + cantidad + " boletos de plata.");
            } else if (evento.getPlataDispo() == 0) {
                System.out.println("Ya no hay boletos plata disponibles.");
            } else {
                System.out.println("Quedan " + evento.getPlataDispo() + " tiquetes plata, su venta de " + cantidad + " tiquetes plata fue rechazada.");
            }
        }
        return totalPlata;
    }

    private static int venderOro(int cantidad, int oro, ArrayList<Evento> baseDatosEventos) {
        int totalOro = 0;
        for (Evento evento : baseDatosEventos) {
            if (cantidad <= evento.getOroDispo()) {
                evento.setOroDispo(evento.getOroDispo() - cantidad);
                totalOro = cantidad * oro;
                System.out.println("Se han vendido " + cantidad + " boletos de oro.");
            } else if (evento.getOroDispo() == 0) {
                System.out.println("Ya no hay boletos oro disponibles.");
            } else {
                System.out.println("Quedan " + evento.getOroDispo() + " tiquetes oro, su venta de " + cantidad + " tiquetes oro fue rechazada.");
            }
        }
        return totalOro;
    }
}