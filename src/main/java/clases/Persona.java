package clases;

public class Persona {
    private String nombre;
    private String apellidos;
    private String documento;

    public Persona(String nombre, String apellidos, String documento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setIDocumento(String documento) {
        this.documento = documento;
    }
}
