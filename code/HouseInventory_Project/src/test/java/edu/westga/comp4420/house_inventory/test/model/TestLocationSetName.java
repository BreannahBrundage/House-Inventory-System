package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Tests the setName method in the Location class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestLocationSetName {

    /**
     * Testing setting name of new location
     */
    @Test
    public void testSetNameLocation() {
        Location location = new Location("Garage");
        location.setName("Kitchen");

        assertEquals("Kitchen", location.getName());
    }
}