package controller;

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

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static main.Main.ID_COUNTER;


/** This class controls the modifyProduct FXML screen.
 *
 */
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

    public static int prodModId;
    public static String prodModName;
    public static int prodModInventory;
    public static double prodModPrice;
    public static int prodModMin;
    public static int prodModMax;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prodModId = MainScreenController.passableProduct.getId();
        modProdID.setText(Integer.toString(prodModId));
        prodModName = MainScreenController.passableProduct.getName();
        modProdName.setText(prodModName);
        prodModInventory = MainScreenController.passableProduct.getStock();
        modProdInv.setText(Integer.toString(prodModInventory));
        prodModPrice = MainScreenController.passableProduct.getPrice();
        modProdCost.setText(Double.toString(prodModPrice));
        prodModMin = MainScreenController.passableProduct.getMin();
        modProdMin.setText(Integer.toString(prodModMin));
        prodModMax = MainScreenController.passableProduct.getMax();
        modProdMax.setText(Integer.toString(prodModMax));


        modProdTable.setItems(Inventory.getAllParts());
        modProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        modProdAssocTable.setItems(MainScreenController.passableProduct.getAllAssociatedParts());
        modProdAssocIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdAssocNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdAssocInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdAssocCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


    /** This method gets text the user types in the search bar and displays parts that match.
     * It calls a name search and an ID search method to check by both of those.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProductSearchField(ActionEvent actionEvent) {
        String query = modProductSearchField.getText();

        ObservableList<Part> parts = Inventory.lookupPart(query);
        modProdTable.setItems(parts);
        modProductSearchField.setText("");

        if(parts.isEmpty()){
            try {
                int ID = Integer.parseInt(query);
                Part part = Inventory.lookupPart(ID);
                if(part != null){
                    parts.add(part);
                }
                else{
                    //System.out.println("No Part containing " + query + " was found");
                    Alerts.noSuchPart.showAndWait();
                    modProdTable.setItems(Inventory.getAllParts());
                }
            }
            catch (NumberFormatException n){
                //System.out.println("No Part containing " + query + " was found");
                Alerts.noSuchPart.showAndWait();
            }
        }
        if(modProductSearchField.getText() == null){
            modProdTable.setItems(Inventory.getAllParts());
        }
    }

    /** This method is called when the name text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdName(ActionEvent actionEvent) {
        String nameEntry = modProdName.getText();
        if (!nameEntry.matches("[a-zA-Z0-9 ]+")) {
            Alerts.inputError("name", "alphanumeric names").showAndWait();
            modProdName.setText("");
            return;
        }
        prodModName = nameEntry;
        return;
    }

    /** This method is called when the inventory text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdInv(ActionEvent actionEvent) {
        String inventoryEntry = modProdInv.getText();
        try
        {
            int inventoryFieldInt;
            inventoryFieldInt = Integer.parseInt(inventoryEntry);
            prodModInventory = inventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("inventory", "numbers").showAndWait();
            modProdInv.setText("");
            return;
        }
        return;
    }


    /** This method calls methods to save products, and switches the user to the main screen.
     *
     * @param actionEvent Not necessary tp specify.
     * @throws IOException
     */
    public void onModProdSave(ActionEvent actionEvent) throws IOException {

        if(!(prodModName!=null && prodModPrice!=0 && prodModInventory!=0 && prodModMin!=0 && prodModMax!=0)) {
            Alerts.inputError("form", "all fields must be completed. Press 'Enter' on keyboard after each to register.").showAndWait();
            return;
        }
        if(!(prodModMin <= prodModInventory && prodModInventory <= prodModMax)) {
            Alerts.inventory.showAndWait();
            return;
        }

        //THIS IS WRONG. IT DUPLICATES THE PRODUCT
        //Inventory.addProduct(ID_COUNTER, name, price, stock, min, max, associatedParts);

        ID_COUNTER = ID_COUNTER + 1;



        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    /** This method discards information in text field and returns user to the main screen.
     *
     * @param actionEvent Not necessary to specify.
     * @throws IOException
     */
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

    /** This method is called when the minimum field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdMin(ActionEvent actionEvent) {
        String minInventoryEntry = modProdMin.getText();
        try
        {
            int minInventoryFieldInt;
            minInventoryFieldInt = Integer.parseInt(minInventoryEntry);
            prodModMin = minInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            modProdMin.setText("");
            return;
        }
        return;
    }

    /** This method is called when the maximum field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdMax(ActionEvent actionEvent) {
        String maxInventoryEntry = modProdMax.getText();
        try
        {
            int maxInventoryFieldInt;
            maxInventoryFieldInt = Integer.parseInt(maxInventoryEntry);
            prodModMax = maxInventoryFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("max inventory", "numbers").showAndWait();
            modProdMax.setText("");
            return;
        }
        return;
    }

    /** This method is called when the price/cost field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdCost(ActionEvent actionEvent) {
        String priceEntry = modProdCost.getText();
        try
        {
            double priceFieldInt;
            priceFieldInt = Double.parseDouble(priceEntry);

            prodModPrice = priceFieldInt;
        }
        catch (NumberFormatException e)
        {
            Alerts.inputError("min inventory", "numbers").showAndWait();
            modProdCost.setText("");
            return;
        }
        return;
    }

    /** This method is called when the add associated part button is clicked.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdAddAssocPart(ActionEvent actionEvent) {
    }

    /** This method is called when the remove associated part button is clicked.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdRemoveAssocPart(ActionEvent actionEvent) {
    }

    /** Method for editing ID field.
     * It is not editable.
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdID(ActionEvent actionEvent) {
    }
}
