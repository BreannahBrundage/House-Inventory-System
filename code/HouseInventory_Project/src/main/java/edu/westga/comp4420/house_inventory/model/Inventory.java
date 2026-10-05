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
    private List<Item> items;

    /**
     * Creates a new inventory
     */
    public Inventory() {
        this.locations = new ArrayList<Location>();
        this.items = new ArrayList<Item>();
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

    /**
     * Adds a new item to the inventory
     * 
     * @param item the item to be added
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Getter for the items in inventory
     * 
     * @return the items
     */
    public List<Item> getItems() {
        return this.items;
    }

}