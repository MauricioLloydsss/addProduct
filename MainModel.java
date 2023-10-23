package com.example.addproduct;

public class MainModel {

    String id, name, qty, turl;

    MainModel()
    {

    }
    public MainModel(String id, String name, String qty, String turl) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.turl = turl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}
