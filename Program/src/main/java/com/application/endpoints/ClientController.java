package com.application.endpoints;

import com.application.DTO.ClientDTO;
import com.application.logic.logicInterfaces.ClientLogicInterface;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This class is responsible for providing endpoints for
// the application to handle client-related requests.

@RestController
public class ClientController {

    @Resource
    ClientLogicInterface clientLogic;

    @PostMapping(value ="/client",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addClient(@RequestBody ClientDTO dto){
        try{
            String message = clientLogic.addClient(dto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
