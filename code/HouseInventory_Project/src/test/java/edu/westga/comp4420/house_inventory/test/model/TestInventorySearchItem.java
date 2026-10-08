package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;


/**
 * Test searching for an item in the house inventory
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestInventorySearchItem {

    /**
     * Test searching for an item 
     */
    @Test
    public void testSearchItemByName() {
        Inventory inventory = new Inventory();
        Location location = new Location("Kitchen");

        Item microwave = new Item("Microwave", 1, location, "Appliance");
        Item toaster = new Item("Toaster", 1, location, "Appliance");
        inventory.addItem(microwave);
        inventory.addItem(toaster);

        assertEquals(1, inventory.searchItems("micro").size());
        assertEquals(microwave, inventory.searchItems("micro").get(0));
    }
}