package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Enric
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class novaLiniaCompraM {

    private int producte;
    private int quantitat;

    public novaLiniaCompraM(int producte, int quantitat) {
        this.producte = producte;
        this.quantitat = quantitat;
    }

    public novaLiniaCompraM() {

    }

    public int getProducte() {
        return producte;
    }

    public void setProducte(int producte) {
        this.producte = producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

}
