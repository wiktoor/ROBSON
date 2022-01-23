package zadanie2;

public class Mniejszy extends Wyrażenie {
    private Wyrażenie argument1;
    private Wyrażenie argument2;

    // konstuktor
    public Mniejszy(Wyrażenie argument1, Wyrażenie argument2) {
        super("<");
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public double wykonaj() throws BladWykonania {
        if (argument1.wykonaj() < argument2.wykonaj()) return 1;
        else return 0;
    }
}
