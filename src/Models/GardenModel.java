package Models;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GardenModel {


    private BigDecimal food = new BigDecimal(0);   //2 ^64
    private BigDecimal  sickleIncome = new BigDecimal(1.67);
    private BigDecimal sickleLevel = new BigDecimal(1);
    private BigDecimal sickleUpCost = new BigDecimal(4);
    private BigDecimal maxSickleLevel = new BigDecimal(1000000000);

    private BigDecimal farmerIncome = new BigDecimal(0);
    private BigDecimal farmerLevel = new BigDecimal(0);
    private BigDecimal farmerUpCost = new BigDecimal(100);



    private BigDecimal sickleMultiplier = new BigDecimal(1);



    private BigDecimal farmerMultiplier = new BigDecimal(1);



    public BigDecimal getFood() {return food;
    }

    public void setFood(BigDecimal food) { this.food = food;  }

    public BigDecimal getSickleIncome() {
        return sickleIncome;
    }

    public void setSickleIncome(BigDecimal sickleIncome) {
        this.sickleIncome = sickleIncome;
    }

    public BigDecimal getFarmerIncome() { return farmerIncome; }

    public void setFarmerIncome(BigDecimal farmerIncome) { this.farmerIncome = farmerIncome; }

    public BigDecimal getFarmerLevel() { return farmerLevel; }

    public void setFarmerLevel(BigDecimal farmerLevel) { this.farmerLevel = farmerLevel; }

    public BigDecimal getFarmerUpCost() { return farmerUpCost; }

    public void setFarmerUpCost(BigDecimal farmerUpCost) { this.farmerUpCost = farmerUpCost;}

    public BigDecimal getSickleLevel() {
        return sickleLevel;
    }

    public void setSickleLevel(BigDecimal sickleLevel) {
        this.sickleLevel = sickleLevel;
    }

    public BigDecimal getSickleUpCost() {
        return sickleUpCost;
    }

    public void setSickleUpCost(BigDecimal sickleUpCost) {
        this.sickleUpCost = sickleUpCost;
    }

    public BigDecimal getMaxSickleLevel() {return maxSickleLevel;    }

    public BigDecimal getSickleMultiplier() { return sickleMultiplier; }

    public void setSickleMultiplier(BigDecimal sickleMultiplier) { this.sickleMultiplier = sickleMultiplier; }

    public BigDecimal getFarmerMultiplier() {     return farmerMultiplier;   }

    public void setFarmerMultiplier(BigDecimal farmerMultipler) {    this.farmerMultiplier = farmerMultipler;    }
}
