package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** FUTURE ENHANCEMENT
 * The ID_COUNTER, on line 25, is used to give ID numbers to both parts and products. It is incremented by 1 each time a
 * part or product is saved, and that newly incremented number becomes that new creation's ID. This means that parts and
 * products share the same pool of ID numbers. I think it would make more sense to give them separate counters so the ID
 * number makes it immediately obvious if you are looking at a part or a product. Maybe products could start at 1000 or
 * something similar. In addition, I think it would also be useful if InHouse and Outsourced products were immediately
 * distinguishable by ID. Maybe an "I" or "O" could be appended to respective numbers.
 *
 * Javadoc files are all found in src/main/. View in browser using src/main/index.html
 * This is the main class, and entry to the program.
 *
 */
public class Main extends Application {
    static public int ID_COUNTER = 1;
    @Override
    public void start(Stage stage) throws Exception {

        //addTestData();
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        stage.setTitle("C482 Performance Assessment");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }

    /** This method adds test data for debugging.
     * Do not use in production. This is only for debugging.
      */
    private void addTestData() {
        Inventory.makeNewInHouse(900, "fork", 1.99, 10, 5, 15, 7);

        Inventory.makeNewInHouse(901, "spoon", 2.99, 10, 5, 15, 8);
        Inventory.makeNewInHouse(902, "knife", 3.99, 10, 5, 15, 9);
        Inventory.makeNewOutSourced(903, "pot", 10.99, 3, 1, 5, "Staub");
        Inventory.makeNewOutSourced(904, "pan", 11.99, 3, 1, 5, "Staub");
        Inventory.makeNewOutSourced(905, "kettle", 20.99, 3, 1, 5, "tea");

        ObservableList<Part> fakePartList = FXCollections.observableArrayList();
        ObservableList<Part> fakePartList2 = FXCollections.observableArrayList();

        Inventory.addProduct(1, "Starter Set", 15.99, 2, 1, 5, fakePartList);
        Inventory.addProduct(2, "New Home", 75.99, 3, 1, 5, fakePartList2);

    }


    /** This is the main method that runs when the program launches.
     * Launch tells JavaFX to take over and launch a window.
     * @param args Currently args is just a placeholder.
     */
    public static void main(String[] args){
       launch(args);
    }
}
