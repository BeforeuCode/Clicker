package Models;


import java.math.BigDecimal;

public class MineModel {

        private BigDecimal ore = new BigDecimal(1000000000);
        private BigDecimal oreIncome = new BigDecimal(0);

        //torch
        private BigDecimal torchIncome = new BigDecimal(1);
        private BigDecimal torchLevel = new BigDecimal(1);
        private BigDecimal torchMaxLevel = new BigDecimal(50);
        private BigDecimal torchUpCost = new BigDecimal(4);
        private BigDecimal torchLevelCheck = new BigDecimal(24);

        //miner
        private BigDecimal minerIncome = new BigDecimal(0);
        private BigDecimal minerLevel = new BigDecimal(0);
        private BigDecimal minerMaxLevel = new BigDecimal(30);
        private BigDecimal minerUpCost = new BigDecimal(60);
        private BigDecimal minerLevelCheck = new BigDecimal(9);
        private boolean minerIncomeInit = false;

        //mage
        private BigDecimal mageIncome = new BigDecimal(0);
        private BigDecimal mageLevel = new BigDecimal(0);
        private BigDecimal mageMaxLevel = new BigDecimal(20);
        private BigDecimal mageUpCost = new BigDecimal(720);
        private BigDecimal mageCheck = new BigDecimal(9);
        private boolean mageIncomeInit = false;

        //monster

        private BigDecimal monsterIncome = new BigDecimal(0);
        private BigDecimal monsterLevel = new BigDecimal(0);
        private BigDecimal monsterMaxLevel = new BigDecimal(10);
        private BigDecimal monsterUpCost = new BigDecimal(8640);
        private BigDecimal monsterLevelCheck = new BigDecimal(4);
        private boolean monsterIncomeInit = false;

















        public BigDecimal getMageIncome() {
            return mageIncome;
        }

        public void setMageIncome(BigDecimal mageIncome) {
            this.mageIncome = mageIncome;
        }


        public void setMageIncome() {


            if(!mageIncomeInit){
                mageIncome.add(new BigDecimal(30));
                mageIncomeInit = true;
            }

            this.mageIncome = (mageIncome.add(new BigDecimal(30)));

            if(mageLevel.compareTo(mageCheck) == 0){
                mageCheck = mageCheck.add(new BigDecimal(10));
                this.mageIncome = mageIncome.multiply(new BigDecimal(2));


            }


        }

        public BigDecimal getMageLevel() {
            return mageLevel;
        }

        public void setMageLevel(BigDecimal mageLevel) {
            this.mageLevel = mageLevel;
        }

        public BigDecimal getMageUpCost() {
            return mageUpCost;
        }


        public void setMageUpCost(BigDecimal mageUpCost) {
            this.mageUpCost = mageUpCost;
        }

        public void setMageUpCost(){

            this.mageUpCost =
                    new BigDecimal(720)
                            .multiply(new BigDecimal(1.70)
                                    .pow(mageLevel.intValueExact()));
        }

        public BigDecimal getMageMaxLevel() {
            return mageMaxLevel;
        }

        public BigDecimal getMinerLevel() {
            return minerLevel;
        }

        public void setMinerLevel(BigDecimal minerLevel) {
            this.minerLevel = minerLevel;
        }

        public BigDecimal getMinerMaxLevel() {
            return minerMaxLevel;
        }

        public void setMinerMaxLevel(BigDecimal minerMaxLevel) {
            this.minerMaxLevel = minerMaxLevel;
        }

        public BigDecimal getMinerUpCost() {
            return minerUpCost;
        }

        public void setMinerUpCost(BigDecimal minerUpCost) {
            this.minerUpCost = minerUpCost;
        }
        public void setMinerUpCost(){

            this.minerUpCost = new BigDecimal(60)
                    .multiply(new BigDecimal(1.50).pow(minerLevel.intValueExact()));

        }

        public BigDecimal getMinerIncome() {
            return minerIncome;
        }

