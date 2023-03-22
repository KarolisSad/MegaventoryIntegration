package com.application.megaventory.mInterface;

import com.application.DTO.SupplierDTO;
import com.application.megaventory.mImplementation.SupplierInterface;
import com.application.megaventory.tools.JsonParseTool;
import com.application.megaventory.tools.MyApiClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SupplierImpl implements SupplierInterface {

    @Override
    public String addSupplier(SupplierDTO supplierDTO) throws JSONException {
        JSONObject requestBody = new JSONObject();
        JSONObject mvClient = new JSONObject();
        JSONObject mvContact = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        mvClient.put("SupplierClientType", "Supplier");
        mvClient.put("SupplierClientName", supplierDTO.getName());
        mvClient.put("SupplierClientPhone1", supplierDTO.getPhoneNumber());
        mvClient.put("SupplierClientShippingAddress1", supplierDTO.getShippingAddress());
        mvContact.put("ContactEmail", supplierDTO.getEmail());
        requestBody.put("mvSupplierClient", mvClient);
        requestBody.put("mvContacts", mvContact);
        requestBody.put("mvRecordAction", "Insert");

        String url = "https://api.megaventory.com/v2017a/SupplierClient/SupplierClientUpdate";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<String>(requestBody.toString(), headers),
                String.class
        );
        return JsonParseTool.ParseMessageBodyFromJson(response);
    }

    @Override
    public String getSupplierIDbyName(String name) throws JSONException {
        // Message Body
        JSONObject requestBody = new JSONObject();
        JSONArray filters = new JSONArray();
        requestBody.put("APIKEY", MyApiClass.API_KEY);

        JSONObject filter1 = new JSONObject();
        filter1.put("FieldName", "SupplierClientType");
        filter1.put("SearchOperator", "Equals");
        filter1.put("SearchValue", "Supplier");
        filters.put(filter1);

        JSONObject filter2 = new JSONObject();
        filter2.put("AndOr", "And");
        filter2.put("FieldName", "SupplierClientName");
        filter2.put("SearchOperator", "Contains");
        filter2.put("SearchValue", name);
        filters.put(filter2);

        requestBody.put("Filters", filters);
        requestBody.put("ReturnTopNRecords", 1);

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/SupplierClient/SupplierClientGet";

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
        return JsonParseTool.ParseClientSupplierIDFromJson(response);
    }
}
