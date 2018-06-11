package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Models.GardenModel;

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
    int a = 0;
    BigDecimal sicklecheck = new BigDecimal(24);
    BigDecimal farmerCheck = new BigDecimal(24);

    //CONSTRUCTORS
    public GardenController(GardenModel model, Text foodLabel, Text sickleLevelLabel, Text sickleUpCostLabel,
                            Text sickleIncomeLabel, AnchorPane pane, AnchorPane farmerButtonPane, DecimalFormat formatter,
                            Text farmerIncomeLabel, Text farmerLevelLabel, Text farmerUpCostLabel) {

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
    }

    public GardenController() {

    }

    /*1.07

    RATE      prod base         COST VASE
    1.07      1                  4
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
        model.setSickleIncome(new BigDecimal(4).multiply((model.getSickleLevel().multiply(model.getSickleMultiplier() ))));//    multipler = 1^ level

       setSickleIncomeLabel();

       model.setFood(model.getFood().subtract(model.getSickleUpCost()));

         setFoodLabel();

        model.setSickleUpCost(new BigDecimal(4).multiply(new BigDecimal(1.07).pow(model.getSickleLevel().intValueExact())));

        setSickleUpCostLabel();
        //TODO  set max level

        model.setSickleLevel(model.getSickleLevel().add(new BigDecimal(1)));
        setSickleLevelLabel();

    }
    public void onFarmerButtonClicked(MouseEvent mouseEvent) {


        model.setFood(model.getFood().subtract(model.getFarmerUpCost()) );
        farmerButtonPane.setDisable(true);


        model.setFarmerIncome((model.getFarmerIncome().add(new BigDecimal(1))).multiply(new BigDecimal(2)));
        setFarmerIncomeLabel();
        model.setFarmerLevel(model.getFarmerLevel().add(new BigDecimal(1)));
        setFarmerLevelLabel();
        model.setFarmerUpCost(model.getFarmerUpCost().multiply(new BigDecimal(2)));
        setFarmerUpCostLabel();


        if (initializeIncomeTimer == 0) {
            timerIncomeStart();
            initializeIncomeTimer++;

        }


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
        private void setFoodLabel(){

        format(model.getFood());
        foodLabel.setText(  format(model.getFood()));



        }
@FXML
private void setSickleLevelLabel(){

        sickleLevelLabel.setText( model.getSickleLevel().toString());
}
@FXML
private void setSickleUpCostLabel(){
        format(model.getSickleUpCost());
        sickleUpCostLabel.setText(  format(model.getSickleUpCost()));
}
@FXML
private void setSickleIncomeLabel(){
        format(model.getSickleIncome());
        sickleIncomeLabel.setText( format(model.getSickleIncome()));
}
@FXML
    public void setFarmerLevelLabel() {

        farmerLevelLabel.setText(model.getFarmerLevel().toString());
    }
@FXML
    public void setFarmerUpCostLabel() {
        format(model.getFarmerUpCost());
        farmerUpCostLabel.setText(format(model.getFarmerUpCost()));
    }
@FXML
    public void setFarmerIncomeLabel() {
    format(model.getFarmerIncome());
    farmerIncomeLabel.setText(format(model.getFarmerIncome()));
    }

        public void timerMainStart () {

            timerMain.schedule(new TimerTask() {

                @Override
                public void run() {


                   /* a.compareTo(b) < 0 // a < b

                    a.compareTo(b) > 0 // a > b

                    a.compareTo(b) == 0 // a == b*/


                    if (model.getFood().compareTo(model.getSickleUpCost()) >=0 )
                        pane.setDisable(false);
                    else
                        pane.setDisable(true);

                    //Sickle Multipler
                    if(model.getSickleLevel().compareTo(sicklecheck) == 0 ){
                        sicklecheck = sicklecheck.add(new BigDecimal(25));
                        model.setSickleMultiplier(model.getSickleMultiplier().multiply(new BigDecimal(2)));


                    // Farmer Multipler
                    }
                    if(model.getFarmerLevel().compareTo(farmerCheck) == 0 ) {
                        farmerCheck = farmerCheck.add(new BigDecimal(25));
                        model.setFarmerMultiplier(model.getFarmerMultiplier().multiply(new BigDecimal(2)));
                    }


                    //Max level Sickle
                    if(model.getSickleLevel()== model.getMaxSickleLevel() ){
                        pane.setDisable(true);
                        sickleLevelLabel.setText("Max");
                        sickleUpCostLabel.setText("Max");    }

                     if(model.getFood().compareTo(model.getFarmerUpCost()) >= 0)
                        farmerButtonPane.setDisable(false);
                     else
                        farmerButtonPane.setDisable(true);




                }

            }, 1, 100);
        }




    public void timerIncomeStart () {

        timerIncome.schedule(new TimerTask() {

            @Override
            public void run() {


             model.setFood(model.getFood().add(model.getFarmerIncome()) );
             setFoodLabel();

            }

        }, 200, 1000);
    }


        //formatting scientific notation

    public String format(BigDecimal a){
            String b= " ";
        if (a.compareTo(new BigDecimal(10000)) == 1 ){

            b = formatter.format(a).toLowerCase().replace(",", ".");

        return b ;}
        else
            return formatterSmall.format(a).replace(",", ".");

    }

    public void onGardenerButtonClicked(MouseEvent mouseEvent) {
    }
}









