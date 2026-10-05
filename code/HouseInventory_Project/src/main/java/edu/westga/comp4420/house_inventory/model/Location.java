package edu.westga.comp4420.house_inventory.model;

/**
 * Location where items in inventory are stored inside house
 * 
 * @author Breannah Brundage
 * @version Fall 2026
 */
public class Location {
    private String name;

    /**
     * Creates a new location
     * 
     * @param name the name of the location
     */
    public Location(String name) {
        this.name = name;
    }

    /**
     * Gets the location name
     * 
     * @return location name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the location name
     * 
     * @param name the new location 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the location name
     * 
     * @return location name
     */
    @Override
    public String toString() {
        return this.name;
    }
}