package edu.westga.comp4420.house_inventory.view.codebehind;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Code behind for the main inventory window
 * 
 * @author Brennah Brundage Comp4420
 * @version Fall 2026
 */
public class MainWindow {

    /**
     * Creates a new main inventory window
     */
    public MainWindow() {
        
    }

    /**
     * Open the Add Location window when selected
     * 
     * @throws IOException if the file cannot be loaded properly
     */
    @FXML
    private void openAddLocation() throws IOException {
        Parent root = FXMLLoader.load(
            getClass().getResource("AddLocationWindow.fxml")
        );

        Stage stage = new Stage();
        stage.setTitle("Add Location");
        stage.setScene(new Scene(root));
        stage.show();
    }
}