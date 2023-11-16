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
public class ProveidorM {
    // Atributs de la classe que representen les dades del proveïdor
    private int id;
    private String nom;
    private String descripcio;

    // Mètodes getters i setters per als atributs de la classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    // Mètode toString per obtenir una representació en cadena de l'objecte
    @Override
    public String toString() {
        return "Proveidor [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + "]";
    }
}
