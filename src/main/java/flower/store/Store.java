package flower.store;

import lombok.Getter;

import java.util.ArrayList;

public class Store {
    @Getter
    private ArrayList<FlowerBucket> buckets = new ArrayList<>();

    public void addBucket(FlowerBucket bucket) {
        buckets.add(bucket);
    }

    public boolean searchBucket(FlowerBucket bucket) {
        return buckets.contains(bucket);
    }
}
