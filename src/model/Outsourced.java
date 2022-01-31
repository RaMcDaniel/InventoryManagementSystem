package model;

public class Outsourced extends Part{

    private String company;

    public Outsourced(int id, String name, double price, int stock, int min, int max, String company) {
        super(id, name, price, stock, min, max);

        this.company = company;
    }
}
