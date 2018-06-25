package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Models.GardenModel;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

public class GardenController {



    @FXML
            private Text sickleLevelLabel;
    @FXML
            private Text sickleUpCostLabel;
    @FXML
            private Text sickleIncomeLabel;
    @FXML
            private Text farmerLevelLabel;
    @FXML
            private Text farmerUpCostLabel;
    @FXML
            private Text farmerIncomeLabel;
    @FXML
            private AnchorPane pane;
    @FXML
            private AnchorPane farmerButtonPane;
    @FXML
            private Text foodLabel;
    @FXML
            private Button sickleButton;
    @FXML
            private Text foodPerSecond;
    @FXML
            private Button harvestButton;
    @FXML
            private  AnchorPane gardenerButtonPane;
    @FXML
            private Text gardenerIncomeLabel;
    @FXML
            private Text gardenerLevelLabel;
    @FXML
            private Text gardenerUpCostLabel;
    @FXML
            AnchorPane progressButtonPane;
    @FXML
            Text foodIncomeLabel;

    NumberFormat formatter = new DecimalFormat("0.00E00");
    NumberFormat formatterSmall = new DecimalFormat("#.00");

    Timer timerMain = new Timer(true);

    Timer timerIncome = new Timer(true);

    public GardenModel getModel() {
        return model;
    }

    private GardenModel model = new GardenModel();
    int initializeTimer = 0;
    int initializeIncomeTimer = 0;

    boolean farmerLevelMaxed = false;
    boolean sickleLevelMaxed = false;
    boolean gardenerLevelMaxed =  false;

    BigDecimal sicklecheck = new BigDecimal(24);
    BigDecimal farmerCheck = new BigDecimal(24);

    //CONSTRUCTORS
    public GardenController(GardenModel model, Text foodLabel, Text sickleLevelLabel, Text sickleUpCostLabel,
                            Text sickleIncomeLabel, AnchorPane pane, AnchorPane farmerButtonPane, DecimalFormat formatter,
                            Text farmerIncomeLabel, Text farmerLevelLabel, Text farmerUpCostLabel, AnchorPane progressButtonPane) {

        this.model = model;
        this.foodLabel = foodLabel;
        this.sickleLevelLabel = sickleLevelLabel;
        sickleLevelLabel.setText((model.getSickleLevel().toString()));
        this.sickleIncomeLabel = sickleIncomeLabel;
        sickleIncomeLabel.setText((model.getSickleIncome().toString()));
        this.sickleUpCostLabel = sickleUpCostLabel;
        sickleUpCostLabel.setText((model.getSickleUpCost().toString()));
        this.pane=pane;
        this.farmerButtonPane = farmerButtonPane;
        this.formatter = formatter;
        this.farmerIncomeLabel = farmerIncomeLabel;
        this.farmerLevelLabel= farmerLevelLabel;
        this.farmerUpCostLabel = farmerUpCostLabel;
        this.progressButtonPane = progressButtonPane;
    }

    public GardenController() {

    }

    /*1.07

    RATE      prod base         COST VASE
    1.07      1.5                4
    1.15      20                 60
    1.14      90                 720
    1.13      360                8640
    1.12      2160               103680

   Cost = costbase x rate ^owned
   prod = prodbase * level * multiplers
    */

//Sickle Up Button
    public void onSickleButtonClicked(MouseEvent mouseEvent) {

        pane.setDisable(true);
        //TODO set income and cost multiplayers

        model.setFood(model.getFood().subtract(model.getSickleUpCost()));
        setFoodLabel();

        //SET SICKLE INCOME
        model.setSickleIncome();
         setSickleIncomeLabel();

         model.setSickleUpCost();
         setSickleUpCostLabel();

         model.setSickleLevel(model.getSickleLevel().add(new BigDecimal(1)));
         setSickleLevelLabel();

         //TODO  set max level

      /*  System.out.println("Multipl: " + model.getSickleMultiplier());
        System.out.println("Income: " + model.getSickleIncome());
        System.out.println("Up Cost" + model.getSickleUpCost());*/
    }
    public void onFarmerButtonClicked(MouseEvent mouseEvent) {


        model.setFood(model.getFood().subtract(model.getFarmerUpCost()) );
        setFoodLabel();
        farmerButtonPane.setDisable(true);

        model.setFarmerIncome();
        setFarmerIncomeLabel();

        model.setFarmerLevel(model.getFarmerLevel().add(new BigDecimal(1)));
        setFarmerLevelLabel();

        model.setFarmerUpCost();
        setFarmerUpCostLabel();


        if (initializeIncomeTimer == 0) {
            timerIncomeStart();
            initializeIncomeTimer++;

        }


    }

    public void onGardenerButtonClicked(MouseEvent mouseEvent) {
        model.setFood(model.getFood().subtract(model.getGardenerUpCost()) );
        gardenerButtonPane.setDisable(true);
        setFoodLabel();

        model.setGardenerIncome();
        setGardenerIncomeLabel();

        model.setGardenerLevel(model.getGardenerLevel().add(new BigDecimal(1)));
        setGardenerLevelLabel();

        model.setGardenerUpCost();
        setGardenerUpCostLabel();
    }

