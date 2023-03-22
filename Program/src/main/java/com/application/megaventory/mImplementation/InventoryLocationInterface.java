package com.application.megaventory.mImplementation;

import com.application.DTO.InventoryLocationDTO;
import org.json.JSONException;

public interface InventoryLocationInterface {
    String addInventoryLocation(InventoryLocationDTO inventoryLocationDTO) throws JSONException;
}
