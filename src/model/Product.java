package model;

import controller.MainScreenController;
import javafx.collections.ObservableList;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts;

    public Product(int id, String name, double price, int stock, int min, int max, ObservableList associatedParts){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;

    }

    /** This method gets the part ID.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /** This method sets the part ID.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**  This method gets the part name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** This method sets the part name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**  This method gets the part price.
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /** This method sets the part price.
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /** This method gets the part inventory level.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**  This method sets the part inventory level.
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** This method gets the part minimum inventory level.
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /** This method sets the part minimum inventory level.
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**  This method gets the part maximum inventory level.
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /** This method sets the part maximum inventory level.
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**  This method gets the product's associated list of parts.
     * @return the list of associated parts.
     */
    public ObservableList<Part> getAssociatedParts() { return associatedParts;}

    /** This method sets the product's associated list of parts.
     * @param associatedParts the list of parts.
     */
    public void setAssociatedParts(ObservableList<Part> associatedParts) {this.associatedParts = associatedParts;}




    /** This method returns a list of all current products for use in other methods.
     *
     * @return an observable list of all products in the product list.
     */
    public static ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }
}
