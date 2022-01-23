package zadanie2;

public class Not extends Wyrażenie {
    private Wyrażenie argument;

    // konstruktor
    public Not(Wyrażenie argument) {
        super("Not");
        this.argument = argument;
    }

    public double wykonaj() throws BladWykonania {
        double wartoscWarunku = argument.wykonaj();
        if (wartoscWarunku == 0) {
            return 1;
        }
        else if (wartoscWarunku == 1) {
            return 0;
        }
        else {
            throw new BladWykonania();
        }
    }
}
