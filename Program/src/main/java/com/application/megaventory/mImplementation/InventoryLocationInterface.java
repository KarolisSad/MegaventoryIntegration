package com.application.megaventory.mImplementation;

import com.application.DTO.InvStockDTO;
import com.application.DTO.InventoryLocationDTO;
import org.json.JSONException;

public interface InventoryLocationInterface {
    String addInventoryLocation(InventoryLocationDTO inventoryLocationDTO) throws JSONException;
    String updateStock(InvStockDTO dto) throws JSONException;
    String getInventoryIDByAbbreviation(String abbreviation) throws JSONException;
}
