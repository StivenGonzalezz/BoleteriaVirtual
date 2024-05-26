package Logica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Taquilla {

    private static String nombreUser;
    private static String apellidosUser;
    private static String documentoeUser;
    private static String contrasenaUser;
    private static String CorreoUser;
    private static String codigoConcatenado="";

    public Taquilla() {

    }

    public int venderTiquetes(ArrayList<Evento> baseDatosEventos, ArrayList<Usuario> baseDatosUsuarios, Persistencia archivos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Cual es el nombre del evento al que quiere asistir:");
        String nombreEventoBus = scanner.nextLine();
        int i = 0;
        int total = 0;
        LocalTime horaResta;
        //Hora de apertura para el evento (quemada por el momento)
        LocalTime horaAper= LocalTime.of(22,59);
        LocalTime horaActual = LocalTime.now();
        ArrayList<Boleatas> boletosVendidos = new ArrayList<>();
        while (i < baseDatosEventos.size()) {
            Evento evento = baseDatosEventos.get(i);
            //RESTA una hora a la hora del evento para validar hasta que hora se puede acceder al evento
            horaResta = evento.getHora().minusHours(1);
            if (horaActual.isAfter(horaAper) && horaActual.isBefore(horaResta)) {
                System.out.println("Hora de entrada permitida");
                System.out.println("Hora: " + horaActual.getHour() + ":" + horaActual.getMinute() + " PM");
                if (evento.getNombre().equalsIgnoreCase(nombreEventoBus)) {
                    System.out.print("Nombre de usuario:");
                    nombreUser = scanner.nextLine();
                    System.out.print("Documento de usuario:");
                    documentoeUser = scanner.nextLine();
                    System.out.print("Contraseña de usuario:");
                    contrasenaUser = scanner.nextLine();

                    boolean usuarioExistente = false;
                    for (Usuario usuario : baseDatosUsuarios) {
                        if (usuario.getNombre().equals(nombreUser) && usuario.getContrasena().equals(contrasenaUser) && usuario.getDocumento().equals(documentoeUser)) {
                            apellidosUser = usuario.getApellidos();
                            CorreoUser = usuario.getCorreo();
                            usuarioExistente = true;
                            break;
                        }
                    }

                    if (!usuarioExistente) {
                        System.out.println("Usuario no existe");
                    } else if (usuarioExistente) {
                        int cobre = evento.getPrecioCobre();
                        int plata = evento.getPrecioPlata();
                        int oro = evento.getPrecioOro();
                        System.out.println("Bienvenido a la venta de boletos.");
                        total = 0;
                        int opcion = -1;
                        int cantidad = 0;

                        while (opcion != 0) {
                            System.out.println("¿Qué tipo de boleto desea comprar?");
                            System.out.println("Cobre:" + evento.getCobreDispo() + ", Plata:" + evento.getPlataDispo() + ", Oro:" + evento.getOroDispo());
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
                                    total += venderCobre(cantidad, cobre, evento, boletosVendidos);
                                    break;
                                case 2:
                                    total += venderPlata(cantidad, plata, evento, boletosVendidos);
                                    break;
                                case 3:
                                    total += venderOro(cantidad, oro, evento, boletosVendidos);
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }
                        }
                        archivos.escribirArchivoEvents(baseDatosEventos); // Guardar los cambios
                        archivos.escribirArchivoBoletas(boletosVendidos); // Guardar los boletos vendidos
                        break;
                    }
                }
                i++;
            }  else {
            System.out.println("Taquilla cerrada");
        }
        i++;
        }
            /**
            if (evento.getNombre().equalsIgnoreCase(nombreEventoBus)) {
                System.out.print("Nombre de usuario:");
                nombreUser = scanner.nextLine();
                System.out.print("Documento de usuario:");
                documentoeUser = scanner.nextLine();
                System.out.print("Contraseña de usuario:");
                contrasenaUser = scanner.nextLine();

                boolean usuarioExistente = false;
                for (Usuario usuario : baseDatosUsuarios) {
                    if (usuario.getNombre().equals(nombreUser) && usuario.getContrasena().equals(contrasenaUser) && usuario.getDocumento().equals(documentoeUser)) {
                        apellidosUser = usuario.getApellidos();
                        CorreoUser = usuario.getCorreo();
                        usuarioExistente = true;
                        break;
                    }
                }

                if (!usuarioExistente) {
                    System.out.println("Usuario no existe");
                } else if (usuarioExistente) {
                    int cobre = evento.getPrecioCobre();
                    int plata = evento.getPrecioPlata();
                    int oro = evento.getPrecioOro();
                    System.out.println("Bienvenido a la venta de boletos.");
                    total = 0;
                    int opcion = -1;
                    int cantidad = 0;

                    while (opcion != 0) {
                        System.out.println("¿Qué tipo de boleto desea comprar?");
                        System.out.println("Cobre:" + evento.getCobreDispo() + ", Plata:" + evento.getPlataDispo() + ", Oro:" + evento.getOroDispo());
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
                                total += venderCobre(cantidad, cobre, evento, boletosVendidos);
                                break;
                            case 2:
                                total += venderPlata(cantidad, plata, evento, boletosVendidos);
                                break;
                            case 3:
                                total += venderOro(cantidad, oro, evento, boletosVendidos);
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    archivos.escribirArchivoEvents(baseDatosEventos); // Guardar los cambios
                    archivos.escribirArchivoBoletas(boletosVendidos); // Guardar los boletos vendidos
                    break;
                }
            }
            i++;**/
          return total;
    }
        //return total;
    }

    private int venderCobre(int cantidad, int cobre, Evento evento, ArrayList<Boleatas> boletosVendidos) {
        int totalCobre = 0;
        if (cantidad <= evento.getCobreDispo()) {
            evento.setCobreDispo(evento.getCobreDispo() - cantidad);
            totalCobre = cantidad * cobre;
            String codigo;
            for (int i = 0; i < cantidad; i++) {
                codigo = evento.getNombre() + "-C-" + (evento.getCobreDispo() + i + 1);
                boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, CorreoUser, codigo));
            }

            System.out.println("Se han vendido " + cantidad + " boletos de cobre.");
        } else if (evento.getCobreDispo() == 0) {
            System.out.println("Ya no hay boletos cobre disponibles.");
        } else {
            System.out.println("Quedan " + evento.getCobreDispo() + " tiquetes cobre, su venta de " + cantidad + " tiquetes cobre fue rechazada.");
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
                boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, CorreoUser, codigo));
            }
            System.out.println("Se han vendido " + cantidad + " boletos de plata.");
        } else if (evento.getPlataDispo() == 0) {
            System.out.println("Ya no hay boletos plata disponibles.");
        } else {
            System.out.println("Quedan " + evento.getPlataDispo() + " tiquetes plata, su venta de " + cantidad + " tiquetes plata fue rechazada.");
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
                boletosVendidos.add(new Boleatas(nombreUser, apellidosUser, documentoeUser, contrasenaUser, CorreoUser, codigo));
            }
            System.out.println("Se han vendido " + cantidad + " boletos de oro.");
        } else if (evento.getOroDispo() == 0) {
            System.out.println("Ya no hay boletos oro disponibles.");
        } else {
            System.out.println("Quedan " + evento.getOroDispo() + " tiquetes oro, su venta de " + cantidad + " tiquetes oro fue rechazada.");
        }
        return totalOro;
    }
}
