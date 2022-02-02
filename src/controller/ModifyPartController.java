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
    public void onInHouseRadioMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onOutsourcedRadioMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onNameFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onPriceFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMaxInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMachineCompanyFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMinInventoryFieldMod(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onSaveButtonMod(ActionEvent actionEvent) {
    }

    /**
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
