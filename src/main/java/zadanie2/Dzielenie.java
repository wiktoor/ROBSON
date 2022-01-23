package zadanie2;

public class Dzielenie extends Wyrażenie {
    private Wyrażenie argument1;
    private Wyrażenie argument2;

    // konstruktor
    public Dzielenie(Wyrażenie argument1, Wyrażenie argument2) {
        super("Dzielenie");
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    // funkcje pomocnicze
    public double wykonaj() throws BladWykonania {
        double wartoscWarunku2 = argument2.wykonaj();
        if (wartoscWarunku2 == 0) throw new BladWykonania();
        return argument1.wykonaj() / wartoscWarunku2;
    }
}
