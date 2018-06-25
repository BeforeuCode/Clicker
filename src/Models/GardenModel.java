package Models;

import java.math.BigDecimal;

public class GardenModel {

    private BigDecimal sickleLevelCheck = new BigDecimal(24);
    private BigDecimal farmerLevelCheck = new BigDecimal(9);
    private BigDecimal gardenerLevelCheck = new BigDecimal(5);

    private BigDecimal food = new BigDecimal(0);   //2 ^64
    private BigDecimal foodIncome;


    //Income
    private BigDecimal sickleIncome = new BigDecimal(1); //1
    private BigDecimal farmerIncome = new BigDecimal(0); //10
    private BigDecimal gardenerIncome = new BigDecimal(0); //90
    //Level
    private BigDecimal farmerLevel = new BigDecimal(0);
    private BigDecimal sickleLevel = new BigDecimal(1);
    private BigDecimal gardenerLevel = new BigDecimal(0);

    //UpCost
    private BigDecimal farmerUpCost = new BigDecimal(60);
    private BigDecimal sickleUpCost = new BigDecimal(4);
    private  BigDecimal gardenerUpCost = new BigDecimal(720);

    //max levels
    private BigDecimal maxSickleLevel = new BigDecimal(50);
    private BigDecimal maxFarmerLevel = new BigDecimal(30);
    private BigDecimal maxGardenerLevel = new BigDecimal(20);

    //multipliers
    private BigDecimal sickleMultiplier = new BigDecimal(1).pow(sickleLevel.intValueExact());
    private BigDecimal farmerMultiplier = new BigDecimal(1).pow(farmerLevel.intValueExact());





    public BigDecimal getFood() {return food;
    }

    public void setFood(BigDecimal food) { this.food = food;  }

    public BigDecimal getSickleIncome() {
        return sickleIncome;
    }


//;Edited SickleIncome setter
    public void setSickleIncome() {



       this.sickleIncome = (sickleIncome.add(new BigDecimal(2)));

            //Sickle Multipler
            if (sickleLevel.compareTo(sickleLevelCheck) == 0) {
                sickleLevelCheck = sickleLevelCheck.add(new BigDecimal(25));
                this.sickleIncome = sickleIncome.multiply(new BigDecimal(2));

            }
    }

    public BigDecimal getFarmerIncome() { return farmerIncome; }


    //Edit
    public void setFarmerIncome() {

        boolean farmerIncomeInitializer = true;

        if(farmerIncomeInitializer){
            farmerIncome.add(new BigDecimal(10));
            farmerIncomeInitializer = false;
        }

        this.farmerIncome = (farmerIncome.add(new BigDecimal(10)));

            if(farmerLevel.compareTo(farmerLevelCheck) == 0 ) {
                farmerLevelCheck = farmerLevelCheck.add(new BigDecimal(10));
                this.farmerIncome = farmerIncome.multiply(new BigDecimal(2));
            }



        this.farmerIncome = farmerIncome; }

    public BigDecimal getFarmerLevel() { return farmerLevel; }

    public void setFarmerLevel(BigDecimal farmerLevel) { this.farmerLevel = farmerLevel; }



    public BigDecimal getFarmerUpCost() { return farmerUpCost; }

    //Edit
    public void setFarmerUpCost() {



        this.farmerUpCost = new BigDecimal(60)
                .multiply(new BigDecimal(1.50).pow(farmerLevel.intValueExact()));}


    public BigDecimal getSickleLevel() {
        return sickleLevel;
    }

    public void setSickleLevel(BigDecimal sickleLevel) {
        this.sickleLevel = sickleLevel;
    }

    public BigDecimal getSickleUpCost(){ return sickleUpCost; }


//Edited SickleUpCost setter
    public void setSickleUpCost() {

        this.sickleUpCost = new BigDecimal(4).multiply(new BigDecimal(1.20).pow(sickleLevel.intValueExact()));
    }

    public BigDecimal getMaxSickleLevel() {return maxSickleLevel;    }

    public BigDecimal getGardenerIncome() {
        return gardenerIncome;
    }

    //edited
    public void setGardenerIncome() {

        boolean gardenerIncomeInitializer = true;

        if(gardenerIncomeInitializer){
            farmerIncome.add(new BigDecimal(10));
            gardenerIncomeInitializer = false;
        }

        this.gardenerIncome = (gardenerIncome.add(new BigDecimal(30)));

        if(gardenerLevel.compareTo(gardenerLevelCheck) == 0 ) {
            gardenerLevelCheck = gardenerLevelCheck.add(new BigDecimal(5));
            this.gardenerIncome = gardenerIncome.multiply(new BigDecimal(2));
        }


    }

    public BigDecimal getGardenerLevel() {
        return gardenerLevel;
    }

    public void setGardenerLevel(BigDecimal gardenerLevel) { this.gardenerLevel = gardenerLevel;
    }

    public BigDecimal getGardenerUpCost() { return gardenerUpCost; }

    //edited
    public void setGardenerUpCost() {

        this.gardenerUpCost =new BigDecimal(720).multiply(new BigDecimal(1.70).pow(gardenerLevel.intValueExact()));;
    }

    public BigDecimal getSickleMultiplier() { return sickleMultiplier; }

    public void setSickleMultiplier(BigDecimal sickleMultiplier) { this.sickleMultiplier = sickleMultiplier; }

    public BigDecimal getFarmerMultiplier() {     return farmerMultiplier;   }

    public void setFarmerMultiplier(BigDecimal farmerMultipler) {    this.farmerMultiplier = farmerMultipler;    }

    public BigDecimal getMaxFarmerLevel() {
        return maxFarmerLevel;
    }

    public BigDecimal getMaxGardenerLevel() {
        return maxGardenerLevel;
    }


    public BigDecimal getFoodIncome() {

        this.foodIncome = farmerIncome.add(gardenerIncome);

        return foodIncome;
    }


}
