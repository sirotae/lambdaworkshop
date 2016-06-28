package workshop.task_2_2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class Exercise1SuppliersTest extends CompanyDomain
{
    /**
     * entry point is company.
     * Solve this without changing the return type of {@link Company#getSuppliers()}.
     */
    @Test
    public void findSupplierNames()
    {
        List<String> supplierNames = null;

        List<String> expectedSupplierNames = Arrays.asList(
                "Shedtastic",
                "Splendid Crocks",
                "Annoying Pets",
                "Gnomes 'R' Us",
                "Furniture Hamlet",
                "SFD",
                "Doxins");
        Assert.assertEquals(expectedSupplierNames, supplierNames);
    }

    /**
     * entry point is company.
     * Create a {@link Predicate} for Suppliers that supply more than 2 items. Find the number of suppliers that
     * satisfy that Predicate.
     */
    @Test
    public void countSuppliersWithMoreThanTwoItems()
    {
        Predicate<Supplier> moreThanTwoItems = null;
        int suppliersWithMoreThanTwoItems = 0;
        Assert.assertEquals("suppliers with more than 2 items", 5, suppliersWithMoreThanTwoItems);
    }

}