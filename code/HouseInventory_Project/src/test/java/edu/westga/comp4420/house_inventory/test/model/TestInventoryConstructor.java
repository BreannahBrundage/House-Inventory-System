package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Inventory;

/**
 * Testing the constructor in the Inventory class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestInventoryConstructor {

    /**
     * Test creating a new inventory
     */
    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        assertTrue(inventory.getLocations().isEmpty());
    }
}