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
public class Problema {

    private int idProblema;
    private Date fchIni;
    private Date fchFin;
    private String estado;
    private String direccion;
    private int idCliente;
    private String descripcion;

    public Problema() {
    }

    public Problema(int idProblema, Date fchIni, Date fchFin, String estado, String direccion, int idCliente, String descripcion) {
        this.idProblema = idProblema;
        this.fchIni = fchIni;
        this.fchFin = fchFin;
        this.estado = estado;
        this.direccion = direccion;
        this.idCliente = idCliente;
        this.descripcion = descripcion;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public Date getFchIni() {
        return fchIni;
    }

    public void setFchIni(Date fchIni) {
        this.fchIni = fchIni;
    }

    public Date getFchFin() {
        return fchFin;
    }

    public void setFchFin(Date fchFin) {
        this.fchFin = fchFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Problema{" + "idProblema=" + idProblema + ", fchIni=" + fchIni + ", fchFin=" + fchFin + ", estado=" + estado + ", direccion=" + direccion + ", idCliente=" + idCliente + ", descripcion=" + descripcion + '}';
    }

}
