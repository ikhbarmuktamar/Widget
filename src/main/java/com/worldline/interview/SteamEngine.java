package com.worldline.interview;

public class SteamEngine implements Engine{

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;
    private int batchSizeEngine = 2;

    public SteamEngine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
            System.out.println("Steam Engine.....start");
        } else {
            System.out.println("Not able to start engine.");
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
        System.out.println("Engine .... Stop");
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
//            this.fuelLevel = this.fuelLevel >= 100 ? 100 : this.fuelLevel;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        } else {
            this.fuelLevel = 0;
        }
        this.fuelType = fuelType;
        System.out.println("Filling the engine with "+this.fuelType.toString());
    }

    public FuelType getFuelType() {
        return  requiredFuelType;
    }

    public int getBatchSizeEngine() {
        return this.batchSizeEngine;
    }

    public double getCostperBatch() {
        double cost = 0;
        switch (this.fuelType){
            case WOOD:
                cost = 4.35; break;
            case COAL:
                cost = 5.65; break;
        }
        return cost;
    }
}
