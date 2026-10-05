package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Test the toString method inside the location class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class TestLocationToString {
    /**
     * Test getting lcoation name as a string
     */
    @Test
    public void testToString() {
        Location location = new Location("Kitchen");
        assertEquals("Kitchen", location.toString());
        }
}
