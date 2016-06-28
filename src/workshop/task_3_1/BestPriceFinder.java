package workshop.task_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * Created by olenasyrota on 6/28/16.
 * This is from chapter 11 of a book "Java 8 in Action: Lambdas, Streams and functional-style programming"
 */
public class BestPriceFinder {


    public static List<String> findPricesSequential(List<Shop> shops, String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesParallel(List<Shop> shops, String product) {
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesFuture(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                });

        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                    () -> shop.getName() + " price is " + shop.getPrice(product),
                                    executor))
                        .collect(Collectors.toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }



}