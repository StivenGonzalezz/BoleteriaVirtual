package Logica;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TaqullaVirtual implements Runnable{
    /**public  int venderTiquetes(ArrayList<Evento> baseDatosEventos) {
      LocalTime horaAper = LocalTime.of(7,30);
      LocalTime horaCierre=LocalTime.of(8,22); //ponerlo a una hora del evento
      LocalTime horaValidar= baseDatosEventos.get(1).getHora();
      if (horaValidar.isAfter(horaAper) && horaValidar.isBefore(horaCierre)){
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

      }else if(horaValidar.isBefore(horaCierre)){
          System.out.println("El evento ya no se encuentra disponible :(");
      }
    return total;
    }
     **/


@Override
    public void run() {

    }
}
