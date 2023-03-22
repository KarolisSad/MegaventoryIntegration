package com.application.DTO;

public class RelationDTO {

    private String clientName;
    private String productSKU;
    private String supplierName;

    public RelationDTO(String clientName, String productSKU, String supplierName) {
        this.clientName = clientName;
        this.productSKU = productSKU;
        this.supplierName = supplierName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierName = supplierEmail;
    }
}
