package edu.westga.comp4420.house_inventory.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import edu.westga.comp4420.house_inventory.model.Item;

/**
 * Code for View Item window
 * 
 * @author breannah brundage
 * @version Fall 2026
 */
public class ViewItemWindow {

    @FXML
    private Label itemLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private TextArea detailsTextArea;

    /**
     * Creates new View Item window
     */
    public ViewItemWindow() {

    }

    /**
     * Setter for item display
     * 
     * @param item the item to display 
     */
    public void setItem(Item item) {
        this.itemLabel.setText(item.getName());
        this.quantityLabel.setText(Integer.toString(item.getQuantity()));
        this.locationLabel.setText(item.getLocation().getName());
        this.detailsTextArea.setText(item.getDetails());
    }

    /**
     * Closes the View Item window
     */
    @FXML
    private void buttonClose() {
        Stage stage = (Stage) this.itemLabel.getScene().getWindow();
        stage.close();
    }
}