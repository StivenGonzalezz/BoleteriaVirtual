package clases;

public class Materia {

    private String nombre;
    private String codigo;
    private int capacidadMax;

    public Materia(String nombre, String codigo, String capacidadMax) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidadMax = Integer.parseInt(capacidadMax);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

}
