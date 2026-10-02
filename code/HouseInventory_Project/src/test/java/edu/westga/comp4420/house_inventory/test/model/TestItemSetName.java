package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Test for the setName method in the Item class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestItemSetName {

    /**
     * Test changing an items name
     */
    @Test
    public void testSetName() {
        Location location = new Location("Kitchen");
        Item item = new Item("Microwave", 1, location, "Kitchen appliance");

        item.setName("Toaster");

        assertEquals("Toaster", item.getName());
    }
}