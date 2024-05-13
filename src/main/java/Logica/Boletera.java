package Logica;

import java.util.Scanner;

public class Boletera {

    private int canCobre;
    private int canPlata;
    private int canOro;

    public Boletera(int canCobre, int canPlata, int canOro) {
        this.canCobre = canCobre;
        this.canPlata = canPlata;
        this.canOro = canOro;
    }


    public int ventaBoletos(int cobre,int plata,int oro){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la venta de boletos.");

        int total=0;
        int opcion = -1;
        int cantidad=0;
        while (opcion != 0) {
            System.out.println("¿Qué tipo de boleto desea comprar?");
            System.out.println("1. Cobre");
            System.out.println("2. Plata");
            System.out.println("3. Oro");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            if(opcion != 0){
                System.out.println("¿Cuántos boletos desea comprar?");
                cantidad = scanner.nextInt();
            }
            switch (opcion) {
                case 1:
                    total=total+venderCobre(cantidad,cobre);
                    break;
                case 2:
                    total=total+venderPlata(cantidad,plata);
                    break;
                case 3:
                    total=total+venderOro(cantidad,oro);
                    break;
                case 0:
                    opcion=0;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        return total;
    }

    private int venderCobre(int cantidad,int cobre) {
        int totalCobre=0;
        if (cantidad <= canCobre) {
            canCobre -= cantidad;
            totalCobre = cantidad * cobre;
            System.out.println("Se han vendido " + cantidad + " boletos cobre");
        } else if (canCobre > 0) {
            System.out.println("solo quedan " + canCobre + " boletos cobre disponibles");
        } else {
            System.out.println("ya no hay boletos cobre disponibles");
        }
        return totalCobre;
    }

    private int venderPlata(int cantidad,int plata) {
        int totalPlata=0;
        if (cantidad <= canPlata) {
            canPlata -= cantidad;
            totalPlata += cantidad*plata;
            System.out.println("Se han vendido " + cantidad + " boletos de plata.");
        } else if(canPlata>0){
            System.out.println("solo quedan " +canPlata+" boletos cobre disponibles");
        } else {
            System.out.println("ya no hay boletos plata disponibles");
        }
        return totalPlata;
    }

    private int venderOro(int cantidad,int oro) {
        int totalOro=0;
        if (cantidad <= canOro) {
            canOro -= cantidad;
            totalOro+= cantidad*oro;
            System.out.println("Se han vendido " + cantidad + " boletos de oro.");
        } else if(canOro>0){
            System.out.println("solo quedan " +canOro+" boletos cobre disponibles");
        } else {
            System.out.println("ya no hay boletos oro disponibles");
        }
        return totalOro;
    }

    public int getCanCobre() {
        return canCobre;
    }public void setCanCobre(int canCobre) {
        this.canCobre = canCobre;
    }public int getCanPlata() {
        return canPlata;
    }public void setCanPlata(int canPlata) {
        this.canPlata = canPlata;
    }public int getCanOro() {
        return canOro;
    }public void setCanOro(int canOro) {
        this.canOro = canOro;
    }
}