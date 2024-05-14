package clases;

public class Estudiante extends Persona{
    private int edad;

    public Estudiante(String nombre, String apellidos, String documento, String edad) {
        super(nombre, apellidos, documento);
        this.edad = Integer.parseInt(edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}