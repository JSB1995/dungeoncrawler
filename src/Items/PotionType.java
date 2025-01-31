package Items;

public enum PotionType {
    HEALING("Healing"),
    POISONOUS("Poisonous"),
    MANA("Mana"),
    DEFENSE("Defense"),
    CRIPPLING("Crippling");

    private final String potionType;

    PotionType(String potionType){
        this.potionType = potionType;
    }

    public String getPotionType(){
        return potionType;
    }

    public String toString(){
        return potionType;
    }


}
