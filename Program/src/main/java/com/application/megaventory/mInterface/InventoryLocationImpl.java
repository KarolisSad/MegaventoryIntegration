package com.application.megaventory.mInterface;

import com.application.DTO.InvStockDTO;
import com.application.DTO.InventoryLocationDTO;
import com.application.megaventory.mImplementation.InventoryLocationInterface;
import com.application.megaventory.tools.JsonParseTool;
import com.application.megaventory.tools.MyApiClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryLocationImpl implements InventoryLocationInterface {

    @Override
    public String addInventoryLocation(InventoryLocationDTO inventoryLocationDTO) throws JSONException {
        // Message Body
        JSONObject requestBody = new JSONObject();
        JSONObject mvInv = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        mvInv.put("InventoryLocationName", inventoryLocationDTO.getName());
        mvInv.put("InventoryLocationAbbreviation", inventoryLocationDTO.getAbbreviation());
        mvInv.put("InventoryLocationAddress", inventoryLocationDTO.getLocationAddress());
        requestBody.put("mvInventoryLocation", mvInv);
        requestBody.put("mvRecordAction", "Insert");

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/InventoryLocation/InventoryLocationUpdate";

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

    @Override
    public String updateStock(InvStockDTO dto) throws JSONException {
        // Message Body
        JSONObject requestBody = new JSONObject();
        JSONObject mvStock = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        mvStock.put("ProductSKU", dto.getProductSKU());
        mvStock.put("ProductQuantity", dto.getProductQuantity());
        mvStock.put("InventoryLocationID", dto.getAbbreviation());
        requestBody.put("mvProductStockUpdateList", mvStock);

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/InventoryLocationStock/ProductStockUpdate";

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

    @Override
    public String getInventoryIDByAbbreviation(String abbreviation) throws JSONException {
        // Message body
        JSONObject requestBody = new JSONObject();
        JSONArray filters = new JSONArray();
        requestBody.put("APIKEY", MyApiClass.API_KEY);

        JSONObject filter1 = new JSONObject();
        filter1.put("FieldName", "InventoryLocationAbbreviation");
        filter1.put("SearchOperator", "Equals");
        filter1.put("SearchValue", abbreviation);
        filters.put(filter1);

        requestBody.put("Filters", filters);
        requestBody.put("ReturnTopNRecords", 1);

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/InventoryLocation/InventoryLocationGet";

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
        return JsonParseTool.ParseInventoryLocationIDFromJson(response);
    }
}
