package zadanie2;

public class Minus extends Wyrażenie {
    private Wyrażenie argument1;
    private Wyrażenie argument2;

    // konstruktor
    public Minus(Wyrażenie argument1, Wyrażenie argument2) {
        super("Minus");
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    // funkcje pomocnicze
    public double wykonaj() throws BladWykonania {
        return argument1.wykonaj() - argument2.wykonaj();
    }
}
