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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This class controls the FXML file for the main screen.
 *
 */
public class MainScreenController implements Initializable {
    public TableView partsTable;
    public TableColumn partIDCol;
    public TableColumn partNameCol;
    public TableColumn partInventoryCol;
    public TableColumn partCostUnitCol;
    public Button addPart;
    public Button modifyPart;
    public Button deletePart;
    public TableView productsTable;
    public TableColumn productIDCol;
    public TableColumn productNameCol;
    public TableColumn productInventoryCol;
    public TableColumn productCostUnitCol;
    public Button addProduct;
    public Button modifyProduct;
    public Button deleteProduct;
    public Button mainScreenExit;
    public TextField partSearchBar;
    public TextField productSearchBar;


    public static InHouse passableInHouse;
    public static Outsourced passableOutsourced;
    public static Product passableProduct;



    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * .setItems associates the parts and products observable lists with their respective tables.
     * @param url Not necessary to specify.
     * @param resourceBundle Not necessary to specify.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am initialized");
        partsTable.setItems(Inventory.getAllParts());
        productsTable.setItems(Inventory.getAllProducts());

        partIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partCostUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productCostUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


    /** This method changes user to the addPart screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }

    /** This method changes user to the modifyPart screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModifyPart(ActionEvent actionEvent) throws IOException{
        Part SP = (Part)partsTable.getSelectionModel().getSelectedItem();

        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();

        if(SP instanceof InHouse){
            passableInHouse = (InHouse)SP;
        }
        else{
            passableOutsourced = (Outsourced)SP;
        }
    }

    /** This method is called when Delete button is clicked under the parts table.
     * A confirmation box is created, and delete is not completed unless OK is clicked.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onDeletePart(ActionEvent actionEvent) {
        Part SP = (Part)partsTable.getSelectionModel().getSelectedItem();
        boolean delete = Inventory.deletePart(SP);
        if(delete){
            partsTable.setItems(Inventory.getAllParts());
        }
    }

    /** This method changes user to the addProduct screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onAddProduct(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }

    /** This method changes user to the modifyProduct screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    /** This method is called when Delete button is clicked under the products table.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onDeleteProduct(ActionEvent actionEvent) {
        Product SP = (Product)productsTable.getSelectionModel().getSelectedItem();
        boolean delete = Inventory.deleteProduct(SP);
        if(delete){
            productsTable.setItems(Inventory.getAllProducts());
        }
    }

    /** This method is called when Exit button is clicked on the main screen.
     * It exits the program.
     * @param actionEvent Not necessary to specify.
     */
    public void onMainScreenExit(ActionEvent actionEvent) {

        System.exit(0);
    }

    /** This method gets text the user types in the search bar and displays parts that match.
     * It calls a name search and an ID search method to check by both of those.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onTypePartSearch(ActionEvent actionEvent) {
        String query = partSearchBar.getText();

        ObservableList<Part> parts = Inventory.lookupPart(query);
        partsTable.setItems(parts);
        partSearchBar.setText("");

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
                  partsTable.setItems(Inventory.getAllParts());
              }
          }
          catch (NumberFormatException n){
              //System.out.println("No Part containing " + query + " was found");
              Alerts.noSuchPart.showAndWait();
          }
        }
        if(partSearchBar.getText() == null){
            partsTable.setItems(Inventory.getAllParts());
        }
    }

    /** This method gets text the user types in the search bar and displays products that match.
     * It calls a name search and an ID search method to check by both of those.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onTypeProductSearch(ActionEvent actionEvent) {
        String query = productSearchBar.getText();

        ObservableList<Product> products = Inventory.lookupProduct(query);
        productsTable.setItems(products);
        productSearchBar.setText("");

        if(products.isEmpty()){
            try {
                int ID = Integer.parseInt(query);
                Product product = Inventory.lookupProduct(ID);
                if(product != null){
                    products.add(product);
                }
                else{
                    //System.out.println("No Product containing " + query + " was found");
                    Alerts.noSuchProduct.showAndWait();
                    productsTable.setItems(Inventory.getAllProducts());
                }
            }
            catch (NumberFormatException n){
                //System.out.println("No Product containing " + query + " was found");
                Alerts.noSuchProduct.showAndWait();
            }
        }
        if(productSearchBar.getText() == null){
            productsTable.setItems(Inventory.getAllProducts());
        }
    }
}
