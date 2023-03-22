package com.application.DTO;

public class ProductDTO {

    private String SKU;
    private String description;
    private double salesPrice;
    private double purchasePrice;

    public ProductDTO(String SKU, String description, double salesPrice, double purchasePrice) {
        this.SKU = SKU;
        this.description = description;
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
    }

    public String getSKU() {
        return SKU;
    }

    public String getDescription() {
        return description;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
}
