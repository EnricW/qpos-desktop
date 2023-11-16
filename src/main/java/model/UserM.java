/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sardineta_fresca
 */
public class UserM {

    // Atributs de la classe que representen les dades de l'usuari
    private String username;
    private String password;
    private String token;
    private Boolean isAdmin;

    // Constructor amb paràmetres per establir el nom d'usuari i la contrasenya
    public UserM(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructor buit per a la deserialització JSON
    // Pot ser utilitzat pel mapeig de les respostes del servidor a aquest objecte
    public UserM() {
    }

    // Mètodes getters i setters per als atributs de la classe
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
