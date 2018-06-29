package Controllers;

import Models.MineModel;
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


public class MineController {

    //params

    Controller controller;


    NumberFormat formatter = new DecimalFormat("0.00E00");
    NumberFormat formatterSmall = new DecimalFormat("#.00");

    Timer mineMainTimer = new Timer(true);
    Timer mineIncomeTimer = new Timer(true);

    boolean isMineMainTimierRunninig = false;
    boolean isMineIncomeTimierRunninig = false;

    boolean torchLevelMaxed;
    boolean minerLevelMaxed;
    boolean mageLevelMaxed;
    boolean monsterLevelMaxed;

    ;

    @FXML
    AnchorPane mineProgressButton;
    @FXML
    Text oreLabel;
    @FXML
    Text oreIncomeLabel;

    //axeUP
    @FXML
    Text torchLevelLabel;
    @FXML
    Text torchIncomeLabel;
    @FXML
    Text torchUpCostLabel;
    @FXML
    AnchorPane torchUpgradeButton;

    //elf
    @FXML
    AnchorPane minerButton;
    @FXML
    Text minerIncomeLabel;
    @FXML
    Text minerLevelLabel;
    @FXML
    Text minerUpCostLabel;

    //lumberjack
    @FXML
    AnchorPane mageButton;
    @FXML
    Text mageIncomeLabel;
    @FXML
    Text mageLevelLabel;
    @FXML
    Text mageUpCostLabel;

    //woodcutter
    @FXML
    AnchorPane monsterButton;
    @FXML
    Text monsterIncomeLabel;
    @FXML
    Text monsterLevelLabel;
    @FXML
    Text monsterUpCostLabel;




    MineModel mineModel = new MineModel();

    //Constructiors
    public MineController(MineModel model) {
        this.mineModel = model;


    }

    public MineController() {

    }

    public MineController(Controller controller) {
        this.controller = controller;

    }


    //Wood harvest - Axe Button
    public void onPickaxeButtonClicked(MouseEvent mouseEvent) {


        mineModel.setOre(mineModel.getOre().add(mineModel.getTorchIncome()));
        setOreLabel();




        if (!isMineMainTimierRunninig) {
            mineMainTimerStart();
            isMineMainTimierRunninig = true;

        }
    }





    //Income Timer Starter
    private void mineIncomeTimerStart(){
        mineIncomeTimer.schedule(new TimerTask() {

            @Override
            public void run() {


                mineModel.setOre(mineModel.getOre()
                        .add(mineModel.getMinerIncome())
                        .add(mineModel.getMageIncome())
                        .add(mineModel.getMonsterIncome()));
                setOreLabel();
                setOreIncomeLabel();





            }

        }, 1, 1000);
    }



    //Main Timer Starter
    private void mineMainTimerStart() {

        mineMainTimer.schedule(new TimerTask() {

            @Override
            public void run() {






                if(mineModel.getTorchLevel().equals(mineModel.getTorchMaxLevel())){
                    torchUpgradeButton.setDisable(true);
                    torchLevelLabel.setText("Max");
                    torchUpCostLabel.setText("Max");
                    torchUpgradeButton.setOpacity(1);
                    torchLevelMaxed = true;

                }
                else{
                    if(mineModel.getOre().compareTo(mineModel.getTorchUpCost()) >= 0)
                        torchUpgradeButton.setDisable(false);
                    else
                        torchUpgradeButton.setDisable(true);
                }


                if(mineModel.getMinerLevel().equals(mineModel.getMinerMaxLevel())){
                    minerButton.setDisable(true);
                    minerLevelLabel.setText("Max");
                    minerUpCostLabel.setText("Max");
                    minerButton.setOpacity(1);
                    monsterLevelMaxed = true;

                }
                else{
                    if(mineModel.getOre().compareTo(mineModel.getMinerUpCost()) >= 0)
                        minerButton.setDisable(false);
                    else
                        minerButton.setDisable(true);

                }
                if(mineModel.getMageLevel().equals(mineModel.getMageMaxLevel())){
                    mageButton.setDisable(true);
                    mageLevelLabel.setText("Max");
                    mageUpCostLabel.setText("Max");
                    mageButton.setOpacity(1);
                    minerLevelMaxed = true;

                }else{
                    if(mineModel.getOre().compareTo(mineModel.getMageUpCost()) >= 0)
                        mageButton.setDisable(false);
                    else
                        mageButton.setDisable(true);

                }
                if(mineModel.getMonsterLevel().equals(mineModel.getMonsterMaxLevel())){
                    monsterButton.setDisable(true);
                    monsterLevelLabel.setText("Max");
                    monsterUpCostLabel.setText("Max");
                    monsterButton.setOpacity(1);
                    mageLevelMaxed = true;

                }else{
                    if(mineModel.getOre().compareTo(mineModel.getMonsterUpCost()) >= 0)
                        monsterButton.setDisable(false);
                    else
                        monsterButton.setDisable(true);


                }


                if(torchLevelMaxed && monsterLevelMaxed && mageLevelMaxed && minerLevelMaxed){


                    mineProgressButton.setDisable(false);





                }











            }
        }, 1, 100);
    }






