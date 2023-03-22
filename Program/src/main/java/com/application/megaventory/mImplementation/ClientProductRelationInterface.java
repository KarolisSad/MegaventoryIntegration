package com.application.megaventory.mImplementation;

import org.json.JSONException;

public interface ClientProductRelationInterface {

    String createProductClientRelation(String clientID, String productID) throws JSONException;
}
