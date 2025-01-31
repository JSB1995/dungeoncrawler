package Main;

import Items.*;
import java.util.ArrayList;
import java.util.HashMap;
import Main.*;

public class Container {
    private final String name;
    protected final HashMap<String, ArrayList<Item>> contents;
    private final String description;
    private static int IDHolder = 0;
    private final int ID;

    public Container(String name, String description){
        IDHolder++;
        this.name = name;
        contents = new HashMap<>();
        ID = IDHolder;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    ///Used to show the name to the user in the terminal.
    public String getVisualName(){
        return "[" + name + "]";
    }

    public String toString(){
        return getVisualName() + " - " + description;
    }

    public boolean hasItem(String itemName){
        return contents.containsKey(itemName);
    }

    public Item getItem(String itemName){
        return contents.get(itemName).getFirst();
    }

    public boolean isEmpty(){
        return contents.isEmpty();
    }

    public void add(Item item){
        if(contents.containsKey(item.getName())){
            contents.get(item.getName()).add(item);
        }
        else{
            contents.put(item.getName(), new ArrayList<>());
            contents.get(item.getName()).add(item);
        }
    }

    public void remove(String toRemove){
        updateContainer();
        if(contents.containsKey(toRemove) && !contents.get(toRemove).isEmpty()){
            contents.get(toRemove).removeFirst();
            if(contents.get(toRemove).isEmpty()){
                contents.remove(toRemove);
                System.out.println(toRemove + " was removed!");
            }
        }
        else{
            System.out.println("No " + toRemove + " to remove.");
        }
    }

    private void updateContainer(){
        for(String itemName : contents.keySet()){
            if(contents.get(itemName).isEmpty()){
                contents.remove(itemName);
            }
        }
    }

    public void showContents(){
        updateContainer();
        if(contents.isEmpty()){
            System.out.println(name + " is empty!");
        }
        else{
            for(String itemName : contents.keySet()){
                if(contents.get(itemName).size() == 1){
                    System.out.println("[" + itemName + "]");
                }
                else if(contents.get(itemName).size() > 1){
                    System.out.println("[" + itemName + "] x"+ contents.get(itemName).size());
                }
            }
        }
    }
}
