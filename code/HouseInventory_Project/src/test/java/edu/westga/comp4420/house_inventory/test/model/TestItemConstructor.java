package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests the Item class constuctor
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestItemConstructor {

    /**
     * Tests creating an item
     */
    @Test
    public void testCreateItem() {
        Location location = new Location("Kitchen");

        Item item = new Item("Microwave", 1, location, "Kitchen appliance");
        assertEquals("Microwave", item.getName());
        assertEquals(1, item.getQuantity());
        assertEquals(location, item.getLocation());
        assertEquals("Kitchen appliance", item.getDetails());
    }
}