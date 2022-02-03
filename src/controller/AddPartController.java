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
import model.InHouse;
import model.Inventory;
import model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static main.Main.ID_COUNTER;

public class AddPartController implements Initializable {


    public RadioButton inHouseRadio;
    public ToggleGroup partType;
    public RadioButton outsourcedRadio;
    public TextField nameField;
    public TextField inventoryField;
    public TextField priceField;
    public TextField maxInventoryField;
    public TextField machineCompanyField;
    public TextField minInventoryField;
    public Button saveButton;
    public Button cancelButton;
    public Label machineCompanyLabel;
    int id;
    String name;
    float price;
    int stock;
    int min;
    int max;
    String company;
    int machineID;
    public static boolean inHouseToggle = true;

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url PENDING
     * @param resourceBundle PENDING
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /** When radios are toggled to In-House the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInHouseRadio(ActionEvent actionEvent) {
        machineCompanyLabel.setText("Machine ID");
        machineCompanyField.setPromptText("Enter machine ID");
        inHouseToggle = true;
    }

    /** When radios are toggled to Outsourced the label and prompt text change.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onOutsourcedRadio(ActionEvent actionEvent) {
        machineCompanyLabel.setText("Company Name");
        machineCompanyField.setPromptText("Enter company name");
        inHouseToggle = false;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onNameField(ActionEvent actionEvent) {
        String nameEntry = nameField.getText();
        if (!nameEntry.matches("[a-zA-Z0-9 ]+")) {
            Alerts.inputError("name", "alphanumeric names").showAndWait();
            nameField.setText("");
            return;
        }
        name = nameEntry;
        return;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInventoryField(ActionEvent actionEvent) {
        String inventoryEntry = inventoryField.getText();
        try
        {
            int inventoryFieldInt;
            inventoryFieldInt = Integer.parseInt(inventoryEntry);
            stock = inventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("inventory", "numbers").showAndWait();
            inventoryField.setText("");
            return;
        }
        return;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onPriceField(ActionEvent actionEvent) {
        String priceEntry = priceField.getText();
        try
        {
            float priceFieldInt;
            priceFieldInt = Float.parseFloat(priceEntry);

            price = priceFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            minInventoryField.setText("");
            return;
        }
        return;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMaxInventoryField(ActionEvent actionEvent) {
        String maxInventoryEntry = maxInventoryField.getText();
        try
        {
            int maxInventoryFieldInt;
            maxInventoryFieldInt = Integer.parseInt(maxInventoryEntry);
            max = maxInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("max inventory", "numbers").showAndWait();
            maxInventoryField.setText("");
            return;
        }
        return;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMachineCompanyField(ActionEvent actionEvent) {
        if(inHouseToggle){
            String machineIDEntry = machineCompanyField.getText();
            try
            {
                int machineIDEntryInt;
                machineIDEntryInt = Integer.parseInt(machineIDEntry);
                machineID = machineIDEntryInt;
            }
            catch (NumberFormatException e)
            {
                Alerts.inputError("machine", "numbers").showAndWait();
                machineCompanyField.setText("");
                return;
            }
            return;
        }
        else{
            String companyNameEntry = machineCompanyField.getText();
            if (!companyNameEntry.matches("[a-zA-Z0-9 ]+")) {
                Alerts.inputError("company name", "alphanumeric names").showAndWait();
                machineCompanyField.setText("");
                return;
            }
            company = companyNameEntry;
            return;
        }
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMinInventoryField(ActionEvent actionEvent) {
        String minInventoryEntry = minInventoryField.getText();
        try
        {
            int minInventoryFieldInt;
            minInventoryFieldInt = Integer.parseInt(minInventoryEntry);
            min = minInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            minInventoryField.setText("");
            return;
        }
        return;
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onSaveButton(ActionEvent actionEvent) throws IOException {
        Inventory.addPart(ID_COUNTER, name, price, stock, min, max, machineID, company);

        //This resets all the class variables to for the next potential part.
        //The save button will filter by these 0s and ""s.
        //If they exist, save will not be allowed.
        int id = 0;
        String name = "";
        float price = 0;
        int stock = 0;
        int min = 0;
        int max = 0;
        String company = "";
        int machineID = 0;
        ID_COUNTER = ID_COUNTER + 1;

        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }



    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Optional<ButtonType> result = Alerts.cancel.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Inventory Management System");
            stage.setScene(scene);
            stage.show();
        }
    }
}
