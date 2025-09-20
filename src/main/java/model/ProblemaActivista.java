/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */
public class ProblemaActivista {
    private int idProblema;
    private int idActivista;

    public ProblemaActivista() {
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public int getIdActivista() {
        return idActivista;
    }

    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    @Override
    public String toString() {
        return "ProblemaActivista{" +
                "idActivista=" + idActivista +
                ", idProblema=" + idProblema +
                '}';
    }
}
