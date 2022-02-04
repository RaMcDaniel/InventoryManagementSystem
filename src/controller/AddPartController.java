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

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static main.Main.ID_COUNTER;

/** This class is the controller for the addPart FXML screen.
 *
 */
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
    double price;
    int stock;
    int min;
    int max;
    String company;
    int machineID;
    public static boolean inHouseToggle = true;

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
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

    /** When something is typed in this field, it is validated for alphanumeric characters and saved if valid.
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

    /**  When something is typed in this field, it is validated for integer characters and saved if valid.
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

    /**  When something is typed in this field, it is validated for double characters and saved if valid.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onPriceField(ActionEvent actionEvent) {
        String priceEntry = priceField.getText();
        try
        {
            double priceFieldInt;
            priceFieldInt = Double.parseDouble(priceEntry);

            price = priceFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            priceField.setText("");
            return;
        }
        return;
    }

    /**  When something is typed in this field, it is validated for integer characters and saved if valid.
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

    /**  When something is typed in this field, it is validated, and saved if valid.
     * It validates for machineID integers or company name Strings depending on the inHouse toggle.
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

    /**  When something is typed in this field, it is validated for integer characters and saved if valid.
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

    /** When the save button is clicked, it saves the part information to a new part object, and clears the variables.
     * It then returns to the main screen.
     * @param actionEvent Not necessary to specify.
     */
    public void onSaveButton(ActionEvent actionEvent) throws IOException {

        if(!(name!=null && price!=0 && stock!=0 && min!=0 && max!=0 && (machineID!=0 || company!=null))){
            Alerts.inputError("form", "all fields must be completed. Press 'Enter' on keyboard after each to register.").showAndWait();
            return;
        }
        if(!(min <= stock && stock <= max)){
            Alerts.inventory.showAndWait();
            return;
        }
        Inventory.addPart(ID_COUNTER, name, price, stock, min, max, machineID, company);

        ID_COUNTER = ID_COUNTER + 1;

        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }



    /** When cancel is clicked, nothing is saved or created, and you return to the main screen.
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
