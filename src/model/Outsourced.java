package model;

import controller.MainScreenController;
import javafx.collections.ObservableList;

/** This is a concrete subclass of Part.
 * Objects in this class have a company name in addition to the Part parameters.
 */
public class Outsourced extends Part{

    private String company;

    public Outsourced(int id, String name, double price, int stock, int min, int max, String company) {
        super(id, name, price, stock, min, max);

        this.company = company;
    }
}
