package main;

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
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        stage.setTitle("C482 Performance Assessment");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }


    /** This is the main method that runs when the program launches.
     * Launch tells JavaFX to take over and launch a window.
     * @param args Currently args is just a placeholder.
     */
    public static void main(String[] args){
       launch(args);
    }
}
