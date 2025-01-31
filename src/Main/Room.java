package Main;

import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Room {

    private final HashMap<Direction, Room> exits;
    private final HashMap<String, ArrayList<Item>> items;
    private final HashMap<String, Interactable> interactables;
    private final HashMap<String, Container> containers;
    private String description;
    private final String name;

    /**
     * Creates a new room with a name and description.
     *
    * @param name Name of the room.
    * @param description A description of the room.
    */
    public Room(String name, String description){
        exits = new HashMap<>();
        items = new HashMap<>();
        interactables = new HashMap<>();
        containers = new HashMap<>();
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return  name;
    }

    ///To represent a room visually, in the console.
    public String getBracketName(){
        return "[" + name + "]";
    }

    public String getAvailableExits(){
        String output = "< Available exits >\n";
        for(Direction aDirection : exits.keySet()){
            output += aDirection.toString() + "\n";
        }
        return output;
    }

    public String toString(){
        return "[" + name + "] - " + description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setExit(Direction aDirection, Room aRoom){
        if(!exits.containsKey(aDirection)){
            exits.put(aDirection, aRoom);
            if(!aRoom.hasExit(Direction.getOpposite(aDirection))){
                aRoom.setExit(Direction.getOpposite(aDirection), this);
            }
        }
        else{
            System.out.println(name + " already has an exit.");
        }
    }

    public Room getExit(Direction aDirection){
        return exits.get(aDirection);
    }

    public boolean hasExit(Direction aDirection){
        return exits.containsKey(aDirection);
    }

    public void addItem(Item aItem){
        if(!items.containsKey(aItem.getName())){
            items.put(aItem.getName(), new ArrayList<>());
            items.get(aItem.getName()).add(aItem);
        }
        else{
            items.get(aItem.getName()).add(aItem);
        }
    }

    public Item getItem(String itemName){
        return items.get(itemName).getFirst();
    }

    public ArrayList<Item> getItems(String itemName, int quantity){
        ArrayList<Item> toGet = new ArrayList<>();
        if(quantity <= items.get(itemName).size()){
            Iterator<Item> it = items.get(itemName).iterator();
            while(it.hasNext()){
                toGet.add(it.next());
                items.get(itemName).remove(it.next());
            }
        }
        else{
            System.out.println("There are only " + items.get(itemName).size() + " " + itemName + "s.");
        }
        return toGet;
    }

    public boolean hasItem(String itemName){
        return items.containsKey(itemName) && !items.get(itemName).isEmpty();
    }

    public boolean hasItems(){
        return !items.isEmpty();
    }

    public void showItems(){
        if(!items.isEmpty()){
            System.out.println("You find ");
            for(String itemName : items.keySet()){
                Item item = items.get(itemName).getFirst();
                if(items.get(itemName).size() == 1){
                    System.out.println(item.getBracketName());
                }
                else if(items.get(itemName).size() > 1){
                    System.out.println(item.getBracketName() + " x" + items.get(itemName).size());
                }
            }
        }
        else{
            System.out.println("There are no items.");
        }
    }

    public HashMap<String, ArrayList<Item>> getItems(){
        return items;
    }

    public boolean hasInteractables(){
        return !interactables.isEmpty();
    }

    public boolean hasInteractable(String interactableName){
        return interactables.containsKey(interactableName);
    }

    public void showInteractables(){
        if(!interactables.isEmpty()){
            System.out.println("You see ");
            for(Interactable interactable : interactables.values()){
                System.out.println("[" + interactable.getName() + "]");
            }
        }
        else{
            System.out.println("There is nothing to interact with here");
        }
    }

    public Interactable getInteractable(String interactableName){
        return interactables.get(interactableName);
    }

    public void showContainers(){
        if(!containers.isEmpty()){
            System.out.println("You see ");
            for(Container container : containers.values()){
                System.out.println(container.getVisualName());
            }
        }
        else{
            System.out.println("There are no containers here.");
        }
    }

    public Container getContainer(String containerName){
        return containers.get(containerName);
    }

    public boolean hasContainer(String containerName){
        return containers.containsKey(containerName) && !containers.get(containerName).isEmpty();
    }

    public boolean hasContainers(){
        return !containers.isEmpty();
    }




}
