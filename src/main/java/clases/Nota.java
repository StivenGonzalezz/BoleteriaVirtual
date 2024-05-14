package clases;

public class Nota {
    public String nota;

    public Nota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nota;
    }
}
