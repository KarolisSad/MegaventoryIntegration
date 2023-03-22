package com.application.logic.logicImplementation;

import com.application.DTO.SupplierDTO;
import com.application.logic.logicInterfaces.SupplierLogicInterface;
import com.application.megaventory.mImplementation.SupplierInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling supplier-related operations

@Service
public class SupplierLogicImpl implements SupplierLogicInterface {

    @Resource
    SupplierInterface supplier;

    @Override
    public String addSupplier(SupplierDTO supplierDTO) throws JSONException {
        return supplier.addSupplier(supplierDTO);
    }
}
