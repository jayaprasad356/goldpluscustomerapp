package com.greymatter.goldpluscustomerapp.model;


import java.io.Serializable;

public class SelectedRingList implements Serializable {
    String id,ring_img,weight,size;


    public SelectedRingList() {
    }

    public SelectedRingList(String id, String ring_img, String weight, String size) {
        this.id = id;
        this.ring_img = ring_img;
        this.weight = weight;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRing_img() {
        return ring_img;
    }

    public void setRing_img(String ring_img) {
        this.ring_img = ring_img;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
