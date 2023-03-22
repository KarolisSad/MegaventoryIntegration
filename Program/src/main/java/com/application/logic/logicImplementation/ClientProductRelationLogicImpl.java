package com.application.logic.logicImplementation;

import com.application.DTO.RelationDTO;
import com.application.logic.logicInterfaces.ClientProductRelationLogicInterface;
import com.application.megaventory.mImplementation.ClientInterface;
import com.application.megaventory.mImplementation.ClientProductRelationInterface;
import com.application.megaventory.mImplementation.ProductInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling client-product relationship related operations

@Service
public class ClientProductRelationLogicImpl implements ClientProductRelationLogicInterface {

    @Resource
    ProductInterface product;
    @Resource
    ClientInterface client;
    @Resource
    ClientProductRelationInterface clientProductRelation;

    // Makes 3 calls to MV API:
    // - to get product ID using it's SKU
    // - to get clients ID using it's Name
    // - to create relationship between client & product
    // In case of Error return "Error Message"
    @Override
    public String addRelation(RelationDTO relationDTO) {
        try {
            // Getting IDs
            String productID = product.getProductsIDBySKU(relationDTO.getProductSKU());
            String clientID = client.getClientsIDByName(relationDTO.getClientName());

            // Creating relationship
            return clientProductRelation.createProductClientRelation(clientID,productID);

        } catch (JSONException e) {
            return e.getMessage();
        }
    }
}
