package com.application.endpoints;

import com.application.DTO.ProductDTO;
import com.application.logic.logicInterfaces.ProductLogicInterface;
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
public class ProductController {

    @Resource
    ProductLogicInterface productLogic;

    @PostMapping(value ="/product",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO dto){
        try{
            String message = productLogic.addProduct(dto);
            return new ResponseEntity<>(message,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
