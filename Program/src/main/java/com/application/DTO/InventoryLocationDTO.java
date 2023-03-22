package com.application.DTO;

public class InventoryLocationDTO {

    private String name;
    private String locationAddress;
    private String abbreviation;

    public InventoryLocationDTO(String name, String locationAddress, String abbreviation) {
        this.name = name;
        this.locationAddress = locationAddress;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        abbreviation = abbreviation;
    }
}
