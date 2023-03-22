package com.application.megaventory.mInterface;

import com.application.megaventory.mImplementation.ClientProductRelationInterface;
import com.application.megaventory.tools.JsonParseTool;
import com.application.megaventory.tools.MyApiClass;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientProductRelationImpl implements ClientProductRelationInterface {

    @Override
    public String createProductClientRelation(String clientID, String productID) throws JSONException {
        // Message body
        JSONObject requestBody = new JSONObject();
        JSONObject mvRelation = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        mvRelation.put("ProductClientID", clientID);
        mvRelation.put("ProductID", productID);
        requestBody.put("mvProductClientUpdate", mvRelation);
        requestBody.put("mvRecordAction", "Insert");

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/ProductClient/ProductClientUpdate";

        // Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request & Response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<String>(requestBody.toString(), headers),
                String.class
        );
        return JsonParseTool.ParseMessageBodyFromJson(response);
    }
}
