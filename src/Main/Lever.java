package Main;

public class Lever extends Interactable{
    private boolean isActivated;

    public Lever(String name, String description, boolean isActivated){
        super(name, description);
        this.isActivated = isActivated;
    }

    public boolean isActivated(){
        return isActivated;
    }
}
