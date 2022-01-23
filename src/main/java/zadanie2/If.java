package zadanie2;

public class If extends Wyrażenie {
    private Wyrażenie warunek;
    private Wyrażenie blok_prawda;
    private Wyrażenie blok_fałsz;

    // konstruktory
    public If(Wyrażenie warunek, Wyrażenie blok_prawda, Wyrażenie blok_fałsz) {
        super("If");
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_fałsz = blok_fałsz;
    }

    public If(Wyrażenie warunek, Wyrażenie blok_prawda) {
        super("If");
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_fałsz = null;
    }

    public double wykonaj() throws BladWykonania {
        double wartoscWarunku = warunek.wykonaj();
        if (wartoscWarunku == 1) {
            return blok_prawda.wykonaj();
        }
        else if (wartoscWarunku == 0) {
            if (blok_fałsz == null) return 0;
            else return blok_fałsz.wykonaj();
        }
        else {
            throw new BladWykonania();
        }
    }
}
