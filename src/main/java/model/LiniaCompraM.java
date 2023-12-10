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
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiniaCompraM {

    private int id;
    private ProducteM producte;
    private int quantitat;
    private int compra;

    public LiniaCompraM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProducteM getProducte() {
        return producte;
    }

    public void setProducte(ProducteM producte) {
        this.producte = producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }
}
