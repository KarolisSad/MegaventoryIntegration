package com.application.logic.logicInterfaces;

import com.application.DTO.InvStockDTO;
import com.application.DTO.InventoryLocationDTO;
import org.json.JSONException;

public interface InventoryLogicInterface {
    String addInventoryLocation(InventoryLocationDTO inventoryLocationDTO) throws JSONException;
    String updateStock(InvStockDTO dto);
}