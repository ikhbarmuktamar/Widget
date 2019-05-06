package com.worldline.interview;

public class WidgetMachine {
    private Engine engine ;
    private FuelType fuelType;
    private EngineType engineType;


    /* Default constructor for WidgetMachine in using Steam Engine with WOOD fuel type*/
    public WidgetMachine(){
        this.fuelType = FuelType.WOOD;
        this.engineType = EngineType.Steam;
        this.engine = new SteamEngine(this.fuelType);
    }

    /* WidgetMachine constructor that takes EngineType parameter to determine Type of Engine that gonna be use*/
    public WidgetMachine(EngineType engineType){
        this.engineType = engineType;
        //initiate Steam Engine with default Fuel (Wood)
        if (engineType == EngineType.Steam) {
            this.fuelType = FuelType.WOOD;
            this.engine = new SteamEngine(this.fuelType);
        }
        //initiate InternalCombustion Engine with default Fuel (PETROL)
        else if (engineType == EngineType.InternalCombustion) {
            this.fuelType = FuelType.PETROL; this.engine = new InternalCombustionEngine(this.fuelType);
        }
    }

    /* WidgetMachine constructor that takes EngineType parameter to determine Type of Engine that gonna be use*/
    public WidgetMachine(EngineType engineType, FuelType fuelType){
        this.fuelType = fuelType;
        this.engineType = engineType;
        //initiate Steam Engine
        if (engineType == EngineType.Steam && (fuelType == FuelType.WOOD || fuelType == FuelType.COAL)) {
            this.engine = new SteamEngine(this.fuelType);
        }
        //initiate InternalCombustion Engine
        else if (engineType == EngineType.InternalCombustion && (fuelType == FuelType.PETROL || fuelType == FuelType.DIESEL)) {
            this.engine = new InternalCombustionEngine(this.fuelType);
        } else {
            System.out.println("Not suitable Fuel Type.");
            throw new IllegalStateException("Not suitable Fuel Type.");
        }
    }

    /* WidgetMachine constructor that takes EngineType parameter and fuelType paramter with String*/
    public WidgetMachine(String engineType, String fuelType){
        //initiate Steam Engine
        if (engineType.equalsIgnoreCase(EngineType.Steam.toString())){
            if (fuelType.equalsIgnoreCase(FuelType.WOOD.toString())){
                this.fuelType = FuelType.WOOD;
                this.engineType = EngineType.Steam;
                this.engine = new SteamEngine(this.fuelType);
            } else if (fuelType.equalsIgnoreCase(FuelType.COAL.toString())){
                this.fuelType = FuelType.COAL;
                this.engineType = EngineType.Steam;
                this.engine = new SteamEngine(this.fuelType);
            } else {
                System.out.println("Not suitable Fuel Type.");
                throw new IllegalStateException("Not suitable Fuel Type.");
            }
        }
        //initiate InternalCombustion Engine
        else if (engineType.equalsIgnoreCase(EngineType.InternalCombustion.toString())){
            if (fuelType.equalsIgnoreCase(FuelType.DIESEL.toString())){
                this.fuelType = FuelType.DIESEL;
                this.engineType = EngineType.InternalCombustion;
                this.engine = new InternalCombustionEngine(this.fuelType);
            } else if (fuelType.equalsIgnoreCase(FuelType.PETROL.toString())){
                this.fuelType = FuelType.PETROL;
                this.engineType = EngineType.InternalCombustion;
                this.engine = new InternalCombustionEngine(this.fuelType);
            } else {
                System.out.println("Not suitable Fuel Type.");
                throw new IllegalStateException("Not suitable Fuel Type.");
            }
        }
        else {
            System.out.println("Unidentified Engine Type.");
            throw new IllegalStateException("Unidentified Engine Type");
        }
    }

    public double produceWidgets(int quantity) {
        engine.fill(this.fuelType,50);
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    public double produceWidgets(int quantity, FuelType fuelType, int fuelLevel) {
        engine.fill(fuelType,fuelLevel);
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = engine.getCostperBatch();

        while (batch < quantity) {
            batch = batch + engine.getBatchSizeEngine();
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
