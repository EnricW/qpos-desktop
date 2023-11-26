package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Enric
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EsdevenimentM {
    private int id;
    private String nom;
    private String descripcio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
    private Date dataCreacio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
    private Date data;

    private int aforament;
    private String durada;
    private String ubicacio;
    private CreadorM creador;
    private List<AssistenciaM> assistencies; 

    public EsdevenimentM() {
    }

    
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

    public Date getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(Date dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public String getDurada() {
        return durada;
    }

    public void setDurada(String durada) {
        this.durada = durada;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public CreadorM getCreador() {
        return creador;
    }

    public void setCreador(CreadorM creador) {
        this.creador = creador;
    }

    public List<AssistenciaM> getAssistencies() {
        return assistencies;
    }

    public void setAssistencies(List<AssistenciaM> assistencies) {
        this.assistencies = assistencies;
    }
    
     /**
     * Atribut per emmagatzemar una llista d'esdeveniments
     */
    private EsdevenimentM[] esdeveniments;

    /**
     * Constructor que rep una llista d'esdeveniments
     * @param esdeveniments
     */
    public EsdevenimentM(EsdevenimentM[] esdeveniments) {
        this.esdeveniments = esdeveniments;
    }

    /**
     * Mètode per obtenir la llista d'esdeveniments
     * @return
     */
    public EsdevenimentM[] getEsdeveniments() {
        return esdeveniments;
    }
    
}
