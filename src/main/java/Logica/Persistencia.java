package Logica;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    File archivoEvents;
    File achivoUsers;

    public void crearArchivoTexto(){
        archivoEvents = new File("archivoEvents.txt");
        achivoUsers  = new File("achivoUsers.txt");
        try {
            if(archivoEvents.createNewFile() && achivoUsers.createNewFile()){
                System.out.println("se crearon los archivos");
            }else {
                System.out.println("error en la creacion de los archivos");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public void escribirArchivoEvents(ArrayList<Evento> baseDatosEventos, String msg){
        try{
            FileWriter escritura = new FileWriter("archivoEvents.txt",true);// si se pone en true no se borra lo del txt
            escritura.write(msg);
            escritura.close();
            System.out.println("texto añadido");
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public void escribirArchivoUsers(ArrayList<Usuario> baseDatosUsuarios) {
        try {
            FileWriter escritura = new FileWriter("achivoUsers.txt", true);
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

    public void leerArchivoUsers() {
        try {
            FileReader archivo = new FileReader("achivoUsers.txt");
            BufferedReader lector = new BufferedReader(archivo);
            String linea;

            System.out.println("Usuarios almacenados en el archivo:");

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("Error al leer el archivo de usuarios.");
        }
    }
}
