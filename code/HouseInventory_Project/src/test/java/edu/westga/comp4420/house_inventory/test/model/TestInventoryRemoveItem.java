package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;


/**
 * Test removing an item from inventory
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestInventoryRemoveItem {

    /**
     * Test removing existing item
     */
    @Test
    public void testRemoveItem() {
        Inventory inventory = new Inventory();
        Location location = new Location("Kitchen");
        Item item = new Item("Microwave", 1, location, "Kitchen appliance");

        inventory.addItem(item);
        inventory.removeItem(item);
        assertEquals(0, inventory.getItems().size());
    }
}