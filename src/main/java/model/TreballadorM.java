package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author Enric
 */
public class TreballadorM {

    private String user;
    private String username;
    private String password;
    private String password2;
    private String nom;
    private String cognoms;
    private String email;
    private String dni;
    private String bio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNaixement;

    private String telefon;
    private String imatge;

    // Constructors, getters, and setters
    public TreballadorM() {
    }

    public TreballadorM(String user, String username, String password, String password2, String nom, String cognoms,
            String email, String dni, String bio, Date dataNaixement, String telefon, String imatge) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.dni = dni;
        this.bio = bio;
        this.dataNaixement = dataNaixement;
        this.telefon = telefon;
        this.imatge = imatge;
    }

    // Add getters and setters for each field
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    /**
     * Override del mètode toString per obtenir una representació en cadena de
     * l'objecte
     *
     * @return
     */
    @Override
    public String toString() {
        return "Treballador amd user " + user
                + ", amb username " + username
                + ", amb password " + password
                + ", amb password2 " + password2
                + ", amb dni " + dni
                + ", amb nom " + nom
                + ", amb cognoms " + cognoms
                + ", amb telefon " + telefon
                + ", amb mail " + email
                + ", amb data " + dataNaixement
                + ", amb bio " + bio
                + ", imatge " + imatge;
    }
}
