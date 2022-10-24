package flower.store;

public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public FlowerPack() {
    }

    public double getPrice() {
        try {
            return flower.getPrice() * quantity;
        }
        catch (NullPointerException pointerException) {
            return 0;
        }
    }
}
