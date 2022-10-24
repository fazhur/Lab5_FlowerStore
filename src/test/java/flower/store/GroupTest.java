package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GroupTest {
    private FlowerPack pack;
    private FlowerBucket bucket;
    private Store store;

    @Test
    public void testPack(){
        pack = new FlowerPack();
        Assertions.assertEquals(0, pack.getPrice());
        Flower flower = new Flower();
        flower.setPrice(10);
        pack = new FlowerPack(flower, 5);
        Assertions.assertEquals(50, pack.getPrice());
    }

    @Test
    public void testBucket(){
        bucket = new FlowerBucket();
        Flower flower = new Flower();
        flower.setPrice(10);
        bucket.addPack(new FlowerPack(flower, 10));
        bucket.addPack(new FlowerPack(flower, 5));
        Assertions.assertEquals(150, bucket.getPrice());
        Flower flower1 = new Flower();
        flower1.setPrice(150);
        bucket.addPack(new FlowerPack(flower1, 2));
        Assertions.assertEquals(450, bucket.getPrice());
    }

    @Test
    public void testStore(){
        store = new Store();
        bucket = new FlowerBucket();
        Flower flower = new Flower();
        flower.setPrice(10);
        bucket.addPack(new FlowerPack(flower, 10));
        store.addBucket(bucket);
        bucket = new FlowerBucket();
        Flower flower1 = new Flower();
        flower1.setPrice(20);
        bucket.addPack(new FlowerPack(flower1, 3));
        store.addBucket(bucket);
        Assertions.assertTrue(store.searchBucket(bucket));
        bucket = new FlowerBucket();
        Flower flower2 = new Flower();
        bucket.addPack(new FlowerPack(flower2, 1));
        Assertions.assertFalse(store.searchBucket(bucket));
    }
}
