package edu.westga.comp4420.house_inventory.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Code for the Add Location window
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class AddLocationWindow {

    @FXML
    private TextField locationNameTextField;

    /**
     * Creates a new Add Location window
     */
    public AddLocationWindow() {

    }

    /**
     * Adds a new location
     */
    @FXML
    private void addLocation() {
        String locationName = this.locationNameTextField.getText();
        Location location = new Location(locationName);

    }

    /**
     * Cancels adding a new location
     */
    @FXML
    private void cancel() {

    }
    
}