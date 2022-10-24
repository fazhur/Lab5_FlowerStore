package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GroupTest {
    private FlowerPack pack;
    private FlowerBucket bucket;
    private Store store;

    @Test
    public void testPack() {
        pack = new FlowerPack();
        Assertions.assertEquals(0, pack.getPrice());
        Flower flower = new Flower();
        flower.setPrice(10);
        pack = new FlowerPack(flower, 5);
        Assertions.assertEquals(50, pack.getPrice());
    }

    @Test
    public void testBucket() {
        bucket = new FlowerBucket();
        Flower flower = new Flower();
        flower.setPrice(10);
        bucket.addPack(new FlowerPack(flower, 10));
        bucket.addPack(new FlowerPack(flower, 5));
        Assertions.assertEquals(150, bucket.getPrice());
        Flower flowerOne = new Flower();
        flowerOne.setPrice(150);
        bucket.addPack(new FlowerPack(flowerOne, 2));
        Assertions.assertEquals(450, bucket.getPrice());
    }

    @Test
    public void testStore() {
        store = new Store();
        bucket = new FlowerBucket();
        Flower flower = new Flower();
        flower.setPrice(10);
        bucket.addPack(new FlowerPack(flower, 10));
        store.addBucket(bucket);
        bucket = new FlowerBucket();
        Flower flowerOne = new Flower();
        flowerOne.setPrice(20);
        bucket.addPack(new FlowerPack(flowerOne, 3));
        store.addBucket(bucket);
        Assertions.assertTrue(store.searchBucket(bucket));
        bucket = new FlowerBucket();
        Flower flowerTwo = new Flower();
        bucket.addPack(new FlowerPack(flowerTwo, 1));
        Assertions.assertFalse(store.searchBucket(bucket));
    }
}
