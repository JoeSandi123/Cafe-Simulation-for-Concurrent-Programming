package ccp.assignment;

import java.util.LinkedList;

public class Owner extends Employee {
    Clock clock;
    
    public Owner(Cafe cafe,CupBoardEquipment ing){
        super(cafe, ing);
    }
    void lastOrder(){
        System.out.println("Owner: Last Order and The Cafe Close At 1 Hour");
        servingCustomer("Owner");
    }
    void servingRest(){
        System.out.println("Owner: Oh! There Is Unserved Customer Left");
        while (close && cf.list.size() != 0){
            customer = (Customer)((LinkedList<?>)cf.list).poll();
            System.out.println("Owner" + " Serving " + customer.getCustomerName());
            if (customer.getOrder().equals("FruitJuice")){
                cbe.cupBoard("Owner",customer);
                cbe.fruitTap("Owner");
            }
            else{
                cbe.cupBoard("Owner",customer);
                cbe.mixingCoffee("Owner");
            }
            System.out.println("Done Serving " + customer.getOrder() + " to " + customer.getCustomerName());
            System.out.println(customer.getCustomerName() + " Pays The Bill And Exit The Cafe");
        }
        System.out.println("Owner: Served All Customer");
        System.out.println("Owner Confirmed the Cafe is Empty");
        System.out.println("Owner is Cleanimg The Cafe");
        System.out.println("Owner Left The Cafe");
        System.out.println("The Total Customer Serve Today is " + cf.totalserve);
    }
    public void run(){
        System.out.println("Ownner Started His Work");
        while(!close){
            servingCustomer("Owner");
            try{
                    Thread.sleep(1000);
                }
                catch (Exception e){}
        }
        if(close && cf.list.size() == 0){
            System.out.println("Owner: Served All Customer");
            System.out.println("Owner Confirmed the Cafe is Empty");
            System.out.println("Owner is Cleanimg The Cafe");
            System.out.println("Owner Left The Cafe");
            System.out.println("The Total Customer Serve Today is " + cf.totalserve);
        }
    } 
}
