package model;

public class InHouse extends Part{

    private String machineID;

    public InHouse(int id, String name, double price, int stock, int min, int max, String machineID) {
        super(id, name, price, stock, min, max);

        this.machineID = machineID;
    }
}
