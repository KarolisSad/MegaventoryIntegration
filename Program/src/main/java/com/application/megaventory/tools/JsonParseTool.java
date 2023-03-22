package com.application.megaventory.tools;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

// Globally accessible class for providing Parse functions

public class JsonParseTool {

    public static String ParseMessageBodyFromJson(ResponseEntity<String> response) throws JSONException {
        JSONObject errorResponse = new JSONObject(response.getBody());
        String errorCode = errorResponse.getJSONObject("ResponseStatus").getString("ErrorCode");
        if (Integer.parseInt(errorCode) == 500)
        {
            return errorResponse.getJSONObject("ResponseStatus").getString("Message");
        }
        return "Success";
    }

    public static String ParseProductIDFromJson(ResponseEntity<String> response) throws JSONException {
        JSONObject message = new JSONObject(response.getBody());
        String errorCode = message.getJSONObject("ResponseStatus").getString("ErrorCode");
        if (Integer.parseInt(errorCode) == 500)
        {
            return message.getJSONObject("ResponseStatus").getString("Message");
        }

        return message.getJSONArray("mvProducts").getJSONObject(0).getString("ProductID");
    }

    public static String ParseClientSupplierIDFromJson(ResponseEntity<String> response) throws JSONException {
        JSONObject message = new JSONObject(response.getBody());
        String errorCode = message.getJSONObject("ResponseStatus").getString("ErrorCode");
        if (Integer.parseInt(errorCode) == 500)
        {
            return message.getJSONObject("ResponseStatus").getString("Message");
        }

        return message.getJSONArray("mvSupplierClients").getJSONObject(0).getString("SupplierClientID");
    }

    public static String ParseInventoryLocationIDFromJson(ResponseEntity<String> response) throws JSONException {
        JSONObject message = new JSONObject(response.getBody());
        String errorCode = message.getJSONObject("ResponseStatus").getString("ErrorCode");
        if (Integer.parseInt(errorCode) == 500)
        {
            return message.getJSONObject("ResponseStatus").getString("Message");
        }

        return message.getJSONArray("mvInventoryLocations").getJSONObject(0).getString("InventoryLocationID");
    }
}
