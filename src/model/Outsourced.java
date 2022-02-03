package model;

/** This class pertains to the outsourced subset of parts. It is a subclass of parts.
 *
 */
public class Outsourced extends Part{

    private String company;

    /** This is the constructor for outsourced parts.
     *
     * @param id the part's ID
     * @param name the part's name
     * @param price the part's price
     * @param stock the number of part in stock
     * @param min the minimum number of part allowed in stock
     * @param max the maximum number of part allowed in stock
     * @param companyName the name of the company the part was purchased from.
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);

        this.company = companyName;
    }


    /** This sets the name of the company when creating a new part.
     *
     * @param companyName the name of the company the part was purchased from.

    public void setCompanyName(string companyName){

    }
     */

    /** This returns the company name of the selected part.
     *
     * @return company name

    public String getCompanyName(){
    return companyName;
    }
     */

}
