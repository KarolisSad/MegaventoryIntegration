package com.application.logic.logicImplementation;

import com.application.DTO.RelationDTO;
import com.application.logic.logicInterfaces.SupplierProductRelationLogicInterface;
import com.application.megaventory.mImplementation.ProductInterface;
import com.application.megaventory.mImplementation.SupplierInterface;
import com.application.megaventory.mImplementation.SupplierProductRelationInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling supplier-product relationship related operations

@Service
public class SupplierProductRelationLogicImpl implements SupplierProductRelationLogicInterface {

    @Resource
    SupplierInterface supplier;
    @Resource
    ProductInterface product;
    @Resource
    SupplierProductRelationInterface supplierProductRelation;

    // Makes 3 calls to MV API:
    // - to get supplier ID using it's name
    // - to get product ID using it's SKU
    // - to create relationship between supplier & product
    // In case of Error return "Error Message"
    @Override
    public String addRelation(RelationDTO relationDTO) {
        try {
            // Getting IDs
            String supplierID = supplier.getSupplierIDbyName(relationDTO.getSupplierName());
            String productID = product.getProductsIDBySKU(relationDTO.getProductSKU());

            // Creating relationship & return
            return supplierProductRelation.createSupplierProductRelation(supplierID,productID);

        } catch (JSONException e) {
            return e.getMessage();
        }
    }
}
