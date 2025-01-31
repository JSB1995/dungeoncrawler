package Items;

public enum Potency {
    GREATER("Greater"),
    MODERATE(""),
    WEAK("Weak");

    private final String potencyName;

    Potency(String potencyName){
        this.potencyName = potencyName;
    }

    public String getPotencyName(){
        return potencyName;
    }

    public String toString(){
        return potencyName;
    }
}
