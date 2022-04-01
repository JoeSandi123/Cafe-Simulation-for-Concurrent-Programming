package ccp.assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Employee implements Runnable {
    Cafe cf;
    CupBoardEquipment cbe;
    Customer customer;
    boolean close = false;
    Owner owner;
    Waiter waiter;
    public Employee(Cafe cafe, CupBoardEquipment cupboard){
        cf = cafe;
        cbe = cupboard;
    }
    public void servingCustomer(String name){
        synchronized(cf.list){
            while (cf.list.size() == 0 && !close){
                System.out.println(name + " Is Waiting For New Customer to Enter");
                return;
            }
            customer = (Customer)((LinkedList<?>)cf.list).poll();
            System.out.println(name + " Saw Customer Entered");
        }
        System.out.println(name + " Serving " + customer.getCustomerName());
        if (customer.getOrder().equals("FruitJuice")){
            cbe.cupBoard(name,customer);
            cbe.fruitTap(name);
        }
        else{
            cbe.cupBoard(name,customer);
            cbe.mixingCoffee(name);
        }
        System.out.println("Done Serving " + customer.getOrder() + " to " + customer.getCustomerName());
        System.out.println(customer.getCustomerName() + " Pays The Bill And Exit The Cafe");
    }
    public void run(){
        owner = new Owner(cf,cbe);
        Thread threadowner = new Thread(owner);
        threadowner.start();
        waiter = new Waiter(cf,cbe);
        Thread threadwaiter = new Thread(waiter);
        threadwaiter.start();
    }
        public synchronized void close(){
        owner.close = true;
        waiter.close = true;
        System.out.println("Owner: The Cafe Is Now Close. Comeback Again Tomorrow and Thank You.");
    }
}