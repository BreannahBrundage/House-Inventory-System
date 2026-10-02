package edu.westga.comp4420.house_inventory.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Testing the constructor of the Location class
 * 
 * @author Breannah Brundage
 * @version Fall 2026
 */
public class TestLocationConstructor {

    /**
     * Testing creating a new location with a valid name
     */
    @Test
    public void testCreateLocationWithValidName() {
        Location location = new Location("Garage");
        assertEquals("Garage", location.getName());
    }
}