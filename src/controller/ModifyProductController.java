package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.MainScreenController.parts;

public class ModifyProductController implements Initializable {
    public TextField modProductSearchField;
    public TextField modProdName;
    public TextField modProdInv;
    public TextField modProdID;
    public Button modProdSave;
    public Button modProdCancel;
    public TextField modProdMin;
    public TextField modProdMax;
    public TextField modProdCost;
    public Button modProdAddAssocPart;
    public TableView modProdTable;
    public TableColumn modProdIDCol;
    public TableColumn modProdNameCol;
    public TableColumn modProdInvCol;
    public TableColumn modProdCostCol;
    public Button modProdRemoveAssocPart;
    public TableView modProdAssocTable;
    public TableColumn modProdAssocIDCol;
    public TableColumn modProdAssocNameCol;
    public TableColumn modProdAssocInvCol;
    public TableColumn modProdAssocCostCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modProdTable.setItems(parts);
        modProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    public void onModProductSearchField(ActionEvent actionEvent) {
    }

    public void onModProdName(ActionEvent actionEvent) {
    }

    public void onModProdInv(ActionEvent actionEvent) {
    }

    public void onModProdID(ActionEvent actionEvent) {
    }

    public void onModProdSave(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public void onModProdCancel(ActionEvent actionEvent) throws IOException {
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

    public void onModProdMin(ActionEvent actionEvent) {
    }

    public void onModProdMax(ActionEvent actionEvent) {
    }

    public void onModProdCost(ActionEvent actionEvent) {
    }

    public void onModProdAddAssocPart(ActionEvent actionEvent) {
    }

    public void onModProdRemoveAssocPart(ActionEvent actionEvent) {
    }
}
