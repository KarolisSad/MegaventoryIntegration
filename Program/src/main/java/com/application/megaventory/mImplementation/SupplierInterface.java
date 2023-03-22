package com.application.megaventory.mImplementation;

import com.application.DTO.SupplierDTO;
import org.json.JSONException;

public interface SupplierInterface {
    String addSupplier(SupplierDTO supplierDTO) throws JSONException;
    String getSupplierIDbyName(String name) throws JSONException;
}
