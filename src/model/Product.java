package model;

import javafx.collections.ObservableList;

/** This class pertains to products, and the methods used to view and create them.
 *
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts;

    /** This is a constructor for a product item.
     *
     * @param id the product's ID
     * @param name the product's name
     * @param price the product's price
     * @param stock the number of the product in stock
     * @param min the minimum number of product allowed in stock
     * @param max the maximum number of product allowed in stock
     * @param associatedParts a list of parts associated with the product
     */
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
     * @return the stock level
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
     * @return the min part inventory level
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
     * @return the max inventory level
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

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
     */

    /** This method adds a part to the product's associated list of parts.
     * @param associatedParts the part added

    public void addAssociatedParts(Part part) {
    }
     */

    /**  This method deletes a part from the product's associated list of parts.
     *
     * @param selectedAssociatedPart the part deleted
     * @return returns true if completed

    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        return boolean;
    }
     */

}
