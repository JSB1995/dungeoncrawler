package Items;
import Main.*;

public class Key extends Item{
    private final int ID;

    public Key(String name, String description, Container aContainer){
        super(name, description, Weight.KEY.getWeight());
        ID = aContainer.getID();
    }

    public int getID(){
        return ID;
    }
}
