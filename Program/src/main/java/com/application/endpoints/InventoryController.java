package com.application.endpoints;

import com.application.DTO.InventoryLocationDTO;
import com.application.logic.logicInterfaces.InventoryLogicInterface;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This class is responsible for providing endpoints for
// the application to handle InventoryLocation-related requests.

@RestController
public class InventoryController {

    @Resource
    InventoryLogicInterface inventoryLogic;

    @PostMapping(value ="/inventory",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addInventoryLocation(@RequestBody InventoryLocationDTO dto){
        try{
            String result = inventoryLogic.addInventoryLocation(dto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
