package ccp.assignment;

import java.util.List;

public class Waiter extends Employee{
    Clock clock;
    boolean lastorder = false;
    
    public Waiter(Cafe cafe,CupBoardEquipment ing){
        super(cafe, ing);
    }
    public void run(){
        System.out.println("Waiter Started His Work");
        while(!close){
            servingCustomer("Waiter");
            try{
                    Thread.sleep(1000);
                }
                catch (Exception e){}
        }
        System.out.println("Waiter: Bye Owner See You Tomorrow.");
        System.out.println("Waiter Left The Cafe");
    }
}
