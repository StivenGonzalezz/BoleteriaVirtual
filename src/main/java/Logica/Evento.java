package Logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String artista;
    private int precioCobre;
    private int precioPlata;
    private int precioOro;
    private int canEscenario;
    private int cobreDispo;
    private int plataDispo;
    private int oroDispo;

    public Evento(String nombre, LocalDate fecha, LocalTime hora, String lugar, String artista, int precioCobre, int precioPlata, int precioOro, int canEscenario) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.artista = artista;
        this.precioCobre = precioCobre;
        this.precioPlata = precioPlata;
        this.precioOro = precioOro;
        this.canEscenario = canEscenario;
        this.cobreDispo = (int) (canEscenario * 0.6);
        this.plataDispo = (int) (canEscenario * 0.3);
        this.oroDispo = (int) (canEscenario * 0.1);
    }

    public String getNombre() {
        return nombre;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }public LocalDate getFecha() {
        return fecha;
    }public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }public LocalTime getHora() {
        return hora;
    }public void setHora(LocalTime hora) {
        this.hora = hora;
    }public String getLugar() {
        return lugar;
    }public void setLugar(String lugar) {
        this.lugar = lugar;
    }public String getArtista() {
        return artista;
    }public void setArtista(String artista) {
        this.artista = artista;
    }public int getPrecioCobre() {
        return precioCobre;
    }public void setPrecioCobre(int precioCobre) {
        this.precioCobre = precioCobre;
    }public int getPrecioPlata() {
        return precioPlata;
    }public void setPrecioPlata(int precioPlata) {
        this.precioPlata = precioPlata;
    }public int getPrecioOro() {
        return precioOro;
    } public void setPrecioOro(int precioOro) {
        this.precioOro = precioOro;
    } public int getCanEscenario() {
        return canEscenario;
    }public void setCanEscenario(int canEscenario) {
        this.canEscenario = canEscenario;
    } public int getCobreDispo() {
        return cobreDispo;
    } public void setCobreDispo(int cobreDispo) {
        this.cobreDispo = cobreDispo;
    }public int getPlataDispo() {
        return plataDispo;
    }public void setPlataDispo(int plataDispo) {
        this.plataDispo = plataDispo;
    }public int getOroDispo() {
        return oroDispo;
    }public void setOroDispo(int oroDispo) {
        this.oroDispo = oroDispo;
    }

    public String toFileString() {
        return nombre+","+fecha+","+hora+","+lugar+","+artista+","+precioCobre+","+precioPlata+","+precioOro+","+canEscenario;
    }
}
