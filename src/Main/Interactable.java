package Main;

public abstract class Interactable {
    public String name;
    public String description;


    public Interactable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "<" + name + "> - " + description;
    }
}
