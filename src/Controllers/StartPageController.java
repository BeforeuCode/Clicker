package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    private Button newGameButton;






    @FXML
    private void newGameButtonOnClick(ActionEvent event) throws IOException {

        //TODO Wymylsec jakas historyjke
        //TODO Stworzyc strone startową
        //JOptionPane.showMessageDialog(null,"Heello message","ok",JOptionPane.PLAIN_MESSAGE);


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
