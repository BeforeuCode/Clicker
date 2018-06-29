package Controllers;



import Models.ForestModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


import javax.swing.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;


public class ForestController {

    //params

    Controller controller;


    NumberFormat formatter = new DecimalFormat("0.00E00");
    NumberFormat formatterSmall = new DecimalFormat("#.00");

    Timer forestMainTimer = new Timer(true);
    Timer forestIncomeTimer = new Timer(true);

    boolean isForestMainTimierRunninig = false;
    boolean isForestIncomeTimierRunninig = false;

    boolean axeLevelMaxed;
    boolean lumberjackLevelMaxed;
    boolean woodcutterLevelMaxed;
    boolean elfLevelMaxed;

    @FXML
    Button axeButton;

    @FXML
    AnchorPane forestProgressButton;
    @FXML
    Text forestProgressLabel2;
    @FXML
    Text forestProgressLabel1;
    @FXML
    Text woodLabel;
    @FXML
    Text woodIncomeLabel;

   //axeUP
    @FXML
    Text axeLevelLabel;
    @FXML
    Text axeIncomeLabel;
    @FXML
    Text axeUpCostLabel;
    @FXML
    AnchorPane axeUpgradeButton;

    //elf
    @FXML
            AnchorPane elfButton;
    @FXML
            Text elfIncomeLabel;
    @FXML
            Text elfLevelLabel;
    @FXML
            Text elfUpCostLabel;

    //lumberjack
    @FXML
            AnchorPane lumberjackButton;
    @FXML
            Text lumberjackIncomeLabel;
    @FXML
            Text lumberjackLevelLabel;
    @FXML
            Text lumberjackUpCostLabel;

     //woodcutter
    @FXML
            AnchorPane woodcutterButton;
    @FXML
            Text woodcutterIncomeLabel;
    @FXML
            Text woodcutterLevelLabel;
    @FXML
            Text  woodcutterUpCostLabel;




    ForestModel forestModel = new ForestModel();

    //Constructiors
    public ForestController(ForestModel model, Button axeButton) {
        this.forestModel = model;


    }

    public ForestController() {

    }

    public ForestController(Controller controller) {
        this.controller = controller;

    }


     //Wood harvest - Axe Button





    //Income Timer Starter
    private void  forestIncomeTimerStart(){
        forestIncomeTimer.schedule(new TimerTask() {

            @Override
            public void run() {


            forestModel.setWood(forestModel.getWood()
                                            .add(forestModel.getElfIncome())
                                            .add(forestModel.getLumberjackIncome())
                                            .add(forestModel.getWoodcutterIncome()));
            setWoodLabel();
            setWoodIncomeLabel();





            }

        }, 1, 1000);
    }



