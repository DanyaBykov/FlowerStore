import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import ua.apps.ucu.edu.flowers.FlowerBucket;
import ua.apps.ucu.edu.flowers.Flower;
import ua.apps.ucu.edu.flowers.FlowerPack;


public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testAdd() {
        Flower flower = new Flower();
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, 10);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(1, flowerBucket.getFlowerPacks().size());
    }

    @Test
    public void testPriceEmptyBucket() {
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }
}
