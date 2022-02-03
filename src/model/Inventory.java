package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static controller.AddPartController.inHouseToggle;
import static main.Main.ID_COUNTER;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This method returns a list of all current parts for use in other methods.
     *
     * @return an observable list of all parts in the part list.
     */
    public static ObservableList<Part> getAllParts() {
        return Inventory.allParts;
    }

    /** This method returns a list of all current products for use in other methods.
     *
     * @return an observable list of all products in the product list.
     */
    public static ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }

    /**
     *
     */
    public static void addPart(int ID_COUNTER, String name, float price, int stock, int min, int max, int machineID, String company){
        if(inHouseToggle){
            makeNewInHouse(ID_COUNTER, name, price, stock, min, max, machineID);
        }
        else{
            makeNewOutSourced(ID_COUNTER, name, price, stock, min, max, company);
        }

    }

    /**
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param company
     * @return
     */
    public static void makeNewOutSourced(int id, String name, double price, int stock, int min, int max, String company) {
        Outsourced newOutSourced = new Outsourced(id, name, price, stock, min, max, company);
        Inventory.allParts.add(newOutSourced);
    }

    /**
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machineID
     * @return
     */
    public static void makeNewInHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        InHouse newInHouse = new InHouse(id, name, price, stock, min, max, machineID);
        Inventory.allParts.add(newInHouse);
    }
}
