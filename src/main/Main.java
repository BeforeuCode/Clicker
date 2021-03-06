package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/startpage.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();


        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected interruption", exc);
            }

        });
        thread.setDaemon(true);
        thread.start();




        primaryStage.setOnCloseRequest(e ->  {

            System.out.println("CLOSING ALL THREADS");

            Platform.exit();
                }

                 );
            }




    public static void main(String[] args) {
        launch(args);
    }





}
