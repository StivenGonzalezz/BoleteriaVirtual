package Logica;

import Logica.Boletera;
import Logica.Evento;
import Logica.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Opciones {
    private int opcion = -1;
   // ArrayList<Evento> baseDatosEventos = new ArrayList<>();
    ArrayList<Usuario> baseDatosUsuarios = new ArrayList<>();
    Evento evento =new Evento("perros criollos","12/09/2024","atanasio","perros criollos",150000,200000,250000,1250);

    Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        while (opcion != 0) {
            System.out.println("");
            System.out.println("Ingreso");
            System.out.println("");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            System.out.println("");
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                case 1:
                    ingresoUsuario();
                    break;
                case 2:
                    // Agrega aquí la lógica para el caso 2 (Administrador)
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese una opción válida");
            }
        }
        scanner.close();
    }

    private void ingresoUsuario(){

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("Panel Usuario");
            System.out.println("");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Comprar boletas");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    usuario();
                    break;
                case 2:
                    boletas();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void boletas() {


    }

    private void usuario(){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Actualizar Estudiante");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("0. Volver");
            System.out.println("");
            System.out.print("Ingrese su opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.print("Nombre:");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos:");
                    String apellidos = scanner.nextLine();
                    System.out.print("Documento:");
                    String documento = scanner.next();
                    System.out.print("Edad:");
                    String edad = scanner.next();
                    baseDatosUsuarios.add(new Usuario("Pepe","Salazar","1234","0000","julianandresnaranjoalzate@gmail.com"));
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}