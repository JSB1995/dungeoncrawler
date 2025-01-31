package Items;
import Main.*;

public class Key extends Item{
    private int ID;

    public Key(String name, String description, Container aContainer){
        super(name, description, Weight.KEY.getWeight());
    }
}
