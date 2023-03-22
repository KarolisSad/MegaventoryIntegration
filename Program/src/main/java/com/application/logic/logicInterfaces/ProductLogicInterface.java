package com.application.logic.logicInterfaces;

import com.application.DTO.ProductDTO;
import org.json.JSONException;

public interface ProductLogicInterface {

    String addProduct(ProductDTO productDTO) throws JSONException;
}
