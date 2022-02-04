package model;

import javafx.scene.control.Alert;

/** This class contains alerts that are referenced elsewhere in the program.
 * Alerts include notifications that search results are null,
 * warnings before deleting or removing objects,
 * and error messages in case of inappropriate user input.
 */
public class Alerts {

    public static Alert inventory = new Alert(Alert.AlertType.ERROR, "Inventory must be greater than or equal to minimum. Inventory must be less than or equal to maximum.");
    public static Alert cancel = new Alert(Alert.AlertType.CONFIRMATION, "'Cancel' will lose all work on this page and return to main. Would you like to continue?");
    public static Alert noSuchPart = new Alert(Alert.AlertType.ERROR, "No part found matching that criteria");
    public static Alert noSuchProduct = new Alert(Alert.AlertType.ERROR, "No product found matching that criteria");
    public static Alert delete = new Alert(Alert.AlertType.CONFIRMATION, "This will delete selection. Would you like to delete and continue?");
    public static Alert remove = new Alert(Alert.AlertType.CONFIRMATION, "This will remove selection. Would you like to remove and continue?");
    public static Alert noneSelected = new Alert(Alert.AlertType.ERROR, "No selection is highlighted. Nothing was deleted.");
    public static Alert noModSelected = new Alert(Alert.AlertType.ERROR, "No selection is highlighted. Highlight a part to modify.");

    /** This is a general purpose alert creator. A popup box appears telling the user how to correct their input.
     * It can be generalized to any field in the program.
     * @param inputField The field with the inappropriate input.
     * @param howToCorrect A string describing acceptable inputs.
     * @return An alert describing to user how to fix input.
     */
    public static Alert inputError (String inputField, String howToCorrect){
        String fullWarning = String.format("Please correct %s. This field only accepts: %s", inputField, howToCorrect);
        Alert inputError = new Alert(Alert.AlertType.ERROR, fullWarning);
        return inputError;
    }

}
