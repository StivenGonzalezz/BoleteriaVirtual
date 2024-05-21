package Logica;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String documento;
    private String contrasena;
    private String correo;

    public Usuario(String nombre, String apellidos, String documento, String contrasena, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }public String getApellidos() {
        return apellidos;
    }public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }public String getDocumento() {
        return documento;
    }public void setDocumento(String documento) {
        this.documento = documento;
    }public String getContrasena() {
        return contrasena;
    }public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }public String getCorreo() {
        return correo;
    }public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String toFileString() {
        return nombre + "," + apellidos + "," + documento + "," + contrasena + "," + correo;
    }
}