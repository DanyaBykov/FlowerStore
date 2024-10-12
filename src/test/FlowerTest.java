import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

import ua.apps.ucu.edu.flowers.FlowerBucket;
import ua.apps.ucu.edu.flowers.Flower;
import ua.apps.ucu.edu.flowers.FlowerPack;
import ua.apps.ucu.edu.flowers.FlowerType;
import ua.apps.ucu.edu.flowers.Store;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testType() {
        FlowerType type = FlowerType.ROSE;
        flower.setType(type);
        Assertions.assertEquals("Rose", flower.getType());
    }

    @Test
    public void testSepalLength() {
        int sepalLength = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testToString() {
        flower.setPrice(10);
        flower.setColor(FlowerColor.RED);
        flower.setType(FlowerType.ROSE);
        flower.setSepalLength(10);
        Assertions.assertEquals("Flower{price=10, color=#FF0000, type=Rose, sepalLength=10}", flower.toString());
    }

    @Test
    public void testStore() {
        Store store = new Store();
        store.addFlower(flower);
        Assertions.assertEquals(1, store.getFlowers().size());
    }
}
