package com.application.megaventory.mInterface;

import com.application.DTO.ProductDTO;
import com.application.megaventory.mImplementation.ProductInterface;
import com.application.megaventory.tools.JsonParseTool;
import com.application.megaventory.tools.MyApiClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductImpl implements ProductInterface {

    @Override
    public String addProduct(ProductDTO productDTO) throws JSONException {
        // Message Body
        JSONObject requestBody = new JSONObject();
        JSONObject mvProduct = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        mvProduct.put("ProductSKU", productDTO.getSKU());
        mvProduct.put("ProductDescription", productDTO.getDescription());
        mvProduct.put("ProductPurchasePrice", productDTO.getPurchasePrice());
        mvProduct.put("ProductSellingPrice", productDTO.getSalesPrice());
        requestBody.put("mvProduct", mvProduct);
        requestBody.put("mvRecordAction", "Insert");

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/Product/ProductUpdate";

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
    public String getProductsIDBySKU(String sku) throws JSONException {
        // Message body
        JSONObject requestBody = new JSONObject();
        JSONArray filters = new JSONArray();

        JSONObject filter = new JSONObject();
        requestBody.put("APIKEY", MyApiClass.API_KEY);
        filter.put("FieldName", "productsku");
        filter.put("SearchOperator", "Equals");
        filter.put("SearchValue", sku);
        filters.put(filter);
        requestBody.put("Filters", filters);
        requestBody.put("ReturnTopNRecords", 1);

        // Endpoint
        String url = "https://api.megaventory.com/v2017a/Product/ProductGet";

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
        return JsonParseTool.ParseProductIDFromJson(response);
    }


}
