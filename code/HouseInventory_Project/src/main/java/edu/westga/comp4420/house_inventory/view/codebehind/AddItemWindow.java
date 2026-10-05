package edu.westga.comp4420.house_inventory.view.codebehind;

import edu.westga.comp4420.house_inventory.model.Item;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Location;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Add item window class
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class AddItemWindow {

    @FXML
    private TextField itemTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private ComboBox<Location> locationComboBox;

    @FXML 
    private TextArea detailsTextArea;

    private Inventory inventory;

    /**
     * Creates a new Add Item window
     */
    public AddItemWindow() {

    }

    /**
     * Setter for AddItemWindow inventory
     * 
     * @param inventory the inventory that will be used
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        this.locationComboBox.getItems().addAll(inventory.getLocations());
    }

    /**
     * Adds a new item
     */
    @FXML
    private void buttonAddItem() {
        String name = this.itemTextField.getText();
        int quantity = Integer.parseInt(this.quantityTextField.getText());
        Location location = this.locationComboBox.getValue();
        String details = this.detailsTextArea.getText();
        Item item = new Item(name, quantity, location, details);
        this.inventory.addItem(item);

        Stage stage = (Stage) this.itemTextField.getScene().getWindow();
        stage.close();
    }

    /**
     * Cancels adding a new item
     */
    @FXML
    private void buttonCancel() {
        Stage stage = (Stage) this.itemTextField.getScene().getWindow();
        stage.close();
    }
}