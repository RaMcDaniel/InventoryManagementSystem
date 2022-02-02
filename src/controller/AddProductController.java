package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static controller.MainScreenController.parts;

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
        addProdTable.setItems(parts);
        addProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    /** This method takes a user provided string and searches for matching parts by name.
     *
     * @param partialName This is a user-typed string.
     * @return This is a partial list of parts, containing those that meet the criteria.
     */
    private ObservableList<Part> searchByPartName(String partialName){
        ObservableList<Part> partNameList = FXCollections.observableArrayList();
        ObservableList<Part> allParts = Part.getAllParts();
        for(Part part : allParts){
            if(part.getName().contains(partialName)){
                partNameList.add(part);
            }
        }
        return partNameList;
    }

    /** This method takes a user provided string and searches for matching parts by ID.
     *
     * @param ID This is a user-typed string.
     * @return This is a partial list of parts, containing those that meet the criteria.
     */
    private Part getPartByID(int ID){
        ObservableList<Part> allParts = Part.getAllParts();
        for(Part part : allParts){
            if (part.getId() == ID){
                return part;
            }
        }
        return null;
    }





    /** This method
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProductSearchField(ActionEvent actionEvent) {
        String query = addProductSearchField.getText();

        ObservableList<Part> parts = searchByPartName(query);
        addProdTable.setItems(parts);
        addProductSearchField.setText("");

        if(parts.isEmpty()){
            try {
                int ID = Integer.parseInt(query);
                Part part = getPartByID(ID);
                if(part != null){
                    parts.add(part);
                }
                else{
                    //System.out.println("No Part containing " + query + " was found");
                    Alerts.noSuchPart.showAndWait();
                    addProdTable.setItems(Part.getAllParts());
                }
            }
            catch (NumberFormatException n){
                //System.out.println("No Part containing " + query + " was found");
                Alerts.noSuchPart.showAndWait();
            }
        }
        if(addProductSearchField.getText() == null){
            addProdTable.setItems(Part.getAllParts());
        }
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

