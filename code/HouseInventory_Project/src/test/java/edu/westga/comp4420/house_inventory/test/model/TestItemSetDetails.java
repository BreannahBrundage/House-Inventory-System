package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests changing the item detail information
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestItemSetDetails {

    /**
     * Tests changing an items details
     */
    @Test
    public void testSetDetails() {
        Location location = new Location("Kitchen");
        Item item = new Item("Microwave", 1, location, "Kitchen appliance");

        item.setDetails("Black microwave bought in 2022");
        assertEquals("Black microwave bought in 2022", item.getDetails());
    }
}