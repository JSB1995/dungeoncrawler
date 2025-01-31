package Items;

public abstract class Item {
    private final String name;
    private final String description;
    private final double weight;

    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBracketName(){
        return "[" + name + "]";
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "[" + name + "] - " + description;
    }
}
