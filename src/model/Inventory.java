package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static controller.AddPartController.inHouseToggle;

/** This class contains all stored part and product information, and methods to get and set related information.
 *
 */
public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This method returns a list of all current parts for use in other methods.
     * @return an observable list of all parts in the part list.
     */
    public static ObservableList<Part> getAllParts() {
        return Inventory.allParts;
    }

    /** This method returns a list of all current products for use in other methods.
     * @return an observable list of all products in the product list.
     */
    public static ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }

    /** This method adds a new product to the allProducts list in the inventory.
     *
     * @param id the product's ID
     * @param name the product's name
     * @param price the product's price
     * @param stock the number of the product in inventory
     * @param min the minimum number of product allowed in inventory
     * @param max the maximum number of product allowed in inventory
     * @param associatedParts the list of parts associated with the product
     */
    public static void addProduct(int id, String name, double price, int stock, int min, int max, ObservableList associatedParts){
        Product newProduct = new Product(id, name, price, stock, min, max, associatedParts);
        Inventory.allProducts.add(newProduct);

    }

    /** This is a generic method to add a part.
     * It calls methods for adding in-house or outsourced parts depending on the toggle on the add part page.
     */
    public static void addPart(int ID_COUNTER, String name, float price, int stock, int min, int max, int machineID, String company){
        if(inHouseToggle){
            makeNewInHouse(ID_COUNTER, name, price, stock, min, max, machineID);
        }
        else{
            makeNewOutSourced(ID_COUNTER, name, price, stock, min, max, company);
        }

    }

    /** This method adds a new outsourced part.
     *
     * @param id part ID - the global constant ID_COUNTER
     * @param name the part name
     * @param price the part's price
     * @param stock the amount of part in stock
     * @param min the minimum amount of stock allowed
     * @param max the maximum amount of stock allowed
     * @param company the company outsourced products are purchased from
     * @return
     */
    public static void makeNewOutSourced(int id, String name, double price, int stock, int min, int max, String company) {
        Outsourced newOutSourced = new Outsourced(id, name, price, stock, min, max, company);
        Inventory.allParts.add(newOutSourced);
    }

    /**  This method adds a new in-house part.
     *
     * @param id part ID - the global constant ID_COUNTER
     * @param name the part name
     * @param price the part's price
     * @param stock the amount of part in stock
     * @param min the minimum amount of stock allowed
     * @param max the maximum amount of stock allowed
     * @param machineID ID number of machine in-house parts are created on
     * @return
     */
    public static void makeNewInHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        InHouse newInHouse = new InHouse(id, name, price, stock, min, max, machineID);
        Inventory.allParts.add(newInHouse);
    }

    /** This method looks up a part by ID.
     *
     * @param partID the part's ID
     * @return a part object matching the ID specified
     */
    public static Part lookupPart(int partID){
        ObservableList<Part> allParts = Inventory.getAllParts();
        for(Part part : allParts){
            if (part.getId() == partID) {
                return part;
            }
        }
        return null;
    }


    /**  This method looks up a product by ID.
     *
     * @param ProductID the product's ID
     * @return a product object matching the ID specified

    public static Product lookupProduct(int ProductID){

        return Product;
    }
     */


    /**  This method looks up a part by name and displays a list of matching parts.
     *
     * @param partName a string provided by user
     * @return a list of matching parts.
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> partNameList = FXCollections.observableArrayList();
        ObservableList<Part> allParts = Inventory.getAllParts();
        for(Part part : allParts){
            if(part.getName().contains(partName)){
                partNameList.add(part);
            }
        }
        return partNameList;
    }


    /** This method looks up a product by name and displays a list of matching parts.
     *
     * @param productName a string provided by user
     * @return a list of matching products.

    public static ObservableList<Product> lookupPart(String productName){
        return ObservableList;
    }
     */

    /** This method updates a specific piece of a part's information.
     *
     * @param index which position in part's parameter list is being updated
     * @param selectedPart The part being updated

    public static void updatePart(int index, Part selectedPart){

    }
     */

    /**  This method updates a specific piece of a product's information.
     *
     * @param index  which position in product's parameter list is being updated
     * @param selectedProduct the product being updated

    public static void updateProduct(int index, Product selectedProduct){

    }
     */

    /** This method deletes a part from a list.
     *
     * @param selectedPart the part to be deleted
     * @return returns true if completed

    public static Boolean deletePart(Part selectedPart){
        return Boolean;
    }
     */

    /** This method deletes a product from a list.
     *
     * @param selectedProduct the product to be deleted
     * @return returns true if completed

    public static Boolean deleteProduct(Product selectedProduct){
        return Boolean;
    }
     */
}