    //Main Timer Starter
    private void forestMainTimerStart() {

        forestMainTimer.schedule(new TimerTask() {

            @Override
            public void run() {



        if(forestModel.getAxeLevel().equals(forestModel.getAxeMaxLevel())) {
            axeUpgradeButton.setDisable(true);
            axeLevelLabel.setText("Max");
            axeUpCostLabel.setText("Max");
            axeUpgradeButton.setOpacity(1);
            axeLevelMaxed = true;
        }
         else{
            if(forestModel.getWood().compareTo(forestModel.getAxeUpCost()) >= 0)
                axeUpgradeButton.setDisable(false);
            else
                axeUpgradeButton.setDisable(true);

        }


            if(forestModel.getElfLevel().equals(forestModel.getElfMaxLevel())) {
                elfButton.setDisable(true);
                elfLevelLabel.setText("Max");
                elfUpCostLabel.setText("Max");
                elfButton.setOpacity(1);
                elfLevelMaxed = true;
            }
                    else{
                    if(forestModel.getWood().compareTo(forestModel.getElfUpCost()) >= 0)
                        elfButton.setDisable(false);
                    else
                        elfButton.setDisable(true);
                }


                            if(forestModel.getLumberjackLevel().equals(forestModel.getLumberjackMaxLevel())){
                                lumberjackButton.setDisable(true);
                                lumberjackLevelLabel.setText("Max");
                                lumberjackUpCostLabel.setText("Max");
                                lumberjackButton.setOpacity(1);
                                lumberjackLevelMaxed = true;

                            }
                                else{

                                    if(forestModel.getWood().compareTo(forestModel.getLumberjackUpCost()) >= 0)
                                        lumberjackButton.setDisable(false);
                                    else
                                        lumberjackButton.setDisable(true);

                                }

                                            if(forestModel.getWoodcutterLevel().equals(forestModel.getWoodcutterMaxLevel())){
                                                woodcutterButton.setDisable(true);
                                                woodcutterLevelLabel.setText("Max");
                                                woodcutterUpCostLabel.setText("Max");
                                                woodcutterButton.setOpacity(1);
                                                woodcutterLevelMaxed = true;

                                            }
                                                    else{

                                                        if(forestModel.getWood().compareTo(forestModel.getWoodcutterUpCost()) >= 0)
                                                            woodcutterButton.setDisable(false);
                                                        else
                                                            woodcutterButton.setDisable(true);

                                                    }


                    if(axeLevelMaxed && elfLevelMaxed && woodcutterLevelMaxed && lumberjackLevelMaxed){


                        forestProgressButton.setDisable(false);

                        forestProgressLabel2.setText("     PROGRESS!");

                        forestProgressLabel1.setText("");



                    }











            }
        }, 1, 100);
    }






    //elf labels
    @FXML
    private void setElfLevelLabel(){

             elfLevelLabel.setText(forestModel.getElfLevel().toString());
    }
        @FXML
        private void setElfIncomeLabel(){

                elfIncomeLabel.setText(format(forestModel.getElfIncome()));
        }
            @FXML
            private void setElfUpCostLabel(){

                    elfUpCostLabel.setText(format(forestModel.getElfUpCost()));

            }



    //lumberjack labels

    @FXML
    private void setLumberjackLevelLabel(){

        lumberjackLevelLabel.setText(forestModel.getLumberjackLevel().toString());

        }
        @FXML
        private void setLumberjackIncomeLabel(){

            lumberjackIncomeLabel.setText(format(forestModel.getLumberjackIncome()));


        }
            @FXML
            private void setLumberjackUpCostLabel(){

                lumberjackUpCostLabel.setText(format(forestModel.getLumberjackUpCost()));

            }

    //Woodcutter labels
    @FXML
    private void setWoodcutterLevelLabel(){
        woodcutterLevelLabel.setText(forestModel.getWoodcutterLevel().toString());
    }

        @FXML
        private void setWoodcutterIncomeLabel(){
            woodcutterIncomeLabel.setText(format(forestModel.getWoodcutterIncome()));
        }

            @FXML
                private void setWoodcutterUpCostLabel(){
                    woodcutterUpCostLabel.setText(format(forestModel.getWoodcutterUpCost()));
            }




    //WoodlLabel Setter
    @FXML
    private void setWoodLabel() {


        woodLabel.setText(format(forestModel.getWood()));
    }

        @FXML
        private void setWoodIncomeLabel(){
            woodIncomeLabel.setText(format(forestModel.getWoodIncome()));
        }

    //Axe Labels

    @FXML
    private void setAxeLevelLabel(){
        axeLevelLabel.setText(forestModel.getAxeLevel().toString());
    }
        @FXML
        private void setAxeIncomeLabel(){
            axeIncomeLabel.setText(format(forestModel.getAxeIncome()));
        }
            @FXML
            private void setAxeUpCostLabel(){

                axeUpCostLabel.setText(format(forestModel.getAxeUpCost()));
            }








