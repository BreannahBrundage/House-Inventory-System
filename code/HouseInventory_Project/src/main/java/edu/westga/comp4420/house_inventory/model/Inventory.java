package edu.westga.comp4420.house_inventory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class for house inventory
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class Inventory {
    
    private List<Location> locations;

    /**
     * Creates a new inventory
     */
    public Inventory() {
        this.locations = new ArrayList<Location>();
    }

    /**
     * Adds a new location to the inventory 
     * 
     * @param location the location to be added
     */
    public void addLocation(Location location) {
        this.locations.add(location);
    }

    /**
     * Getter for the location in the inventory
     * 
     * @return the locations
     */
    public List<Location> getLocations() {
        return this.locations;
    }

}