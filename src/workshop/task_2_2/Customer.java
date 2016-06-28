package workshop.task_2_2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Customer {

    private final String name;
    private final String city;

    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order anOrder) {
        this.orders.add(anOrder);
    }

    public double getTotalOrderValue() {
        throw new NotImplementedException();
    }

    public double getMostExpensiveItemValue() {
        throw new NotImplementedException();
    }
}