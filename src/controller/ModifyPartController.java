package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/** This class controls the modifyPart FXML screen.
 *
 */
public class ModifyPartController implements Initializable {
    public RadioButton inHouseRadioMod;
    public ToggleGroup partTypeMod;
    public RadioButton outsourcedRadioMod;
    public TextField partIDMod;
    public TextField nameFieldMod;
    public TextField inventoryFieldMod;
    public TextField priceFieldMod;
    public TextField maxInventoryFieldMod;
    public TextField machineCompanyFieldMod;
    public TextField minInventoryFieldMod;
    public Button saveButtonMod;
    public Button cancelButtonMod;
    public Label machineCompanyLabelMod;

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**  When radios are toggled to In-House the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInHouseRadioMod(ActionEvent actionEvent) {
        machineCompanyLabelMod.setText("Machine ID");
        machineCompanyFieldMod.setPromptText("Enter machine ID");
    }

    /**  When radios are toggled to Outsourced the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onOutsourcedRadioMod(ActionEvent actionEvent) {
        machineCompanyLabelMod.setText("Company Name");
        machineCompanyFieldMod.setPromptText("Enter company name");
    }

    /** This method is called when the name text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onNameFieldMod(ActionEvent actionEvent) {
    }

    /** This method is called when the inventory text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**  This method is called when the price/cost text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onPriceFieldMod(ActionEvent actionEvent) {
    }

    /** This method is called when the maximum text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMaxInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**  This method is called when the Machine ID/Company Name text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMachineCompanyFieldMod(ActionEvent actionEvent) {
    }

    /**  This method is called when the minimum text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMinInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**  This method is called save button is clicked. It calls methods to save information, and switches uer to main screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onSaveButtonMod(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    /**  This method is called when the cancel button is clicked. It discards typed information and returns user to main screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onCancelButtonMod(ActionEvent actionEvent) throws IOException {

        Optional<ButtonType> result = Alerts.cancel.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Inventory Management System");
            stage.setScene(scene);
            stage.show();
        }
    }
}
