package Main;

public enum Weight {
    KEY(0.5),
    POTION(1);


    private final double weight;

    Weight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
