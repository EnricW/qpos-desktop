package model;

import java.util.List;

/**
 *
 * @author Enric
 */
public class CompraM {

    private int client_id;
    private int treballador_id;
    private List<LiniaCompraM> linies;

    public CompraM(int client_id, int treballador_id, List<LiniaCompraM> linies) {
        this.client_id = client_id;
        this.treballador_id = treballador_id;
        this.linies = linies;
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

    public List<LiniaCompraM> getLinies() {
        return linies;
    }

    public void setLinies(List<LiniaCompraM> linies) {
        this.linies = linies;
    }

}
