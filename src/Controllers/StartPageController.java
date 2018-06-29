package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    private Button newGameButton;

    @FXML
    private Controller controller;





    @FXML
    private void newGameButtonOnClick(MouseEvent mouseEvent) throws IOException {


        JOptionPane.showMessageDialog(null,"You are young ambitious lord that has been banished from fathers kingdom. " +
                "Your mission is to get people that will follow you and prepare to build your own kingdom and become a KING! GOOD LUCK!  ","Your journey awaits!",JOptionPane.PLAIN_MESSAGE);


            Stage stage;
            Parent root;

            stage = (Stage) newGameButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Views/sample.fxml"));

            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
