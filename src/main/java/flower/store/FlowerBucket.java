package flower.store;

import lombok.Getter;

import java.util.ArrayList;

public class FlowerBucket {
    @Getter
    private ArrayList<FlowerPack> packs = new ArrayList<>();
    public void addPack(FlowerPack pack) {
        packs.add(pack);
    }
    public double getPrice() {
        double result = 0;
        for (int i = 0; i < packs.size(); ++i){
            result += packs.get(i).getPrice();
        }
        return result;
    }
}
