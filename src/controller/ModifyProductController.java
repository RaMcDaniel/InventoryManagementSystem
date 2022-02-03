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

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modProdTable.setItems(Inventory.getAllParts());
        modProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdCostCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


    /** This method takes a user provided string and searches for matching parts by name.
     * -----------CHANGE/MOVE ME-------------
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
    public void onModProductSearchField(ActionEvent actionEvent) {
        String query = modProductSearchField.getText();

        ObservableList<Part> parts = searchByPartName(query);
        modProdTable.setItems(parts);
        modProductSearchField.setText("");

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
    }

    /** This method is called when the inventory text field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdInv(ActionEvent actionEvent) {
    }

    /** This method is called when the ID field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdID(ActionEvent actionEvent) {
    }

    /** This method calls methods to save products, and switches the user to the main screen.
     *
     * @param actionEvent Not necessary tp specify.
     * @throws IOException
     */
    public void onModProdSave(ActionEvent actionEvent) throws IOException {
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
    }

    /** This method is called when the maximum field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdMax(ActionEvent actionEvent) {
    }

    /** This method is called when the price/cost field is typed into.
     *
     * @param actionEvent Not necessary to specify.
     */
    public void onModProdCost(ActionEvent actionEvent) {
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
}
