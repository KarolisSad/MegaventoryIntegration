package com.application.logic.logicImplementation;

import com.application.DTO.InvStockDTO;
import com.application.DTO.InventoryLocationDTO;
import com.application.logic.logicInterfaces.InventoryLogicInterface;
import com.application.megaventory.mImplementation.InventoryLocationInterface;
import jakarta.annotation.Resource;
import org.json.JSONException;
import org.springframework.stereotype.Service;

// This class is responsible for providing the logic for handling InventoryLocation-related operations

@Service
public class InventoryLogicImpl implements InventoryLogicInterface {

    @Resource
    InventoryLocationInterface inventoryLocation;

    @Override
    public String addInventoryLocation(InventoryLocationDTO inventoryLocationDTO) throws JSONException {
        return inventoryLocation.addInventoryLocation(inventoryLocationDTO);
    }

    @Override
    public String updateStock(InvStockDTO dto) {
        try {
            String inventoryID = inventoryLocation.getInventoryIDByAbbreviation(dto.getAbbreviation());
            dto.setAbbreviation(inventoryID);

            return inventoryLocation.updateStock(dto);
        } catch (JSONException e) {
            return "Error";
        }
    }
}
