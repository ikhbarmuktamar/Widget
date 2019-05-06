package com.worldline.interview;

import org.junit.Test;

public class WidgetTest {

    @Test
    public final void WidgetNormalTest(){
        WidgetMachine machine = new WidgetMachine();
        double result = machine.produceWidgets(10);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test
    public final void WidgetEngineTypeTest(){
        WidgetMachine machine = new WidgetMachine(EngineType.InternalCombustion);
        double result = machine.produceWidgets(24);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }


    @Test
    public final void WidgetEngineFuelTypeTest(){
        WidgetMachine machine = new WidgetMachine(EngineType.InternalCombustion,FuelType.DIESEL);
        double result = machine.produceWidgets(24);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test
    public final void WidgetEngineFuelTypeWithStringTest(){
        WidgetMachine machine = new WidgetMachine("STEAM","WOOD");
        double result = machine.produceWidgets(20,FuelType.WOOD,120);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test(expected = RuntimeException.class)
    public final void WidgetEngineFuelTypeWithStringTest_Negativecase(){
        WidgetMachine machine = new WidgetMachine("STEAM","WOOD");
        double result = machine.produceWidgets(20,FuelType.COAL,120);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test(expected = RuntimeException.class)
    public final void WidgetEngineFuelTypeWithStringTest_Negativecase_2(){
        WidgetMachine machine = new WidgetMachine("STEAM","PETROL");
        double result = machine.produceWidgets(20);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test(expected = RuntimeException.class)
    public final void WidgetEngineFuelTypeWithStringTest_Negativecase_3(){
        WidgetMachine machine = new WidgetMachine("MURLOCK","PETROL");
        double result = machine.produceWidgets(20);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }

    @Test(expected = RuntimeException.class)
    public final void WidgetEngineFuelTypeWithStringTest_Negativecase_4(){
        WidgetMachine machine = new WidgetMachine(EngineType.InternalCombustion,FuelType.COAL);
        double result = machine.produceWidgets(20);
        System.out.println("Production Cost : "+ String.format("%1$,.2f", result));
    }
}
