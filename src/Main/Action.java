package Main;

import java.util.HashMap;

public enum Action {

    GO("Go"),
    INVENTORY("Inventory"),
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
        put("Go", "Go <Main.Direction>.");
        put("Inventory", "To see your inventory.");
        put("Back", "Use to retrace your steps.");
        put("Move", "Move <Main.Direction>.");
        put("Use", "Use <Item> if it is equipped, or perhaps a lever nearby.");
        put("Take", "Take <Item>.");
        put("Look", "Shows a name and description of your surroundings, as well as current available paths.");
        put("Examine", "Examine <Item>.");
        put("Help", "Shows this helpful list of commands. :) ");
        put("Quit", "Quits the game... you coward.");
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
            case "B" -> Action.BACK;
            case "M" -> Action.MOVE;
            case "U" -> Action.USE;
            case "T" -> Action.TAKE;
            case "L" -> Action.LOOK;
            case "E" -> Action.EXAMINE;
            case "H" -> Action.HELP;
            case "Q" -> Action.QUIT;
            default -> Action.UNKNOWN;
        };
    }

    public static boolean isShortcut(String word){
        if(word.length() > 1){
            return false;
        }
        Character toCheck = word.charAt(0);
        for(Action action : Action.values()){
            if(toCheck.equals(action.toString().charAt(0))){
                return true;
            }
        }
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
