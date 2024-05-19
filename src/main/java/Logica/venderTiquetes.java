package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Taquilla {

    public Taquilla() {

    }

    public  int venderTiquetes(ArrayList<Evento> baseDatosEventos) {
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
}
