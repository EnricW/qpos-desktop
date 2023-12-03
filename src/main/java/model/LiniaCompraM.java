package model;

/**
 *
 * @author Enric
 */
public class LiniaCompraM {

    private int producte;
    private int quantitat;

    public LiniaCompraM(int producte, int quantitat) {
        this.producte = producte;
        this.quantitat = quantitat;
    }

    public LiniaCompraM() {

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
