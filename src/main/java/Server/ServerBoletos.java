package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBoletos {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8090)) {
            System.out.println("Esperando conexiones....");
            while (true) {
                Socket cliente = server.accept();
                DataInputStream dataInputStream = new DataInputStream(cliente.getInputStream());
                String nombre = dataInputStream.readUTF();
                System.out.printf("Usuario %s conectado\n", nombre);
                //new WorkerSocket(cliente, nombre).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}






