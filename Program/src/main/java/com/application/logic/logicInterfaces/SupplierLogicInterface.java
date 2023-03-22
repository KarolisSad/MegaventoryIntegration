package com.application.logic.logicInterfaces;

import com.application.DTO.SupplierDTO;
import org.json.JSONException;

public interface SupplierLogicInterface {
    String addSupplier(SupplierDTO supplierDTO) throws JSONException;
}
