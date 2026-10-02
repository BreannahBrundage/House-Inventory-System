package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests the addLocation method inside the Inventory class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestInventoryAddLocation {

    /**
     * Tests adding a location to the inventory 
     */
    @Test 
    public void testAddLocation() {
        Inventory inventory = new Inventory();
        Location location = new Location("Bathroom");

        inventory.addLocation(location);

        assertEquals(1, inventory.getLocations().size());
        assertEquals("Bathroom", inventory.getLocations().get(0).getName());
    }
}