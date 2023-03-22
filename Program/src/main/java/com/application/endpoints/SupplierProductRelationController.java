package com.application.endpoints;

import com.application.DTO.RelationDTO;
import com.application.logic.logicInterfaces.SupplierProductRelationLogicInterface;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This class is responsible for providing endpoints for
// the application to handle supplier-product relationship related requests.

@RestController
public class SupplierProductRelationController {

    @Resource
    SupplierProductRelationLogicInterface supplierProductRelation;

    @PostMapping(value ="/supplierProductRelation",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addRelation(@RequestBody RelationDTO dto){
        try{
            String message = supplierProductRelation.addRelation(dto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
