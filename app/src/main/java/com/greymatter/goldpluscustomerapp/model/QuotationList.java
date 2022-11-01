package com.greymatter.goldpluscustomerapp.model;


import java.io.Serializable;

public class QuotationList implements Serializable {
    String id,pieces,sub_category,gross_weight,touch,purity;

    public QuotationList(String id, String pieces, String sub_category, String gross_weight, String touch, String purity) {
        this.id = id;
        this.pieces = pieces;
        this.sub_category = sub_category;
        this.gross_weight = gross_weight;
        this.touch = touch;
        this.purity = purity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    public String getGross_weight() {
        return gross_weight;
    }

    public void setGross_weight(String gross_weight) {
        this.gross_weight = gross_weight;
    }

    public String getTouch() {
        return touch;
    }

    public void setTouch(String touch) {
        this.touch = touch;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }
}
