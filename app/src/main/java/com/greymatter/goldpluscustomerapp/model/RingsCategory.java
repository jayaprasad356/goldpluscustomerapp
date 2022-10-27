package com.greymatter.goldpluscustomerapp.model;

public class RingsCategory {
    public RingsCategory(String id, String category_name) {
        this.id = id;
        this.category_name = category_name;


    }

    String id,category_name;

    public RingsCategory() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