    //Wood harvest - Axe Button
    @FXML
    public void onAxeClicked(MouseEvent mouseEvent) {


        forestModel.setWood(forestModel.getWood().add(forestModel.getAxeIncome()));
        setWoodLabel();




        if (!isForestMainTimierRunninig) {
            forestMainTimerStart();
            isForestMainTimierRunninig = true;

        }
    }


    //Elf upgrade Button
    @FXML
    public void onElfUpgradeButtonClicked (MouseEvent mouseEvent){



        forestModel.setWood(forestModel.getWood().subtract(forestModel.getElfUpCost()));
        setWoodLabel();
        elfButton.setDisable(true);

        forestModel.setElfLevel(forestModel.getElfLevel().add(new BigDecimal(1)));
        setElfLevelLabel();

            forestModel.setElfIncome();
            setElfIncomeLabel();


                 forestModel.setElfUpCost();
                 setElfUpCostLabel();

        if(!isForestIncomeTimierRunninig){
            forestIncomeTimerStart();
            isForestIncomeTimierRunninig = true;


        }



    }

    //AxeUpgrade Button
    @FXML
    private void onAxeUpgradeButtonClicked(MouseEvent mouseEvent) {



            axeUpgradeButton.setDisable(true);

        forestModel.setAxeLevel(forestModel.getAxeLevel().add(new BigDecimal(1)));
        setAxeLevelLabel();

            forestModel.setWood(forestModel.getWood().subtract(forestModel.getAxeUpCost()));
                setWoodLabel();

                    forestModel.setAxeIncome();
                    setAxeIncomeLabel();

                        forestModel.setAxeUpCost();
                        setAxeUpCostLabel();








    }


    //LumberjackUpgrade button
    @FXML
    public void onLumberjackUpgradeButtonClicked (MouseEvent mouseEvent) {

        lumberjackButton.setDisable(true);

        forestModel.setWood(forestModel.getWood().subtract(forestModel.getLumberjackUpCost()));
        setWoodLabel();

            forestModel.setLumberjackLevel(forestModel.getLumberjackLevel().add(new BigDecimal(1)));
            setLumberjackLevelLabel();

                forestModel.setLumberjackIncome();
                setLumberjackIncomeLabel();

                    forestModel.setLumberjackUpCost();
                    setLumberjackUpCostLabel();





    }

    @FXML
    public void onWoodcutterUpgradeButtonClicked (MouseEvent mouseEvent){
            woodcutterButton.setDisable(true);

            forestModel.setWood((forestModel.getWood().subtract(forestModel.getWoodcutterUpCost())));
            setWoodLabel();

                forestModel.setWoodcutterLevel(forestModel.getWoodcutterLevel().add(new BigDecimal(1)));
                setWoodcutterLevelLabel();

                    forestModel.setWoodcutterIncome();
                    setWoodcutterIncomeLabel();

                        forestModel.setWoodcutterUpCost();
                        setWoodcutterUpCostLabel();



    }



    @FXML
    public void onCheatForestButtonClicked(MouseEvent mouseEvent) {

        forestModel.setWood(new BigDecimal(999999999));

    }


    //Progress Button
    @FXML
    public void onForestProgressButtonClicked(MouseEvent mouseEvent) {


        controller.mineTab.setDisable(false);



        JOptionPane.showMessageDialog(null,"You and your people made an effort to progress further on goal to build a kingdom" +
                        "The only thing you need now is to get Ore so you can build beeter buildings and weapons. Mines unlocked!",
                "Good Job!",JOptionPane.PLAIN_MESSAGE);


        controller.tabPane.getSelectionModel().select(controller.mineTab);
    }


    //Big Decimal Formatter
    private String format(BigDecimal a) {
        String b = " ";
        if (a.compareTo(new BigDecimal(10000)) == 1) {

            b = formatter.format(a).toLowerCase().replace(",", ".");

            return b;
        } else
            return formatterSmall.format(a).replace(",", ".");

    }

}