package Logica;

public class Boleatas extends Usuario{
    private String codigoBoletas;


    public Boleatas(String nombre, String apellidos, String documento, String contrasena, String correo, String codigoBoletas) {
        super(nombre, apellidos, documento, contrasena, correo);
        this.codigoBoletas = codigoBoletas;
    }

    public String getCodigoBoletas() {
        return codigoBoletas;
    }

    public void setCodigoBoletas(String codigoBoletas) {
        this.codigoBoletas = codigoBoletas;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + codigoBoletas;
    }
}

