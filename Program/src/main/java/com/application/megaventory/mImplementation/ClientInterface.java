package com.application.megaventory.mImplementation;

import com.application.DTO.ClientDTO;
import org.json.JSONException;

public interface ClientInterface {
    String addClient(ClientDTO clientDTO) throws JSONException;
    String getClientsIDByName(String name) throws JSONException;
}
