package zadanie2;

public class True extends Wyrażenie {
    // konstruktor
    public True() {
        super("True");
    }
    public double wykonaj() throws BladWykonania {
        return 1;
    }
}
