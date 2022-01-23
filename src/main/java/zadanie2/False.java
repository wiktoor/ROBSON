package zadanie2;

public class False extends Wyrażenie {
    // konstruktor
    public False() {
        super("False");
    }
    public double wykonaj() throws BladWykonania {
        return 0;
    }
}
