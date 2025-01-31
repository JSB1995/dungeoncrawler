package Items;

import java.util.HashMap;
import Main.*;

public class Potion extends Item {
    private PotionType type;
    private Potency potency;

    private final static HashMap<String, String> descriptions = new HashMap<>() {{
        put("Weak Healing Potion", "Heals recipient for a small amount of HP.");
        put("Healing Potion", "Heals recipient for a moderate amount of HP.");
        put("Greater Healing Potion", "Heals recipient for a great amount of HP");

        put("Weak Mana Potion", "Restores a small amount of mana");
        put("Mana Potion", "Restores a moderate amount of mana");
        put("Greater Mana Potion", "Restores a greats amount of mana");

        //Mer potions
    }};

    /**
     * Creates a 'potion'-item.
     * @param type Specifies what type of potion it is.
     * @param potency Specifies the potency of the potion.
     */
    public Potion(PotionType type, Potency potency){
        super(potency + " " + type + " Potion", getDescription(potency + " " + type + " Potion"),
            Weight.POTION.getWeight());
    }

    private static String getDescription(String potionName){
        return descriptions.get(potionName);
    }
}
