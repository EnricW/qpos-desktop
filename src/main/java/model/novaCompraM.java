package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Enric
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class novaCompraM {

    private int client_id;
    private int treballador_id;
    private List<novaLiniaCompraM> linies;
    private String metodePagament;
    private double dinersEntregats;
    private double dinersCanvi;
    private double descompte;
    
    public novaCompraM() {
    }

    public novaCompraM(int client_id, int treballador_id, List<novaLiniaCompraM> linies, String metodePagament, double dinersEntregats, double dinersCanvi, double descompte) {
        this.client_id = client_id;
        this.treballador_id = treballador_id;
        this.linies = linies;
        this.metodePagament = metodePagament;
        this.dinersEntregats = dinersEntregats;
        this.dinersCanvi = dinersCanvi;
        this.descompte = descompte;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getTreballador_id() {
        return treballador_id;
    }

    public void setTreballador_id(int treballador_id) {
        this.treballador_id = treballador_id;
    }

    public List<novaLiniaCompraM> getLinies() {
        return linies;
    }

    public void setLinies(List<novaLiniaCompraM> linies) {
        this.linies = linies;
    }

    public String getMetodePagament() {
        return metodePagament;
    }

    public void setMetodePagament(String metodePagament) {
        this.metodePagament = metodePagament;
    }

    public double getDinersEntregats() {
        return dinersEntregats;
    }

    public void setDinersEntregats(double dinersEntregats) {
        this.dinersEntregats = dinersEntregats;
    }

    public double getDinersCanvi() {
        return dinersCanvi;
    }

    public void setDinersCanvi(double dinersCanvi) {
        this.dinersCanvi = dinersCanvi;
    }

    public double getDescompte() {
        return descompte;
    }

    public void setDescompte(double descompte) {
        this.descompte = descompte;
    }

    
}
