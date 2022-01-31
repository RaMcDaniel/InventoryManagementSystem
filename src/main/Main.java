package main;

import model.InHouse;
import model.Outsourced;
import controller.MainScreenController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        InHouse fork = new InHouse(1, "fork", 1.99, 10, 5, 15, "silverware");
        InHouse spoon = new InHouse(2, "spoon", 2.99, 10, 5, 15, "silverware");
        InHouse knife = new InHouse(3, "knife", 3.99, 10, 5, 15, "silverware");

        Outsourced pot = new Outsourced(4, "pot", 10.99, 3, 1, 5, "Staub");
        Outsourced pan = new Outsourced(5, "pan", 11.99, 3, 1, 5, "Staub");
        Outsourced kettle = new Outsourced(6, "kettle", 20.99, 3, 1, 5, "tea");

        MainScreenController.parts.add(fork);
        MainScreenController.parts.add(spoon);
        MainScreenController.parts.add(pot);
        MainScreenController.products.add(knife);
        MainScreenController.products.add(pan);
        MainScreenController.products.add(kettle);
    }


    /** This is the main method that runs when the program launches.
     * Launch tells JavaFX to take over and launch a window.
     * @param args Currently args is just a placeholder.
     */
    public static void main(String[] args){
       launch(args);
    }
}
