package model;

/** This class pertains to the in-house subset of parts. It is a subclass of parts.
 *
 */
public class InHouse extends Part{

    private int machineID;

    /**  This is the constructor for in-house parts.
     *
     * @param id the part's ID
     * @param name the part's name
     * @param price the part's price
     * @param stock the number of part in stock
     * @param min the minimum number of part allowed in stock
     * @param max the maximum number of part allowed in stock
     * @param machineID the ID of the machine the part was created on
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);

        this.machineID = machineID;
    }

    /** This sets the machine ID when creating a new part.
     *
     * @param machineID the ID of the machine the part was created on
     */
    public void setMachineID(int machineID){
        this.machineID = machineID;
    }


    /** This returns the machine ID of the selected part.
     *
     * @return machine ID
     */
    public int getMachineID(){
        return machineID;
    }


}
