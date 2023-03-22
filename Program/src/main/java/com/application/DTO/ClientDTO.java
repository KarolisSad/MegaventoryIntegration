package com.application.DTO;

// This class represents a data transfer object (DTO) for a client.
// The purpose of this DTO is to encapsulate client information in
// a way that is easily serializable and transferable across network

public class ClientDTO {

    private long phoneNumber;
    private String name;
    private String email;
    private String shippingAddress;

    public ClientDTO(long phoneNumber, String name, String email, String shippingAddress) {
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
