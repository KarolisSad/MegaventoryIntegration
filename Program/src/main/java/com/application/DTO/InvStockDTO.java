package com.application.DTO;

public class InvStockDTO {

    private String productSKU;
    private int productQuantity;
    private String abbreviation;

    public InvStockDTO(String productSKU, int productQuantity, String inventoryLocationID) {
        this.productSKU = productSKU;
        this.productQuantity = productQuantity;
        abbreviation = inventoryLocationID;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
