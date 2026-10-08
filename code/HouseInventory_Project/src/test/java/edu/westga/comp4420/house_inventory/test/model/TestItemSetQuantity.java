package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests the setQuantity method in the Item class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestItemSetQuantity {

    /**
     * Test changing the item's quantity
     */
    @Test
    public void testSetQuantity() {
        Location location = new Location("Kitchen");
        Item item = new Item("Microwave", 1, location, "Kitchen appliance");

        item.setQuantity(2);
        assertEquals(2, item.getQuantity());
    }
}