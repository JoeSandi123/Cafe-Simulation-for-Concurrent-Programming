package ccp.assignment;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jdk.nashorn.internal.ir.BreakNode;

public class Cafe {
    int emptySit = 10;
    int totalserve = 0;
    List<Customer>list;
    
    public Cafe(){
        list = new LinkedList<Customer>();
    }
    public boolean addCustomer(Customer customer){
        System.out.println(customer.getCustomerName() + " Enter The Cafe");
        synchronized(list){
            if (list.size() == emptySit){
                System.out.println(customer.getCustomerName() + ": Oh! The Cafe Is Full. Leaving Now");
                return false;
            }
            else{
                list.add(customer);
                System.out.println(customer.getCustomerName() + " Take a Seat");
                totalserve++;
                return true;
            }
        }
    }
}
