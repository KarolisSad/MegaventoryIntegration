package com.application.logic.logicImplementation;

import com.application.DTO.ProductDTO;
import com.application.logic.logicInterfaces.ProductLogicInterface;
import com.application.megaventory.mImplementation.ProductInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling product-related operations

@Service
public class ProductLogicImpl implements ProductLogicInterface {

    @Resource
    ProductInterface product;

    @Override
    public String addProduct(ProductDTO productDTO) throws JSONException {
        return product.addProduct(productDTO);
    }
}
