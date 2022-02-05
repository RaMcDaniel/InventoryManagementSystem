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

import static main.Main.ID_COUNTER;

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

    String name;
    double price;
    int stock;
    int min;
    int max;

    private ObservableList<Part> allParts = Inventory.getAllParts();
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addProdTable.setItems(Inventory.getAllParts());
        addProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProdAssocTable.setItems(associatedParts);
        addProdAssocIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdAssocNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdAssocInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdAssocCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));



    }


    /** This method gets text the user types in the search bar and displays parts that match.
     * It calls a name search and an ID search method to check by both of those.
     * -----------CHANGE/MOVE ME-------------
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProductSearchField(ActionEvent actionEvent) {
        String query = addProductSearchField.getText();

        ObservableList<Part> parts = Inventory.lookupPart(query);
        addProdTable.setItems(parts);
        addProductSearchField.setText("");

        if(parts.isEmpty()){
            try {
                int ID = Integer.parseInt(query);
                Part part = Inventory.lookupPart(ID);
                if(part != null){
                    parts.add(part);
                }
                else{
                    Alerts.noSuchPart.showAndWait();
                    addProdTable.setItems(Inventory.getAllParts());
                }
            }
            catch (NumberFormatException n){
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
        String nameEntry = addProdName.getText();
        if (!nameEntry.matches("[a-zA-Z0-9 ]+")) {
            Alerts.inputError("name", "alphanumeric names").showAndWait();
            addProdName.setText("");
            return;
        }
        name = nameEntry;
        return;
    }

    /** This method is called when the inventory text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdInv(ActionEvent actionEvent) {
        String inventoryEntry = addProdInv.getText();
        try
        {
            int inventoryFieldInt;
            inventoryFieldInt = Integer.parseInt(inventoryEntry);
            stock = inventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("inventory", "numbers").showAndWait();
            addProdInv.setText("");
            return;
        }
        return;
    }


    /** This method is called when the save button is clicked. It changes the user to the main screen.
     * It also calls methods that create the Product from the screen's text fields.
     * @param actionEvent Not necessary to specify.
     */
    public void onProdSave(ActionEvent actionEvent) throws IOException{

        if(!(name!=null && price!=0 && stock!=0 && min!=0 && max!=0)) {
            Alerts.inputError("form", "all fields must be completed. Press 'Enter' on keyboard after each to register.").showAndWait();
            return;
        }
        if(!(min <= stock && stock <= max)) {
            Alerts.inventory.showAndWait();
            return;
        }

        Inventory.addProduct(ID_COUNTER, name, price, stock, min, max, associatedParts);

        ID_COUNTER = ID_COUNTER + 1;



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
        String minInventoryEntry = addProdMin.getText();
        try
        {
            int minInventoryFieldInt;
            minInventoryFieldInt = Integer.parseInt(minInventoryEntry);
            min = minInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            addProdMin.setText("");
            return;
        }
        return;
    }

    /** This method is called when the maximum text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdMax(ActionEvent actionEvent) {
        String maxInventoryEntry = addProdMax.getText();
        try
        {
            int maxInventoryFieldInt;
            maxInventoryFieldInt = Integer.parseInt(maxInventoryEntry);
            max = maxInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("max inventory", "numbers").showAndWait();
            addProdMax.setText("");
            return;
        }
        return;
    }

    /** This method is called when the price/cost text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdCost(ActionEvent actionEvent) {
        String priceEntry = addProdCost.getText();
        try
        {
            double priceFieldInt;
            priceFieldInt = Double.parseDouble(priceEntry);

            price = priceFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            addProdCost.setText("");
            return;
        }
        return;
    }

    /** This method is
     * -----------CHANGE/MOVE ME-------------
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdAddAssocPart(ActionEvent actionEvent) {
        Part part = (Part)addProdTable.getSelectionModel().getSelectedItem();
        associatedParts.add(part);
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
            associatedParts.remove(part);
            }
        }

    /** Method for editing ID field.
     * It is not editable.
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProdID(ActionEvent actionEvent) {
    }
}

