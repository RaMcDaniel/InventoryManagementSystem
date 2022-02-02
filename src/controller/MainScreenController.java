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
import model.Part;
import model.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

    public static ObservableList<Part> parts = FXCollections.observableArrayList();
    public static ObservableList<Part> products = FXCollections.observableArrayList();



    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * .setItems associates the parts and products observable lists with their respective tables.
     * @param url PENDING
     * @param resourceBundle PENDING
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am initialized");
        partsTable.setItems(parts);
        productsTable.setItems(products);

        partIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partCostUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productCostUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

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

    /** This method takes a user provided string and searches for matching products by name.
     *
     * @param partialName This is a user-typed string.
     * @return This is a partial list of products, containing those that meet the criteria.
     */
    private ObservableList<Part> searchByProductName(String partialName){
        ObservableList<Part> productNameList = FXCollections.observableArrayList();
        ObservableList<Part> allProducts = Part.getAllProducts();
        for(Part product : allProducts){
            if(product.getName().contains(partialName)){
                productNameList.add(product);
            }
        }
        return productNameList;
    }

    /** This method takes a user provided string and searches for matching products by ID.
     *
     * @param ID This is a user-typed string.
     * @return This is a partial list of products, containing those that meet the criteria.
     */
    private Part getProductByID(int ID){
        ObservableList<Part> allProducts = Part.getAllProducts();
        for(Part product : allProducts){
            if (product.getId() == ID){
                return product;
            }
        }
        return null;
    }

    /** This method is called when Add button is clicked under the parts table.
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

    /** This method is called when Modify button is clicked under the parts table.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModifyPart(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();
    }

    /** This method is called when Delete button is clicked under the parts table.
     * A confirmation box is created, and delete is not completed unless OK is clicked.
     * @param actionEvent Not necessary to specify.
     */
    public void onDeletePart(ActionEvent actionEvent) {
        Part SP = (Part)partsTable.getSelectionModel().getSelectedItem();
        if (SP==null){
            Alerts.noneSelected.showAndWait();
            return;
        }
        Optional<ButtonType> result = Alerts.delete.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            parts.remove(SP);
            //System.out.println(SP.getName() + " has been removed.");
        }
        partsTable.setItems(Part.getAllParts());
    }

    /** This method is called when Add button is clicked under the products table.
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

    /** This method is called when Modify button is clicked under the products table.
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
        Part SP = (Part)productsTable.getSelectionModel().getSelectedItem();
        if (SP==null){
            Alerts.noneSelected.showAndWait();
            return;
        }
        Optional<ButtonType> result = Alerts.delete.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            products.remove(SP);
            //System.out.println(SP.getName() + " has been removed.");
        }

        productsTable.setItems(Part.getAllProducts());
    }

    /** This method is called when Exit button is clicked on the main screen.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onMainScreenExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    /** This method gets text the user types in the search bar and displays parts that match.
     * It calls a name search and an ID search method to check by both of those.
     * @param actionEvent Not necessary to specify.
     */
    public void onTypePartSearch(ActionEvent actionEvent) {
        String query = partSearchBar.getText();

        ObservableList<Part> parts = searchByPartName(query);
        partsTable.setItems(parts);
        partSearchBar.setText("");

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
                  partsTable.setItems(Part.getAllParts());
              }
          }
          catch (NumberFormatException n){
              //System.out.println("No Part containing " + query + " was found");
              Alerts.noSuchPart.showAndWait();
          }
        }
        if(partSearchBar.getText() == null){
            partsTable.setItems(Part.getAllParts());
        }
    }

    /** This method gets text the user types in the search bar and displays products that match.
     * It calls a name search and an ID search method to check by both of those.
     * @param actionEvent Not necessary to specify.
     */
    public void onTypeProductSearch(ActionEvent actionEvent) {
        String query = productSearchBar.getText();

        ObservableList<Part> products = searchByProductName(query);
        productsTable.setItems(products);
        productSearchBar.setText("");

        if(products.isEmpty()){
            try {
                int ID = Integer.parseInt(query);
                Part product = getProductByID(ID);
                if(product != null){
                    products.add(product);
                }
                else{
                    //System.out.println("No Product containing " + query + " was found");
                    Alerts.noSuchProduct.showAndWait();
                    productsTable.setItems(Part.getAllProducts());
                }
            }
            catch (NumberFormatException n){
                //System.out.println("No Product containing " + query + " was found");
                Alerts.noSuchProduct.showAndWait();
            }
        }
        if(productSearchBar.getText() == null){
            productsTable.setItems(Part.getAllProducts());
        }
    }
}
