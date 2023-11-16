/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author sardineta_fresca
 */
// Annotació per ignorar propietats desconegudes durant la deserialització JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProducteM {

    // Atributs de la classe que representen les dades del producte
    private int id;
    private ProveidorM proveidor;
    private String nom;
    private String descripcio;
    private Number preu;
    private String codiBarres;
    private int estoc;
    private String imatge;

    // Constructor buit per a la deserialització JSON
    public ProducteM() {
    }

    // Mètodes getters i setters per als atributs de la classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProveidorM getProveidor() {
        return proveidor;
    }

    public void setProveidor(ProveidorM proveidor) {
        this.proveidor = proveidor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String value) {
        this.descripcio = value;
    }

    public Number getPreu() {
        return preu;
    }

    public void setPreu(Number value) {
        this.preu = value;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(String value) {
        this.codiBarres = value;
    }

    public int getEstoc() {
        return estoc;
    }

    public void setEstoc(int value) {
        this.estoc = value;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String value) {
        this.imatge = value;
    }

    @Override
    public String toString() {
        return "Producte amd id " + id
                + ", amb proveidor " + proveidor
                + ", amb nom " + nom
                + ", descripcio " + descripcio
                + ", amb preu " + preu
                + ", codi de barres " + codiBarres
                + ", amb estoc de " + estoc;
    }

    // Atribut per emmagatzemar una llista de productes
    private ProducteM[] productes;

    // Constructor que rep una llista de productes
    public ProducteM(ProducteM[] productes) {
        this.productes = productes;
    }

    // Mètode per obtenir la llista de productes
    public ProducteM[] getProductes() {
        return productes;
    }

}
