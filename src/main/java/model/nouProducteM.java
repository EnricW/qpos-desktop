/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sardineta_fresca
 */
public class nouProducteM {

    private int proveidor_id;
    private String nom;
    private String descripcio;
    private double preu;
    private String codiBarres;
    private int estoc;

    public nouProducteM() {
    }

    public int getProveidor_id() {
        return proveidor_id;
    }

    public void setProveidor_id(int proveidor_id) {
        this.proveidor_id = proveidor_id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    public int getEstoc() {
        return estoc;
    }

    public void setEstoc(int estoc) {
        this.estoc = estoc;
    }

}
