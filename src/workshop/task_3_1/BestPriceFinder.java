package workshop.task_3_1;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by olenasyrota on 6/28/16.
 * This is from chapter 11 of a book "Java 8 in Action: Lambdas, Streams and functional-style programming"
 */
public class BestPriceFinder {

    private static final Function<ProductPrice, ProductPrice> FINALPRICER = price->{price.calculateFinalPrice();return price;};

    public static List<ProductPrice> findPricesSequential(List<Shop> shops, String product) {
        Function<Shop, ProductPrice> shopPricer = shop -> new ProductPrice (shop.getName(), shop.getPrice(product), 0.08, 0.05);
        return shops.stream()
                .map(
                        shopPricer.andThen(FINALPRICER::apply)
                )
                .collect(Collectors.toList());
    }

    public static List<ProductPrice> findPricesParallel(List<Shop> shops, String product) {
        Function<Shop, ProductPrice> shopPricer = shop -> new ProductPrice (shop.getName(), shop.getPrice(product), 0.08, 0.05);
        return shops.parallelStream()
                .map(shopPricer.andThen(FINALPRICER::apply))
                .collect(Collectors.toList());
    }

    public static List<ProductPrice> findPricesFuture(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                });

        List<CompletableFuture<ProductPrice>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture
                                .supplyAsync(() -> new ProductPrice (shop.getName(), shop.getPrice(product), 0.08, 0.05), executor)
                                .thenApply(FINALPRICER::apply))
                        .collect(Collectors.toList());

        List<ProductPrice> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }


    public static List<ProductPrice> findPricesFutureAsync(List<Shop> shops, String product) {
        Executor executorPrice = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        Executor executorFinalPrice = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        List<CompletableFuture<ProductPrice>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture
                                .supplyAsync(() -> new ProductPrice (shop.getName(), shop.getPrice(product), 0.08, 0.05), executorPrice)
                                .thenApplyAsync(FINALPRICER::apply, executorFinalPrice))
                        .collect(Collectors.toList());

        List<ProductPrice> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }


}