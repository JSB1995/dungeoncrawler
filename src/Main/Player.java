package Main;

import Items.*;

import java.util.Iterator;
import java.util.Stack;

public class Player {
    private String name;
    private Room currentRoom;
    private Bag bag;
    private final Stack<Direction> movements;

    public Player(String name, Room currentRoom){
        this.name = name;
        this.currentRoom = currentRoom;
        movements = new Stack<Direction>();
        bag = new Bag(name + "'s Bag", 20);
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public String getName(){
        return name;
    }

    public Bag getBag(){
        return bag;
    }

    public void setCurrentRoom(Room newRoom){
        currentRoom = newRoom;
    }

    private void goBack(){
        if(!movements.isEmpty()){
            Direction aDirection = Direction.getOpposite(movements.pop());
            move(aDirection);
            movements.push(aDirection);
        }
        else{
            System.out.println("Can't go back.");
        }
    }

    /**
     * Attempts to move the player in a given direction, otherwise informs user
     * that they can't move that way.
     * @param aDirection A direction in which to the player attempts to move.
     */
    private void move(Direction aDirection){
        if(aDirection == Direction.UNKNOWN){
            System.out.println("Go where...?");
        }

        if(currentRoom.hasExit(aDirection)){
            System.out.println("You move " + aDirection.toString() + "\n");
            setCurrentRoom(currentRoom.getExit(aDirection));
            System.out.println(currentRoom.getBracketName());
            movements.push(aDirection);
        }
        else{
            if(!aDirection.toString().equals("Unknown")){
                System.out.println("You can't move " + aDirection.toString() + "\n");
            }
        }
    }

    private void take(String item, int quantity){
        int itemsTaken = 0;
        if(quantity >= 1){
            if(currentRoom.hasItem(item)){
                if(quantity <= currentRoom.getItems().get(item).size()){
                    Iterator<Item> it = currentRoom.getItems().get(item).iterator();
                    while(it.hasNext()){
                        Item toTake = it.next();
                        if(bag.hasRoom(toTake)){
                            bag.add(toTake);
                            currentRoom.getItems().remove(toTake.getName());
                            itemsTaken++;
                        }
                    }
                }
                if(itemsTaken == 1){
                    System.out.println("You take " + item + ".");
                }
                else {
                    System.out.println("You take " + itemsTaken + " " + item + "s.");
                }
            }
            else{
                System.out.println("There is no " + item + " here.");
            }
        }
        else{
            System.out.println("Invalid quantity.");
        }
    }

    private void examineSurroundings(Command aCommand){
        if(currentRoom.hasItems() && currentRoom.hasInteractables()){
            currentRoom.showItems();
            System.out.println(" and ");
            currentRoom.showInteractables();
        }
        else if(currentRoom.hasItems()){
            currentRoom.showItems();
        }
        else if(currentRoom.hasInteractables()){
            currentRoom.showInteractables();
        }
        else{
            System.out.println("You find nothing..");
        }

    }

    private void examine(Command aCommand){
        String toExamine = aCommand.getSubject();

        if(Synonyms.isAreaSyn(toExamine) || toExamine.equalsIgnoreCase(currentRoom.getName())){
            examineSurroundings(aCommand);
        }
        if(bag.hasItem(toExamine)){
            System.out.println(bag.getItem(toExamine));
        }
        else if(currentRoom.hasItem(toExamine)){
            System.out.println(currentRoom.getItem(toExamine));
        }
        if(currentRoom.hasInteractable(toExamine)){
            System.out.println(currentRoom.getInteractable(toExamine));
        }
        if(currentRoom.hasContainer(toExamine)){
            System.out.println(currentRoom.getContainer(toExamine));
        }
    }

    private void lookAround(){
        System.out.println(currentRoom);
        System.out.println(currentRoom.getAvailableExits());
    }

    public void checkInventory(){
        System.out.println(bag.getVisualName());
        bag.showContents();
    }

    public void executeCommand(Command aCommand){
        switch(aCommand.getAction()){
            case Action.GO, Action.MOVE -> move(aCommand.getDirection());
            case Action.LOOK -> lookAround();
            case Action.HELP -> Action.showActions();
            case Action.EXAMINE -> examine(aCommand);
            case Action.TAKE -> take(aCommand.getSubject(), aCommand.getAmount());
            case Action.INVENTORY -> checkInventory();
            case Action.BACK -> goBack();
        }
    }

}
