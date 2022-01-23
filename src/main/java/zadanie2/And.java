package zadanie2;

public class And extends Wyrażenie {
    private Wyrażenie argument1;
    private Wyrażenie argument2;

    // konstruktor
    public And(Wyrażenie argument1, Wyrażenie argument2) {
        super("And");
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public double wykonaj() throws BladWykonania {
        double wartoscWarunku1 = argument1.wykonaj();
        double wartoscWarunku2 = argument2.wykonaj();
        if (wartoscWarunku1 != 0 && wartoscWarunku1 != 1 &&
         wartoscWarunku2 != 0 && wartoscWarunku2 != 1) {
            throw new BladWykonania();
        }
        else if (wartoscWarunku1 == 1 && wartoscWarunku2 == 1) {
            return 1;
        }
        else return 0;
    }
}
