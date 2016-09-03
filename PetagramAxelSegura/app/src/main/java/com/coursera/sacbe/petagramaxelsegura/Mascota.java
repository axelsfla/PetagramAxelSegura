package com.coursera.sacbe.petagramaxelsegura;

/**
 * Created by Sacbe on 03/09/2016.
 */
public class Mascota {
    private String nombre;
    private String raza;
    private int raiting;
    private int foto;

    public Mascota(int foto, String nombre, String raza) {
        this.foto  = foto;
        this.nombre = nombre;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
