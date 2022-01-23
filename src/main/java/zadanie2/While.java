package zadanie2;

public class While extends Wyrażenie {
    private Wyrażenie warunek;
    private Wyrażenie blok;

    // konstruktor
    public While(Wyrażenie warunek, Wyrażenie blok) {
        super("While");
        this.warunek = warunek;
        this.blok = blok;
    }

    public double wykonaj() throws BladWykonania {
        while (true) {
            double wartoscWarunku = warunek.wykonaj();
            if (wartoscWarunku == 1) {
                blok.wykonaj();
            }
            else if (wartoscWarunku == 0) {
                return 0;
            }
            else {
                throw new BladWykonania();
            }
        }
    }
}
