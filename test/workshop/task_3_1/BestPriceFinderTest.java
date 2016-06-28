package workshop.task_3_1;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class BestPriceFinderTest {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    @Test
    public void findPricesSequential() {
        long start = System.nanoTime();
        BestPriceFinder.findPricesSequential(shops, "myPhone27S");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Sequential done in " + duration + " msecs");
    }

    @Test
    public void findPricesParallel() {
        long start = System.nanoTime();
        BestPriceFinder.findPricesParallel(shops, "myPhone27S");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Parallel done in " + duration + " msecs");
    }

    @Test
    public void findPricesFuture() {
        long start = System.nanoTime();
        BestPriceFinder.findPricesFuture(shops, "myPhone27S");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Future done in " + duration + " msecs");
    }

}