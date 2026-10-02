package edu.westga.comp4420.house_inventory.view.codebehind;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Location;

/**
 * Code behind for the main inventory window
 * 
 * @author Brennah Brundage Comp4420
 * @version Fall 2026
 */
public class MainWindow {
    
    @FXML
    private ListView<String> locationListView;
    private Inventory inventory;

    /**
     * Creates a new main inventory window
     */
    public MainWindow() {
        this.inventory = new Inventory();
        
    }

    /**
     * Open the Add Location window when selected
     * 
     * @throws IOException if the file cannot be loaded properly
     */
    @FXML
    private void openAddLocation() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AddLocationWindow.fxml")
        );

        Parent root = loader.load();

        AddLocationWindow controller = loader.getController();
        controller.setInventory(this.inventory);

        Stage stage = new Stage();
        stage.setTitle("Add Location");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        this.refreshLocationList();
    }

    /**
     * Refreshes the locations list 
     */
    private void refreshLocationList() {
        this.locationListView.getItems().clear();
        for (Location location : this.inventory.getLocations()) {
            this.locationListView.getItems().add(location.getName());
        }
    }
}