package edu.westga.comp4420.house_inventory.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import edu.westga.comp4420.house_inventory.model.Location;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Item;


/**
 * Code for Edit Item window
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class EditItemWindow {

    @FXML
    private TextField itemTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private ComboBox<Location> locationComboBox;

    @FXML
    private TextArea detailsTextArea;

    private Item item;
    private Inventory inventory;

    /**
     * Creates new Edit Item window
     */
    public EditItemWindow() {

    }

    /**
     * Setter for item and inventory for editing 
     * 
     * @param item the item being edited
     * @param inventory the inventory containing the item to be edited
     */
    public void setItem(Item item, Inventory inventory) {
        this.item = item;
        this.inventory = inventory;

        this.itemTextField.setText(item.getName());
        this.quantityTextField.setText(Integer.toString(item.getQuantity()));
        this.locationComboBox.getItems().addAll(inventory.getLocations());
        this.locationComboBox.setValue(item.getLocation());
        this.detailsTextArea.setText(item.getDetails());
    }

    /**
     * Saves changes made to the item
     */
    @FXML
    private void buttonSaveChanges() {
        this.item.setName(this.itemTextField.getText());
        this.item.setQuantity(Integer.parseInt(this.quantityTextField.getText()));
        this.item.setLocation(this.locationComboBox.getValue());
        this.item.setDetails(this.detailsTextArea.getText());

        Stage stage = (Stage) this.itemTextField.getScene().getWindow();
        stage.close();
    }

    /**
     * Cancels editing the item
     */
    @FXML
    public void buttonCancel() {
        Stage stage = (Stage) this.itemTextField.getScene().getWindow();
        stage.close();
    }

}