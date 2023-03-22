package com.application.DTO;

public class SupplierDTO {
    private long phoneNumber;
    private String name;
    private String email;
    private String shippingAddress;

    public SupplierDTO(long phoneNumber, String name, String email, String shippingAddress) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
