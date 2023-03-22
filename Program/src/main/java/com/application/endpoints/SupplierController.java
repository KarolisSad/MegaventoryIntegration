package com.application.endpoints;

import com.application.DTO.SupplierDTO;
import com.application.logic.logicInterfaces.SupplierLogicInterface;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This class is responsible for providing endpoints for
// the application to handle Supplier-related requests.

@RestController
public class SupplierController {

    @Resource
    SupplierLogicInterface supplierLogic;

    @PostMapping(value ="/supplier",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addSupplier(@RequestBody SupplierDTO dto){
        try{
            String result = supplierLogic.addSupplier(dto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
