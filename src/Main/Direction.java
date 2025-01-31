package Main;

import java.util.HashMap;

public enum Direction {
    NORTH ("North"),
    SOUTH ("South"),
    EAST ("East"),
    WEST("West"),
    UP("Up"),
    DOWN("Down"),
    UNKNOWN("Unknown");

    private final String name;

    Direction(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public static boolean isDirection(String aDirection){
        for(Direction direction : Direction.values()){
            if(direction.toString().equalsIgnoreCase(aDirection)){
                return true;
            }
        }
        return false;
    }

    public static Direction getOpposite(Direction aDirection){
        return switch (aDirection) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case UP -> DOWN;
            case DOWN -> UP;
            case UNKNOWN -> UNKNOWN;
        };
    }

    public static Direction shortcut(String shortcut){
        return switch (shortcut) {
            case "N" -> Direction.NORTH;
            case "S" -> Direction.SOUTH;
            case "E" -> Direction.EAST;
            case "W" -> Direction.WEST;
            case "U" -> Direction.UP;
            case "D" -> Direction.DOWN;
            default -> Direction.UNKNOWN;
        };
    }

    public static boolean isShortcut(String word){
        if(word.length() > 1){
            return false;
        }
        Character toCheck = word.charAt(0);
        for(Direction direction : Direction.values()){
            if(toCheck.equals(word.charAt(0))){
                return true;
            }
        }
        return false;
    }

    private static HashMap<String, Direction> getDirections(){
        HashMap<String, Direction> directions = new HashMap<>();
        for(Direction direction : Direction.values()){
            directions.put(direction.toString(), direction);
        }
        return directions;
    }

    public static Direction getDirection(String direction){
        if(direction == null){
            return UNKNOWN;
        }
        for(String directionName : getDirections().keySet()){
            if(direction.equalsIgnoreCase(directionName)){
                return getDirections().get(directionName);
            }
        }
        return UNKNOWN;
    }
}
