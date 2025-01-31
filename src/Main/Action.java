package Main;

import java.util.HashMap;

public enum Action {

    GO("Go"),
    INVENTORY("Inventory"),
    EQUIP("Equip"),
    UNEQUIP("Unequip"),
    BACK("Back"),
    MOVE("Move"),
    USE("Use"),
    TAKE("Take"),
    LOOK("Look"),
    EXAMINE("Examine"),
    HELP("Help"),
    QUIT("Quit"),
    UNKNOWN("Unknown");

    private final String actionName;

    Action(String actionName){
        this.actionName = actionName;
    }

    public String getActionName(){
        return actionName;
    }

    public String toString(){
        return actionName;
    }

    public static boolean isAction(String word){
        for(Action action : Action.values()){
            if(action.toString().equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }

    private static final HashMap<String, String> actions = new HashMap<>() {{
        put("(G)o", "Go <Main.Direction>.");
        put("(I)nventory", "To see your inventory.");
        put("(E)quip", "Equip <Item>, if it's in your bag.");
        put("(Un)equip", "Unequips currently held item.");
        put("(B)ack", "Use to retrace your steps.");
        put("(M)ove", "Move <Main.Direction>.");
        put("(U)se", "Use <Item> if it is equipped, or perhaps a lever nearby.");
        put("(T)ake", "Take <Item>.");
        put("(L)ook", "Shows a name and description of your surroundings, as well as current available paths.");
        put("(Ex)amine", "Examine <Item>.");
        put("(H)elp", "Shows this helpful list of commands. :) ");
        put("(Q)uit", "Quits the game... you coward.");
    }};


    private static HashMap<String, Action> getActions(){
        HashMap<String, Action> actions = new HashMap<>();
        for(Action action : Action.values()){
            actions.put(action.toString(), action);
        }
        return actions;
    }

    public static Action shortcut(String shortcut){
        return switch (shortcut) {
            case "G" -> Action.GO;
            case "I" -> Action.INVENTORY;
            case "E" -> Action.EQUIP;
            case "Un" -> Action.UNEQUIP;
            case "B" -> Action.BACK;
            case "M" -> Action.MOVE;
            case "U" -> Action.USE;
            case "T" -> Action.TAKE;
            case "L" -> Action.LOOK;
            case "Ex" -> Action.EXAMINE;
            case "H" -> Action.HELP;
            case "Q" -> Action.QUIT;
            default -> Action.UNKNOWN;
        };
    }

    public static boolean isShortcut(String word){
        if(word.length() > 2){
            return false;
        }
        for(Action action : Action.values()){
            if(word.substring(0,1).equalsIgnoreCase(action.toString().substring(0,1))){
                return true;
            }
            else if(word.equalsIgnoreCase(action.toString().substring(0,2))){
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    public static Action getAction(String action){
        if(action == null){
            return UNKNOWN;
        }
        for(String actionName : actions.keySet()){
            if(action.equalsIgnoreCase(actionName)){
                return getActions().get(action);
            }
        }
        return UNKNOWN;
    }

    public static void showActions(){
        System.out.println("--- <HELP> ---");
        for(String action : actions.keySet()){
            System.out.println(action + " - " + actions.get(action));
        }
        System.out.println("--- <HELP> ---");
    }

}
