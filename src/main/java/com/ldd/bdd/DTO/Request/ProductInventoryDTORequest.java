package com.ldd.bdd.DTO.Request;

public class ProductInventoryDTORequest {

    private int location;

    private int category;

    public ProductInventoryDTORequest() {
    }

    public ProductInventoryDTORequest(int location, int category) {
        this.location = location;
        this.category = category;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductInventoryDTORequest{" +
                "location=" + location +
                ", category=" + category +
                '}';
    }
}
