package edu.westga.comp4420.house_inventory.model;


/**
 * Class represents an item in the house inventory
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class Item {
    private String name;
    private int quantity;
    private Location location;
    private String details;

    /**
     * Creates a new item 
     * 
     * @param name the name of the item 
     * @param quantity the item quantity
     * @param location the items location 
     * @param details the item details
     */
    public Item(String name, int quantity, Location location, String details) {
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.details = details;
    }

    /**
     * Getter for item name
     * 
     * @return the item name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for item name
     * 
     * @param name the new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the item quantity
     * 
     * @return item quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for the item quantity
     * 
     * @param quantity the new item quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for the item location
     * 
     * @return the item location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Setter for the item location
     * 
     * @param location the new item location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Getter for item details
     * 
     * @return the item details
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * Setter for item details
     * 
     * @param details the new item details
     */
    public void setDetails(String details) {
        this.details = details;
    }


}