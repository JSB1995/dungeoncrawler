package Main;

import Items.*
;

public class Main {
    public static void main(String[] args) {
        Room r1 = new Room("Cell", "The walls are moist and moldy, and in front of you" +
                ", the celldoor is slightly ajar.");
        Room r2 = new Room("Hallway", "The hallway extends further off to your right, " +
                "with torches in regular intervals, hanging from the walls.");


        r1.setExit(Direction.NORTH, r2);

        Player p1 = new Player("Link", r1);
        Command currentCommand = null;
        Parser parser = new Parser();

        System.out.println(p1.getCurrentRoom().getBracketName());

        boolean finished = false;
        while(!finished){
            currentCommand = parser.parseCommand();
            if(currentCommand.getAction().toString().equals("Quit")){
                finished = true;
            }
            p1.executeCommand(currentCommand);
        }

    }
}