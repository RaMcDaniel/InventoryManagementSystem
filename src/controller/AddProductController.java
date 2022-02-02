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

public class AddProductController implements Initializable {
    public TextField addProductSearchField;
    public TextField addProdName;
    public TextField addProdInv;
    public TextField addProdID;
    public Button prodSave;
    public Button prodCancel;
    public TextField addProdMin;
    public TextField addProdMax;
    public TextField addProdCost;
    public Button addProdAddAssocPart;
    public TableColumn addProdIDCol;
    public TableColumn addProdNameCol;
    public TableColumn addProdInvCol;
    public TableColumn addProdCostCol;
    public Button addProdRemoveAssocPart;
    public TableColumn addProdAssocIDCol;
    public TableColumn addProdAssocNameCol;
    public TableColumn addProdAssocInvCol;
    public TableColumn addProdAssocCostCol;
    public TableView addProdAssocTable;
    public TableView addProdTable;

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url PENDING
     * @param resourceBundle PENDING
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /** This method
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProductSearchField(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdName(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdInv(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdID(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onProdSave(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onProdCancel(ActionEvent actionEvent) throws IOException {
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

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdMin(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdMax(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdCost(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdAddAssocPart(ActionEvent actionEvent) {
    }

    /** This method is
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdRemoveAssocPart(ActionEvent actionEvent) {
    }
}

