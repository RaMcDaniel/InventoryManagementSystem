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
import model.Inventory;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.MainScreenController.passableInHouse;
import static controller.MainScreenController.passableOutsourced;


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
    public static boolean inHouseToggle = true;

    int id;
    String name;
    int inventory;
    double price;
    int min;
    int max;
    int machineID;
    String companyName;




    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inHouseToggle = true;
        int modId;
        String modName;
        int modInventory;
        double modPrice;
        int modMin;
        int modMax;
        int modMachineID;
        String modCompanyName;

        if(inHouseToggle){
            modId = passableInHouse.getId();
            modName = passableInHouse.getName();
            modInventory = passableInHouse.getStock();
            modPrice = passableInHouse.getPrice();
            modMin = passableInHouse.getMin();
            modMax = passableInHouse.getMax();
            modMachineID = passableInHouse.getMachineID();
        }
        if(!inHouseToggle) {
            modId = passableOutsourced.getId();
            modName = passableOutsourced.getName();
            modInventory = passableOutsourced.getStock();
            modPrice = passableOutsourced.getPrice();
            modMin = passableOutsourced.getMin();
            modMax = passableOutsourced.getMax();
            modCompanyName = passableOutsourced.getCompanyName();
        }

    }


    /**  When radios are toggled to In-House the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInHouseRadioMod(ActionEvent actionEvent) {
        machineCompanyLabelMod.setText("Machine ID");
        machineCompanyFieldMod.setPromptText("Enter machine ID");
        inHouseToggle = true;
    }

    /**  When radios are toggled to Outsourced the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onOutsourcedRadioMod(ActionEvent actionEvent) {
        machineCompanyLabelMod.setText("Company Name");
        machineCompanyFieldMod.setPromptText("Enter company name");
        inHouseToggle = false;
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
