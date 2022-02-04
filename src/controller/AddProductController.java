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
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/** This class controls the addProduct FXML screen.
 *
 */
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

    private ObservableList<Part> allParts = Inventory.getAllParts();
    //private ObservableList<Part> associatedParts = Product.getAllAssociatedParts();

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProdTable.setItems(allParts);
        addProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        //addProdAssocTable.setItems(Product.getAllAssociatedParts());
        addProdAssocIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdAssocNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdAssocInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdAssocCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    /** This method takes a user provided string and searches for matching parts by name.
     *-----------CHANGE/MOVE ME-------------
     * @param partialName This is a user-typed string.
     * @return This is a partial list of parts, containing those that meet the criteria.
     */
    private ObservableList<Part> searchByPartName(String partialName){
        ObservableList<Part> partNameList = FXCollections.observableArrayList();
        ObservableList<Part> allParts = Inventory.getAllParts();
        for(Part part : allParts){
            if(part.getName().contains(partialName)){
                partNameList.add(part);
            }
        }
        return partNameList;
    }

    /** This method takes a user provided string and searches for matching parts by ID.
     *-----------CHANGE/MOVE ME-------------
     * @param ID This is a user-typed string.
     * @return This is a partial list of parts, containing those that meet the criteria.
     */
    private Part getPartByID(int ID){
        ObservableList<Part> allParts = Inventory.getAllParts();
        for(Part part : allParts){
            if (part.getId() == ID){
                return part;
            }
        }
        return null;
    }

    /** This method gets text the user types in the search bar and displays parts that match.
     * It calls a name search and an ID search method to check by both of those.
     * -----------CHANGE/MOVE ME-------------
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
                    addProdTable.setItems(Inventory.getAllParts());
                }
            }
            catch (NumberFormatException n){
                //System.out.println("No Part containing " + query + " was found");
                Alerts.noSuchPart.showAndWait();
            }
        }
        if(addProductSearchField.getText() == null){
            addProdTable.setItems(Inventory.getAllParts());
        }
    }

    /** This method is called when the name text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdName(ActionEvent actionEvent) {
    }

    /** This method is called when the inventory text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdInv(ActionEvent actionEvent) {
    }

    /** This method is called when the ID text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdID(ActionEvent actionEvent) {
    }

    /** This method is called when the save button is clicked. It changes the user to the main screen.
     * It also calls methods that create the Product from the screen's text fields.
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

    /** This method is called when the cancel button is clicked. It discards typed information and changes to main screen.
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

    /** This method is called when the minimum text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdMin(ActionEvent actionEvent) {
    }

    /** This method is called when the maximum text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdMax(ActionEvent actionEvent) {
    }

    /** This method is called when the price/cost text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdCost(ActionEvent actionEvent) {
    }

    /** This method is
     * -----------CHANGE/MOVE ME-------------
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdAddAssocPart(ActionEvent actionEvent) {
        Part part = (Part)addProdTable.getSelectionModel().getSelectedItem();
        //Product.addAssociatedParts(part);
    }

    /** This method is
     * -----------CHANGE/MOVE ME-------------
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdRemoveAssocPart(ActionEvent actionEvent) throws IOException {
        Part part = (Part)addProdAssocTable.getSelectionModel().getSelectedItem();
        if(part == null) {
            Alerts.noneSelected.showAndWait();
            return;
        }
        Optional<ButtonType> result = Alerts.remove.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            //associatedParts.remove(part);
            allParts.add(part);
            }
        }
    }

