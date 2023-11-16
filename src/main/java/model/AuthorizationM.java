package model;


/*package model;

/**
 *
 * @author sardineta_fresca
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sardineta_fresca
 */
// Classe que actua com a gestor del token d'autenticació (Singleton)
public class AuthorizationM {

    // Atributs privats per emmagatzemar el nom d'usuari i el token
    private String username;
    private String token;

    // Instància singleton
    private static AuthorizationM instance;

    // Constructor privat
    private AuthorizationM() {
    }

    // Mètode estàtic públic per obtenir la instància singleton
    public static AuthorizationM getInstance() {
        if (instance == null) {
            instance = new AuthorizationM();
        }
        return instance;
    }

    // Mètodes getters i setters per als atributs de la classe
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Override del mètode toString per obtenir una representació en cadena de l'objecte
    @Override
    public String toString() {
        return "Credentials{"
                + "username='" + username + '\''
                + ", token=" + token
                + '}';
    }

}