        public void setMinerIncome(BigDecimal minerIncome) {
            this.minerIncome = minerIncome;
        }
        public void setMinerIncome(){
            if(!minerIncomeInit){
                minerIncome.add(new BigDecimal(10));
                minerIncomeInit =true;

            }

            this.minerIncome = (minerIncome.add(new BigDecimal(10)));

            if(minerLevel.compareTo(minerLevelCheck) == 0){
                minerLevelCheck = minerLevelCheck.add(new BigDecimal(15));
                this.minerIncome = minerIncome.multiply(new BigDecimal(2));
            }




        }



        public BigDecimal getTorchIncome() {
            return torchIncome;
        }

        public void setTorchIncome(BigDecimal torchIncome) {
            this.torchIncome = torchIncome;
        }


        public void setTorchIncome() {



            this.torchIncome = (torchIncome.add(new BigDecimal(2)));

            //Sickle Multipler

            if (torchLevel.compareTo(torchLevelCheck) == 0) {
                torchLevelCheck = torchLevelCheck.add(new BigDecimal(25));
                this.torchIncome = torchIncome.multiply(new BigDecimal(2));

            }
        }


        public BigDecimal getTorchLevel() {
            return torchLevel;
        }

        public void setTorchLevel(BigDecimal torchLevel) {
            this.torchLevel = torchLevel;
        }

        public BigDecimal getTorchMaxLevel() {
            return torchMaxLevel;
        }

        public void setTorchMaxLevel(BigDecimal torchMaxLevel) {
            this.torchMaxLevel = torchMaxLevel;
        }

        public BigDecimal getTorchUpCost() {
            return torchUpCost;
        }

        public void setTorchUpCost(BigDecimal torchUpCost) {
            this.torchUpCost = torchUpCost;
        }

        public void setTorchUpCost() {

            this.torchUpCost = new BigDecimal(4)
                    .multiply(new BigDecimal(1.20).pow(torchLevel.intValueExact()));
        }



        //ore income
        public BigDecimal getOreIncome() {

            this.oreIncome = minerIncome.add(mageIncome).add(monsterIncome);

            return oreIncome;
        }

        public void setOreIncome(BigDecimal oreIncome) {
            this.oreIncome = oreIncome;
        }
        public BigDecimal getOre() {
            return ore;
        }

        public void setOre(BigDecimal ore) {
            this.ore = ore;
        }

        public BigDecimal getMonsterIncome() {
            return monsterIncome;
        }

        public void setMonsterIncome(BigDecimal monsterIncome) {
            this.monsterIncome = monsterIncome;

        }
        public void setMonsterIncome() {

            if(!monsterIncomeInit){
                monsterIncome.add(new BigDecimal(360));
                monsterIncomeInit = true;
            }

            this.monsterIncome = (monsterIncome.add(new BigDecimal(360)));

            if(monsterLevel.compareTo(monsterLevelCheck) == 0){
                monsterLevelCheck = monsterLevelCheck.add(new BigDecimal(5));
                this.monsterIncome = monsterIncome.multiply(new BigDecimal(2));

            }


        }

        public void setMonsterUpCost() {
            this.monsterUpCost = new BigDecimal(8640)
                    .multiply(new BigDecimal(1.9)
                            .pow(monsterLevel.intValueExact()));
        }

        public BigDecimal getMonsterLevel() {
            return monsterLevel;
        }

        public void setMonsterLevel(BigDecimal monsterLevel) {
            this.monsterLevel = monsterLevel;
        }

        public BigDecimal getMonsterMaxLevel() {
            return monsterMaxLevel;
        }

        public void setMonsterMaxLevel(BigDecimal monsterMaxLevel) {
            this.monsterMaxLevel = monsterMaxLevel;
        }

        public BigDecimal getMonsterUpCost() {
            return monsterUpCost;
        }

        public void setMonsterUpCost(BigDecimal monsterUpCost) {
            this.monsterUpCost = monsterUpCost;
        }
    }












