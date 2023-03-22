package com.application.megaventory.mImplementation;

import com.application.DTO.ProductDTO;
import org.json.JSONException;

public interface ProductInterface {

    String addProduct(ProductDTO productDTO) throws JSONException;
    String getProductsIDBySKU(String sku) throws JSONException;
}
