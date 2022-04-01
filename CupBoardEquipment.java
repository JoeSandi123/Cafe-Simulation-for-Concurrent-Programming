package ccp.assignment;

import java.util.Random;

public class CupBoardEquipment{
    Employee employee;
    
    public CupBoardEquipment(){
         
    }
    public synchronized void cupBoard(String name, Customer custom){
        if(custom.getOrder().equals("FruitJuice")){
            System.out.println(name + " Obtaining Glass From The Board");
            try{
                Thread.sleep(new Random().nextInt(5)*100);
            }catch(Exception e){}
        }
        else{
            System.out.println(name + " Obtaining Cup From The Board");
            try{
                Thread.sleep(new Random().nextInt(5)*100);
            }catch(Exception e){}
        }
    }
    public synchronized void fruitTap(String name){
        System.out.println(name + " Currently Using Fruit Tap");
        try{
            Thread.sleep(new Random().nextInt(5)*100);
        }catch(Exception e){}
        System.out.println(name + " Is Done With The Fruit Juice");
    }
    public synchronized void mixingCoffee(String name){
        System.out.println(name+ " Getting Ingredient From The CupBoard");
        try{
            Thread.sleep(new Random().nextInt(5)*100);
        }catch(Exception e){}
        System.out.println(name + " Mixing Coffee Poweder and Milk");
        try{
            Thread.sleep(new Random().nextInt(5)*100);
        }catch(Exception e){}
        System.out.println(name + " Done Mixing Ingredient Returning Ingredient to CupBoard"); 
    }

}