    //elf labels
    @FXML
    private void setMinerLevelLabel(){

        minerLevelLabel.setText(mineModel.getMinerLevel().toString());
    }
    @FXML
    private void setMinerIncomeLabel(){

        minerIncomeLabel.setText(format(mineModel.getMinerIncome()));
    }
    @FXML
    private void setMinerUpCostLabel(){

        minerUpCostLabel.setText(format(mineModel.getMinerUpCost()));

    }



    //lumberjack labels

    @FXML
    private void setMageLevelLabel(){

        mageLevelLabel.setText(mineModel.getMageLevel().toString());

    }
    @FXML
    private void setMageIncomeLabel(){

        mageIncomeLabel.setText(format(mineModel.getMageIncome()));

    }
    @FXML
    private void setMageUpCostLabel(){

        mageUpCostLabel.setText(format(mineModel.getMageUpCost()));

    }

    //Woodcutter labels
    @FXML
    private void setMonsterLevelLabel(){
        monsterLevelLabel.setText(mineModel.getMonsterLevel().toString());
    }

    @FXML
    private void setMonsterIncomeLabel(){
        monsterIncomeLabel.setText(format(mineModel.getMonsterIncome()));
    }

    @FXML
    private void setMonsterUpCostLabel(){
        monsterUpCostLabel.setText(format(mineModel.getMonsterUpCost()));
    }




    //WoodlLabel Setter
    @FXML
    private void setOreLabel() {


        oreLabel.setText(format(mineModel.getOre()));
    }

    @FXML
    private void setOreIncomeLabel(){
        oreIncomeLabel.setText(format(mineModel.getOreIncome()));
    }

    //Axe Labels

    @FXML
    private void setTorchLevelLabel(){
        torchLevelLabel.setText(mineModel.getTorchLevel().toString());
    }
    @FXML
    private void setTorchIncomeLabel(){
        torchIncomeLabel.setText(format(mineModel.getTorchIncome()));
    }
    @FXML
    private void setTorchUpCostLabel(){

        torchUpCostLabel.setText(format(mineModel.getTorchUpCost()));
    }










    //Elf upgrade Button
    @FXML
    public void onMinerUpgradeButtonClicked (MouseEvent mouseEvent){

        System.out.println("test");

        mineModel.setOre(mineModel.getOre().subtract(mineModel.getMinerUpCost()));
        setOreLabel();
        minerButton.setDisable(true);

        mineModel.setMinerLevel(mineModel.getMinerLevel().add(new BigDecimal(1)));
        setMinerLevelLabel();

        mineModel.setMinerIncome();
        setMinerIncomeLabel();


        mineModel.setMinerUpCost();
        setMinerUpCostLabel();

        if(!isMineIncomeTimierRunninig){
            mineIncomeTimerStart();
            isMineIncomeTimierRunninig = true;


        }



    }

    //AxeUpgrade Button
    @FXML
    private void onTorchUpgradeButtonClicked(MouseEvent mouseEvent) {

        System.out.println("torch button test");

        torchUpgradeButton.setDisable(true);

        mineModel.setTorchLevel(mineModel.getTorchLevel().add(new BigDecimal(1)));
        setTorchLevelLabel();

        mineModel.setOre(mineModel.getOre().subtract(mineModel.getTorchUpCost()));
        setOreLabel();

        mineModel.setTorchIncome();
        setTorchIncomeLabel();

        mineModel.setTorchUpCost();
        setTorchUpCostLabel();








    }


    //LumberjackUpgrade button
    @FXML
    public void onMageUpgradeButtonClicked (MouseEvent mouseEvent) {

        mageButton.setDisable(true);

        mineModel.setOre(mineModel.getOre().subtract(mineModel.getMageUpCost()));
        setOreLabel();

        mineModel.setMageLevel(mineModel.getMageLevel().add(new BigDecimal(1)));
        setMageLevelLabel();

        mineModel.setMageIncome();
        setMageIncomeLabel();

        mineModel.setMageUpCost();
        setMageUpCostLabel();





    }

    @FXML
    public void onMonsterUpgradeButtonClicked (MouseEvent mouseEvent){
        monsterButton.setDisable(true);

        mineModel.setOre((mineModel.getOre().subtract(mineModel.getMonsterUpCost())));
        setOreLabel();

        mineModel.setMonsterLevel(mineModel.getMonsterLevel().add(new BigDecimal(1)));
        setMonsterLevelLabel();

        mineModel.setMonsterIncome();
        setMonsterIncomeLabel();

        mineModel.setMonsterUpCost();
        setMonsterUpCostLabel();



    }

    @FXML
    public void onCheatMineButtonClicked(MouseEvent mouseEvent) {

        mineModel.setOre(new BigDecimal(999999999));

    }
    //Progress Button
    @FXML
    private void onMineProgressButtonClicked(MouseEvent mouseEvent) {


        controller.kingdomTab.setDisable(false);
        controller.kingdomTab.setText("KINGDOM!");



        JOptionPane.showMessageDialog(null,"Yo have got everything you need!" +
                        "Your deam soon will come true! Build your kingdom now!",
                "Good Job!",JOptionPane.PLAIN_MESSAGE);

        controller.tabPane.getSelectionModel().select(controller.kingdomTab);

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
