package ccp.assignment;

import java.util.Random;

public class AutoGeneratedCustomer implements Runnable{
    int counter = 1;
    Cafe cafe;
    boolean close = false;
    
    public AutoGeneratedCustomer(Cafe cf){
        cafe = cf;
    }
    public void run(){
        while(!close){
            Customer customer = new Customer(cafe);
            Thread threadcustomer = new Thread(customer);
            customer.setCustomerName("Customer " + counter);
            counter++;
            threadcustomer.start();
            
            try{
                Thread.sleep(new Random().nextInt(5)*300);
            }
            catch(Exception e){}
        }
    }
    public synchronized void close(){
        close = true;
    }
}
