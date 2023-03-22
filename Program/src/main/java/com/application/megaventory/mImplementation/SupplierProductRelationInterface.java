package com.application.megaventory.mImplementation;

import org.json.JSONException;

public interface SupplierProductRelationInterface {
    String createSupplierProductRelation(String supplierID, String productID) throws JSONException;
}
