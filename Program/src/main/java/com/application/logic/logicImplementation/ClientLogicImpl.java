package com.application.logic.logicImplementation;

import com.application.DTO.ClientDTO;
import com.application.logic.logicInterfaces.ClientLogicInterface;
import com.application.megaventory.mImplementation.ClientInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling client-related operations

@Service
public class ClientLogicImpl implements ClientLogicInterface {

    @Resource
    ClientInterface client;

    @Override
    public String addClient(ClientDTO clientDTO) throws JSONException {
        return client.addClient(clientDTO);
    }
}
