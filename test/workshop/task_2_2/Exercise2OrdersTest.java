package workshop.task_2_2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Exercise2OrdersTest extends CompanyDomain
{
    /**
     *  Aggregate the total order values by city.
     */
    @Test
    public void totalOrderValuesByCity()
    {
        // implement customer.getTotalOrderValue() for this exercise;

        Map<String, Double> map = null;

        assertEquals(2, map.size());
        assertEquals(446.25, map.get("London"), 0.0);
        assertEquals(857.0, map.get("Liphook"), 0.0);
    }

    /**
     * Extra credit. Create a map where the values are customers and the key is the price of
     * the most expensive item that the customer ordered.
     */

    @Test
    public void mostExpensiveItem()
    {
        Map<Double, List<Customer>> map = null;

        Assert.assertEquals(2, map.size());
        Assert.assertEquals(2, map.entrySet().size());
        Assert.assertEquals(
                Arrays.asList(
                        this.company.getCustomerNamed("Fred"),
                        this.company.getCustomerNamed("Bill")),
                map.get(50.0));
    }



}
