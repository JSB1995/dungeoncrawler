package Main;

public class Command {
    private final Action action;
    private final String subject;
    private final Direction direction;
    private final int amount;

    public Command(Action action, Direction aDirection) {
        this.action = action;
        this.direction = aDirection;
        this.subject = null;
        this.amount = 0;
    }

    public Command(Action action, String SecondWord){
        this.action = action;
        this.subject = SecondWord;
        this.direction = null;
        this.amount = 0;
    }

    public Command(Action action) {
        this.action = action;
        this.subject = null;
        this.direction = null;
        this.amount = 0;
    }

    public Command(Action action, int amount, String subject){
        this.action = action;
        this.subject = subject;
        this.amount = amount;
        this.direction = null;
    }

    public Action getAction() {
        return action;
    }

    public String getSubject(){
        return subject;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getAmount() {
        return amount;
    }
}
