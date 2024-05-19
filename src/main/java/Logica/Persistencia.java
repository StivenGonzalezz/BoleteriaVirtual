package Logica;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Persistencia {

    File archivoEvents;
    File achivoUsers;

    public void crearArchivoTexto() {
        archivoEvents = new File("src\\main\\java\\DataBase\\archivoEvents.txt");
        achivoUsers = new File("src\\main\\java\\DataBase\\archivoUsers.txt");
        try {
            if (archivoEvents.createNewFile() && achivoUsers.createNewFile()) {
                System.out.println("se crearon los archivos");
            } else {
                System.out.println("error en la creacion de los archivos");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public void escribirArchivoEvents(ArrayList<Evento> baseDatosEventos) {
        try {
            FileWriter escritura = new FileWriter("src\\main\\java\\DataBase\\archivoEvents.txt", false);// si se pone en true no se borra lo del txt
            BufferedWriter bufferEscritura = new BufferedWriter(escritura);
            for (Evento evento : baseDatosEventos) {
                bufferEscritura.write(evento.toFileString() + "\n");
            }
            bufferEscritura.close();
            System.out.println("Eventos escritos en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("Error al escribir los Eventos en el archivo.");
        }
    }

    public void escribirArchivoUsers(ArrayList<Usuario> baseDatosUsuarios) {
        try {
            FileWriter escritura = new FileWriter("src\\main\\java\\DataBase\\archivoUsers.txt", false);
            BufferedWriter bufferEscritura = new BufferedWriter(escritura);
            for (Usuario usuario : baseDatosUsuarios) {
                bufferEscritura.write(usuario.toFileString() + "\n");
            }
            bufferEscritura.close();
            System.out.println("Usuarios escritos en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("Error al escribir los usuarios en el archivo.");
        }
    }

    public ArrayList<Evento> leerArchivoEvents() {
        ArrayList<Evento> eventos = new ArrayList<>();
        String archivoEventos = "src\\main\\java\\DataBase\\archivoEvents.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEventos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 9) {
                    String nombre = campos[0];
                    LocalDate fecha = LocalDate.parse(campos[1]);
                    LocalTime hora = LocalTime.parse(campos[2]);
                    String lugar = campos[3];
                    String artista = campos[4];
                    int precioCobre = Integer.parseInt(campos[5]);
                    int precioPlata = Integer.parseInt(campos[6]);
                    int precioOro = Integer.parseInt(campos[7]);
                    int canEscenario = Integer.parseInt(campos[8]);
                    eventos.add(new Evento(nombre, fecha, hora, lugar, artista, precioCobre, precioPlata, precioOro, canEscenario));
                }
            }
        }catch (IOException e) {
            System.err.println("Error al leer el archivo: " + archivoEventos);
            e.printStackTrace();
        }
        return eventos;
    }

    public  ArrayList<Usuario> leerArchivoUsers() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String archivoUsuarios = "src\\main\\java\\DataBase\\archivoUsers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombre = campos[0];
                String apellidos = campos[1];
                String documento = campos[2];
                String contrasena = campos[3];
                String correo = campos[4];
                usuarios.add(new Usuario(nombre, apellidos, documento, contrasena, correo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
