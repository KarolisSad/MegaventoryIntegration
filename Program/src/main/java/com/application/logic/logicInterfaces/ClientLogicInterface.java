package com.application.logic.logicInterfaces;

import com.application.DTO.ClientDTO;
import org.json.JSONException;

public interface ClientLogicInterface {

    String addClient(ClientDTO clientDTO) throws JSONException;
}
