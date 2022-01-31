package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Part;

import java.net.URL;
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

    public static ObservableList<Part> parts = FXCollections.observableArrayList();
    public static ObservableList<Part> products = FXCollections.observableArrayList();

    /** This method adds parts objects to parts list.
     * USELESS??? BC not static? DELETE?
     * @param part The part to be added to parts list.
     */
    public void addPart(Part part){
        parts.add(part);
    }

    /** This method adds parts objects to products list.
     * USELESS??? BC not static? DELETE?
     * @param product The product to be added to products list.
     */
    public void addProduct(Part product){
        products.add(product);
    }

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

    /** This method is called when Add button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onAddPart(ActionEvent actionEvent) {
        System.out.println("clicky1");
    }

    /** This method is called when Modify button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onModifyPart(ActionEvent actionEvent) {
        System.out.println("clicky2");
    }

    /** This method is called when Delete button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onDeletePart(ActionEvent actionEvent) {
        System.out.println("clicky3");
    }

    /** This method is called when Add button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onAddProduct(ActionEvent actionEvent) {
        System.out.println("clicky4");
    }

    /** This method is called when Modify button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onModifyProduct(ActionEvent actionEvent) {
        System.out.println("clicky5");
    }

    /** This method is called when Delete button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onDeleteProduct(ActionEvent actionEvent) {
        System.out.println("clicky6");
    }

    /** This method is called when Exit button is clicked on the main screen.
     *
     * @param actionEvent
     */
    public void onMainScreenExit(ActionEvent actionEvent) {
        System.out.println("clicky exit");
    }
}
