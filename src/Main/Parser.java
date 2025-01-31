package Main;

import java.util.Scanner;

public class Parser {
    private final Scanner inputReader;

    public Parser(){
        inputReader = new Scanner(System.in);
    }

    public Command parseCommand(){
        System.out.print("> ");
        String input = inputReader.nextLine();
        Scanner tokenizer =  new Scanner(input);
        String firstWord = "";
        Action action = Action.UNKNOWN;

        if(tokenizer.hasNext()){
            firstWord = capitalizeFirst(tokenizer.next());
        }
        else{
            return new Command(action);
        }

        if(Action.isAction(firstWord) || Action.isShortcut(firstWord)){
            if(firstWord.length() == 1){
                action =  Action.shortcut(firstWord);
            }
            else{
                action = Action.getAction(firstWord);
            }

            switch(action){
                case Action.GO, Action.MOVE:
                    return parseDirectionalCommand(tokenizer, action);
                case Action.QUIT, Action.HELP, Action.LOOK, Action.INVENTORY, Action.BACK:
                    return new Command(action);
                case Action.EXAMINE:
                    return parseExamineCommand(tokenizer, action);
                case Action.TAKE:
                    return parseTakeCommand(tokenizer, action);
            }
        }
        else {
            System.out.println(firstWord + " isn't a valid action.");
        }
        return new Command(Action.UNKNOWN);
    }

    private Command parseDirectionalCommand(Scanner tokenizer, Action action){
        String direction = "";
        Direction aDirection = Direction.UNKNOWN;

        if(tokenizer.hasNext()) {
            direction = capitalizeFirst(tokenizer.next());

            if (Direction.isDirection(direction) || Direction.isShortcut(direction)) {
                if (direction.length() == 1) {
                    aDirection = Direction.shortcut(direction);
                }
                else {
                    aDirection = Direction.getDirection(direction);
                }
            }
        }
        return new Command(action, aDirection);
    }

    private Command parseExamineCommand(Scanner tokenizer, Action action){
        String toExamine = "";
        if(tokenizer.hasNext()){
            while(tokenizer.hasNext()){
                toExamine += tokenizer.next();
                if(tokenizer.hasNext()){
                    toExamine += " ";
                }
            }
            return new Command(action, toExamine);
        }
        else{
            return new Command(action, toExamine);
        }

    }

    private Command parseTakeCommand(Scanner tokenizer, Action action){
        int amount = 0;
        String subject = "";

        if(tokenizer.hasNext()){
            String secondWord = tokenizer.next();
            if(isNumeral(secondWord)){
                amount = Integer.parseInt(secondWord);
            }

            if(tokenizer.hasNext()){
                while(tokenizer.hasNext()){
                    subject += capitalizeFirst(tokenizer.next());
                    if(tokenizer.hasNext()){
                        subject += " ";
                    }
                }
            }
        }
        return new Command(action, amount, subject);
    }

    public String capitalizeFirst(String word){
        char c = word.charAt(0);
        if(c > 96 && c < 123){
            c = Character.toUpperCase(c);
        }
        return c + word.substring(1);
    }

    public boolean isNumeral(String word){
        for(int i = 0; i < word.length(); i++){
            if(!Character.isDigit(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
