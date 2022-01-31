package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    /** This method is auto-created by extending Initializable.
     * It is the first thing in this object to be called.
     * @param url PENDING
     * @param resourceBundle PENDING
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am initialized");

    }

    /** This method is called when Add button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onAddPart(ActionEvent actionEvent) {
    }

    /** This method is called when Modify button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onModifyPart(ActionEvent actionEvent) {
    }

    /** This method is called when Delete button is clicked under the parts table.
     *
     * @param actionEvent
     */
    public void onDeletePart(ActionEvent actionEvent) {
    }

    /** This method is called when Add button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onAddProduct(ActionEvent actionEvent) {
    }

    /** This method is called when Modify button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onModifyProduct(ActionEvent actionEvent) {
    }

    /** This method is called when Delete button is clicked under the products table.
     *
     * @param actionEvent
     */
    public void onDeleteProduct(ActionEvent actionEvent) {
    }
}
