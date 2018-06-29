package Controllers;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Controller {


GardenController gardenController;
ForestController forestController;
MineController mineController;

   public Controller()
   {
        this.gardenController = new GardenController(this);
        this.forestController = new ForestController(this);
        this.mineController = new MineController(this);

   }


   @FXML
         private AnchorPane gardenPane;
   @FXML
         private AnchorPane forestPane;
   @FXML
         private AnchorPane minePane;
   @FXML
   Tab forestTab;
   @FXML
   Tab mineTab;
   @FXML
   Tab kingdomTab;
   @FXML
    AnchorPane mineProgressButton;
   @FXML
   AnchorPane forestProgressButton;
   @FXML
   AnchorPane progressButtonPane;
   @FXML
    TabPane tabPane;





   public void initialize()  {
       FXMLLoader loaderGarden = new FXMLLoader(getClass().getResource("/Views/garden.fxml"));
        loaderGarden.setController(gardenController);


       FXMLLoader loaderForest = new FXMLLoader(getClass().getResource("/Views/forest.fxml"));
       loaderForest.setController(forestController);

      FXMLLoader loaderMine = new FXMLLoader(getClass().getResource("/Views/mine.fxml"));
      loaderMine.setController(mineController);

       try {
           Pane gardenContent = loaderGarden.load();
           gardenPane.getChildren().add(gardenContent);

           Pane forestContent = loaderForest.load();
           forestPane.getChildren().add(forestContent);

           Pane mineContent = loaderMine.load();
           minePane.getChildren().add(mineContent);


       } catch (IOException e) {
           e.printStackTrace();
       }



   }




    }

