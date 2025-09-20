/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Activista {
    private int idActivista;
    private String nombre;
    private String telefono;
    private Date fchIngreso;

    public Activista() {
    }

    public Activista(int idActivista, String nombre, String telefono, Date fchIngreso) {
        this.idActivista = idActivista;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fchIngreso = fchIngreso;
    }

    public Date getFchIngreso() {
        return fchIngreso;
    }

    public void setFchIngreso(Date fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    public int getIdActivista() {
        return idActivista;
    }

    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Activista{" +
                "fchIngreso=" + fchIngreso +
                ", idActivista=" + idActivista +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}