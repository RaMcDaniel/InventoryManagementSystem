package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import controller.MainScreenController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Product;

/** Main the main class, and entry to the program.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        
        addTestData();
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        stage.setTitle("C482 Performance Assessment");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }

    /** This method adds test data for debugging.
     * Do not use in production. This is only for debugging.
      */
    private void addTestData() {
        InHouse fork = new InHouse(900, "fork", 1.99, 10, 5, 15, "silverware");
        InHouse spoon = new InHouse(901, "spoon", 2.99, 10, 5, 15, "silverware");
        InHouse knife = new InHouse(902, "knife", 3.99, 10, 5, 15, "silverware");
        Outsourced pot = new Outsourced(903, "pot", 10.99, 3, 1, 5, "Staub");
        Outsourced pan = new Outsourced(904, "pan", 11.99, 3, 1, 5, "Staub");
        Outsourced kettle = new Outsourced(905, "kettle", 20.99, 3, 1, 5, "tea");

        ObservableList<Part> fakePartList = FXCollections.observableArrayList();
        fakePartList.add(fork);
        fakePartList.add(spoon);
        fakePartList.add(knife);

        ObservableList<Part> fakePartList2 = FXCollections.observableArrayList();
        fakePartList2.add(pot);
        fakePartList2.add(pan);
        fakePartList2.add(kettle);

        Product silverware = new Product(1, "Starter Set", 15.99, 2, 1, 5, fakePartList);
        Product newHome = new Product(2, "New Home", 75.99, 3, 1, 5, fakePartList2);

        MainScreenController.parts.add(fork);
        MainScreenController.parts.add(spoon);
        MainScreenController.parts.add(pot);
        MainScreenController.parts.add(knife);
        MainScreenController.parts.add(pan);
        MainScreenController.parts.add(kettle);

        MainScreenController.products.add(silverware);
        MainScreenController.products.add(newHome);

    }


    /** This is the main method that runs when the program launches.
     * Launch tells JavaFX to take over and launch a window.
     * @param args Currently args is just a placeholder.
     */
    public static void main(String[] args){
       launch(args);
    }
}
