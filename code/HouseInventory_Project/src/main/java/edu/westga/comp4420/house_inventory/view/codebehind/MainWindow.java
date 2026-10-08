package edu.westga.comp4420.house_inventory.view.codebehind;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.westga.comp4420.house_inventory.model.Inventory;
import edu.westga.comp4420.house_inventory.model.Location;
import edu.westga.comp4420.house_inventory.model.Item;



/**
 * Code behind for the main inventory window
 * 
 * @author Brennah Brundage Comp4420
 * @version Fall 2026
 */
public class MainWindow {
    
    @FXML
    private TableView<Item> itemTableView;

    @FXML
    private TableColumn<Item, String> itemColumn;

    @FXML
    private TableColumn<Item, Integer> quantityColumn;

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
     * Initializes the main inventory window
     */
    @FXML
    private void initialize() {
        this.itemColumn.setCellValueFactory(
            new PropertyValueFactory<Item, String>("name")
        );

        this.quantityColumn.setCellValueFactory(
            new PropertyValueFactory<Item, Integer>("quantity")
        );
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

    /**
     * Open the Add Item window when selected
     * 
     * @throws IOException if the file cannot load properly
     */
    @FXML
    private void openAddItem() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AddItemWindow.fxml")
        );

        Parent root = loader.load();
        AddItemWindow controller = loader.getController();
        controller.setInventory(this.inventory);

        Stage stage = new Stage();
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        this.refreshItemTable();
    }

    /**
     * Refresh item table
     */
    private void refreshItemTable() {
        this.itemTableView.getItems().clear();

        for (Item item : this.inventory.getItems()) {
            this.itemTableView.getItems().add(item);
        }
    }

    /**
     * Opens the View Item window
     * 
     * @throws IOException if file does not load properly
     */
    @FXML
    private void openViewItem() throws IOException {
        Item selectedItem = this.itemTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("ViewItemWindow.fxml")
            );

            Parent root = loader.load();

            ViewItemWindow controller = loader.getController();
            controller.setItem(selectedItem);

            Stage stage = new Stage();
            stage.setTitle("View Item");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }

    /**
     * Opens the Edit Item window
     * 
     * @throws IOException if the file does not load properly
     */
    @FXML
    private void openEditItem() throws IOException {
        Item selectedItem = this.itemTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("EditItemWindow.fxml")
            );

            Parent root = loader.load();

            EditItemWindow controller = loader.getController();
            controller.setItem(selectedItem, this.inventory);

            Stage stage = new Stage();
            stage.setTitle("Edit Item");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            this.itemTableView.refresh();
        }
    }

    /**
     * Removes selected item from inventory
     */
    @FXML
    private void removeSelectedItem() {
        Item selectedItem = this.itemTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            this.inventory.removeItem(selectedItem);
            this.refreshItemTable();
        }
    }
}