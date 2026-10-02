package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests the setLocation method in the Item class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestItemSetLocation {

    /**
     * Test changing an items location
     */
    @Test
    public void testSetLocation() {
        Location kitchen = new Location("Kitchen");
        Location garage = new Location("Garage");

        Item item = new Item("Microwave", 1, kitchen, "Kitchen appliance");
        item.setLocation(garage);
        assertEquals(garage, item.getLocation());
    }
}