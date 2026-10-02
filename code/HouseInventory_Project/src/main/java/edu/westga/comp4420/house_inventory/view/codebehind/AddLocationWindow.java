package edu.westga.comp4420.house_inventory.view.codebehind;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import edu.westga.comp4420.house_inventory.model.Location;
import edu.westga.comp4420.house_inventory.model.Inventory;

/**
 * Code for the Add Location window
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class AddLocationWindow {

    @FXML
    private TextField locationNameTextField;
    private Inventory inventory;

    /**
     * Creates a new Add Location window
     */
    public AddLocationWindow() {

    }

    /**
     * Setter for the inventory window
     * 
     * @param inventory the inventory that will be used
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds a new location
     */
    @FXML
    private void addLocation() {
        String locationName = this.locationNameTextField.getText();
        Location location = new Location(locationName);

        this.inventory.addLocation(location);

        Stage stage = (Stage) this.locationNameTextField.getScene().getWindow();
        stage.close();

    }

    /**
     * Cancels adding a new location
     */
    @FXML
    private void cancel() {

    }
    
}