    //Harvest button
    public void onHarvestButtonClicked(MouseEvent mouseEvent) {

            //Add food  and show on label
            model.setFood(model.getFood().add(model.getSickleIncome()) );
            setFoodLabel();

        if (initializeTimer == 0) {
            timerMainStart();
            initializeTimer++;

        }
    }
// setFoodLabel Method
    @FXML
    private void setFoodLabel() {

    format(model.getFood());
    foodLabel.setText(format(model.getFood()));
    }

    @FXML
    private void setFoodIncomeLabel(){
        format(model.getFoodIncome());

        foodIncomeLabel.setText( format(model.getFoodIncome()));


    }
    @FXML
    private void setSickleLevelLabel() {

        sickleLevelLabel.setText(model.getSickleLevel().toString());
    }

    @FXML
    private void setSickleUpCostLabel() {
        format(model.getSickleUpCost());
        sickleUpCostLabel.setText(format(model.getSickleUpCost()));
    }

    @FXML
    private void setSickleIncomeLabel() {
        format(model.getSickleIncome());
        sickleIncomeLabel.setText(format(model.getSickleIncome()));
    }

    @FXML
    private void setFarmerLevelLabel() {

        farmerLevelLabel.setText(model.getFarmerLevel().toString());
    }

    @FXML
    private void setFarmerUpCostLabel() {
        format(model.getFarmerUpCost());
        farmerUpCostLabel.setText(format(model.getFarmerUpCost()));
    }

    @FXML
    private void setFarmerIncomeLabel() {
        format(model.getFarmerIncome());
        farmerIncomeLabel.setText(format(model.getFarmerIncome()));
    }

    @FXML
    private void setGardenerIncomeLabel() {
        format(model.getGardenerIncome());
        gardenerIncomeLabel.setText(format(model.getGardenerIncome()));
    }

    @FXML
    private void setGardenerLevelLabel() {
        gardenerLevelLabel.setText(model.getGardenerLevel().toString());
    }

    @FXML
    private void setGardenerUpCostLabel() {
        format(model.getGardenerUpCost());
        gardenerUpCostLabel.setText(format(model.getGardenerUpCost()));
    }


      //Main timer starter method
        private void timerMainStart () {

            timerMain.schedule(new TimerTask() {

                @Override
                public void run() {


                   /* a.compareTo(b) < 0 // a < b

                    a.compareTo(b) > 0 // a > b

                    a.compareTo(b) == 0 // a == b*/

                    //Enable panes when enough food
                    if (model.getFood().compareTo(model.getSickleUpCost()) >=0 )
                        pane.setDisable(false);
                    else
                        pane.setDisable(true);

                    if(model.getFood().compareTo(model.getFarmerUpCost()) >= 0)
                        farmerButtonPane.setDisable(false);
                    else
                        farmerButtonPane.setDisable(true);

                    if(model.getFood().compareTo(model.getGardenerUpCost()) >= 0)
                        gardenerButtonPane.setDisable(false);
                    else
                        gardenerButtonPane.setDisable(true);

                    if(sickleLevelMaxed && farmerLevelMaxed  && gardenerLevelMaxed ) {
                        progressButtonPane.setDisable(false);
                    }




                    // Farmer Multipler




                    //Max level Sickle
                    if(model.getSickleLevel().equals(model.getMaxSickleLevel()) ){
                        pane.setDisable(true);
                        sickleLevelLabel.setText("Max");
                        sickleUpCostLabel.setText("Max");
                        pane.setOpacity(1);
                        sickleLevelMaxed = true;
                    }

                    if(model.getFarmerLevel().equals(model.getMaxFarmerLevel()) ){
                        farmerButtonPane.setDisable(true);
                        farmerLevelLabel.setText("Max");
                        farmerUpCostLabel.setText("Max");
                        farmerButtonPane.setOpacity(1);
                        farmerLevelMaxed = true;
                    }

                    if(model.getGardenerLevel().equals(model.getMaxGardenerLevel()) ){
                        gardenerButtonPane.setDisable(true);
                        gardenerLevelLabel.setText("Max");
                        gardenerUpCostLabel.setText("Max");
                        gardenerButtonPane.setOpacity(1);
                        gardenerLevelMaxed =true;
                    }






                }

            }, 1, 100);
        }




    private void timerIncomeStart () {

        timerIncome.schedule(new TimerTask() {

            @Override
            public void run() {


             model.setFood(model.getFood().add(model.getFarmerIncome()).add(model.getGardenerIncome()) );
             setFoodLabel();
             setFoodIncomeLabel();

            }

        }, 200, 1000);
    }


        //formatting scientific notation

    private String format(BigDecimal a){
            String b= " ";
        if (a.compareTo(new BigDecimal(10000)) == 1 ){

            b = formatter.format(a).toLowerCase().replace(",", ".");

        return b ;}
        else
            return formatterSmall.format(a).replace(",", ".");

    }


    public void onProgressButtonClicked(MouseEvent mouseEvent) {






    }
}









