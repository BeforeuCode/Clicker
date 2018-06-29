package Models;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ForestModel {

    private BigDecimal wood = new BigDecimal(1000000000);
    private BigDecimal woodIncome = new BigDecimal(0);

    //axe
    private BigDecimal axeIncome = new BigDecimal(1);
    private BigDecimal axeLevel = new BigDecimal(1);
    private BigDecimal axeMaxLevel = new BigDecimal(50);
    private BigDecimal axeUpCost = new BigDecimal(4);
    private BigDecimal axeLevelCheck = new BigDecimal(24);

    //elf
    private BigDecimal elfIncome = new BigDecimal(0);
    private BigDecimal elfLevel = new BigDecimal(0);
    private BigDecimal elfMaxLevel = new BigDecimal(30);
    private BigDecimal elfUpCost = new BigDecimal(60);
    private BigDecimal elfLevelCheck = new BigDecimal(9);
    private boolean elfIncomeInit = false;

    //lumberjack
    private BigDecimal lumberjackIncome = new BigDecimal(0);
    private BigDecimal lumberjackLevel = new BigDecimal(0);
    private BigDecimal lumberjackMaxLevel = new BigDecimal(20);
    private BigDecimal lumberjackUpCost = new BigDecimal(720);
    private BigDecimal lumberjackLevelCheck = new BigDecimal(9);
    private boolean lumberjackIncomeInit = false;

    //woodcutter

    private BigDecimal woodcutterIncome = new BigDecimal(0);
    private BigDecimal woodcutterLevel = new BigDecimal(0);
    private BigDecimal woodcutterMaxLevel = new BigDecimal(10);
    private BigDecimal woodcutterUpCost = new BigDecimal(8640);
    private BigDecimal woodcutterLevelCheck = new BigDecimal(4);
    private boolean woodcutterIncomeInit = false;

















    public BigDecimal getLumberjackIncome() {
        return lumberjackIncome;
    }

        public void setLumberjackIncome(BigDecimal lumberjackIncome) {
            this.lumberjackIncome = lumberjackIncome;
        }


            public void setLumberjackIncome() {


                if(!lumberjackIncomeInit){
                    lumberjackIncome.add(new BigDecimal(30));
                    lumberjackIncomeInit = true;
                }

                this.lumberjackIncome = (lumberjackIncome.add(new BigDecimal(30)));

                if(lumberjackLevel.compareTo(lumberjackLevelCheck) == 0){
                    lumberjackLevelCheck = lumberjackLevelCheck.add(new BigDecimal(10));
                    this.lumberjackIncome = lumberjackIncome.multiply(new BigDecimal(2));


                }


            }

                public BigDecimal getLumberjackLevel() {
                    return lumberjackLevel;
                }

                    public void setLumberjackLevel(BigDecimal lumberjackLevel) {
                        this.lumberjackLevel = lumberjackLevel;
                    }

                        public BigDecimal getLumberjackUpCost() {
                            return lumberjackUpCost;
                        }


                            public void setLumberjackUpCost(BigDecimal lumberjackUpCost) {
                                this.lumberjackUpCost = lumberjackUpCost;
                            }

                                public void setLumberjackUpCost(){

                                    this.lumberjackUpCost =
                                            new BigDecimal(720)
                                                .multiply(new BigDecimal(1.70)
                                                        .pow(lumberjackLevel.intValueExact()));
                                }

                                    public BigDecimal getLumberjackMaxLevel() {
                                        return lumberjackMaxLevel;
                                    }

    public BigDecimal getElfLevel() {
        return elfLevel;
    }

        public void setElfLevel(BigDecimal elfLevel) {
            this.elfLevel = elfLevel;
        }

            public BigDecimal getElfMaxLevel() {
                return elfMaxLevel;
            }

                public void setElfMaxLevel(BigDecimal elfMaxLevel) {
                    this.elfMaxLevel = elfMaxLevel;
                }

                    public BigDecimal getElfUpCost() {
                        return elfUpCost;
                    }

                        public void setElfUpCost(BigDecimal elfUpCost) {
                            this.elfUpCost = elfUpCost;
                        }
                            public void setElfUpCost(){

                                this.elfUpCost = new BigDecimal(60)
                                        .multiply(new BigDecimal(1.50).pow(elfLevel.intValueExact()));

                            }

                                    public BigDecimal getElfIncome() {
                                        return elfIncome;
                                    }

                                        public void setElfIncome(BigDecimal elfIncome) {
                                            this.elfIncome = elfIncome;
                                        }
                                            public void setElfIncome(){
                                                if(!elfIncomeInit){
                                                    elfIncome.add(new BigDecimal(10));
                                                    elfIncomeInit =true;

                                                }

                                                this.elfIncome = (elfIncome.add(new BigDecimal(10)));

                                                if(elfLevel.compareTo(elfLevelCheck) == 0){
                                                    elfLevelCheck = elfLevelCheck.add(new BigDecimal(15));
                                                    this.elfIncome = elfIncome.multiply(new BigDecimal(2));
                                                }




                                            }



    public BigDecimal getAxeIncome() {
        return axeIncome;
    }

        public void setAxeIncome(BigDecimal axeIncome) {
            this.axeIncome = axeIncome;
        }


            public void setAxeIncome() {



                this.axeIncome = (axeIncome.add(new BigDecimal(2)));

                //Sickle Multipler

                if (axeLevel.compareTo(axeLevelCheck) == 0) {
                    axeLevelCheck = axeLevelCheck.add(new BigDecimal(25));
                    this.axeIncome = axeIncome.multiply(new BigDecimal(2));

                }
            }


                public BigDecimal getAxeLevel() {
                    return axeLevel;
                }

                    public void setAxeLevel(BigDecimal axeLevel) {
                        this.axeLevel = axeLevel;
                    }

                        public BigDecimal getAxeMaxLevel() {
                            return axeMaxLevel;
                        }

                            public void setAxeMaxLevel(BigDecimal axeMaxLevel) {
                                this.axeMaxLevel = axeMaxLevel;
                            }

                                public BigDecimal getAxeUpCost() {
                                    return axeUpCost;
                                }

                                    public void setAxeUpCost(BigDecimal axeUpCost) {
                                        this.axeUpCost = axeUpCost;
                                    }

                                        public void setAxeUpCost() {

                                            this.axeUpCost = new BigDecimal(4)
                                                    .multiply(new BigDecimal(1.20).pow(axeLevel.intValueExact()));
                                        }



    //wood income
    public BigDecimal getWoodIncome() {

        this.woodIncome = elfIncome.add(lumberjackIncome).add(woodcutterIncome);

        return woodIncome;
    }

        public void setWoodIncome(BigDecimal woodIncome) {
            this.woodIncome = woodIncome;
        }
            public BigDecimal getWood() {
                return wood;
            }

                public void setWood(BigDecimal wood) {
                    this.wood = wood;
                }

    public BigDecimal getWoodcutterIncome() {
        return woodcutterIncome;
    }

        public void setWoodcutterIncome(BigDecimal woodcutterIncome) {
            this.woodcutterIncome = woodcutterIncome;

        }
            public void setWoodcutterIncome() {

                if(!woodcutterIncomeInit){
                    woodcutterIncome.add(new BigDecimal(360));
                    woodcutterIncomeInit = true;
                }

                    this.woodcutterIncome = (woodcutterIncome.add(new BigDecimal(360)));

                        if(woodcutterLevel.compareTo(woodcutterLevelCheck ) == 0){
                            woodcutterLevelCheck = woodcutterLevelCheck.add(new BigDecimal(5));
                            this.woodcutterIncome = woodcutterIncome.multiply(new BigDecimal(2));

                        }


                            }

                                public void setWoodcutterUpCost() {
                                    this.woodcutterUpCost = new BigDecimal(8640)
                                                .multiply(new BigDecimal(1.9)
                                                    .pow(woodcutterLevel.intValueExact()));
                                }

                                    public BigDecimal getWoodcutterLevel() {
                                        return woodcutterLevel;
                                    }

                                        public void setWoodcutterLevel(BigDecimal woodcutterLevel) {
                                            this.woodcutterLevel = woodcutterLevel;
                                        }

                                            public BigDecimal getWoodcutterMaxLevel() {
                                                return woodcutterMaxLevel;
                                            }

                                                public void setWoodcutterMaxLevel(BigDecimal woodcutterMaxLevel) {
                                                    this.woodcutterMaxLevel = woodcutterMaxLevel;
                                                }

                                                    public BigDecimal getWoodcutterUpCost() {
                                                        return woodcutterUpCost;
                                                    }

                                                        public void setWoodcutterUpCost(BigDecimal woodcutterUpCost) {
                                                            this.woodcutterUpCost = woodcutterUpCost;
                                                        }
    }









