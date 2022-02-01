package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

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

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url PENDING
     * @param resourceBundle PENDING
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInHouseRadio(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onOutsourcedRadio(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onNameField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInventoryField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onPriceField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMaxInventoryField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMachineCompanyField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMinInventoryField(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onSaveButton(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onCancelButton(ActionEvent actionEvent) {
    }
}
