package zadanie2;

public abstract class Wyrażenie {
    String typ;

    public Wyrażenie(String typ) {
        this.typ = typ;
    }

    public abstract double wykonaj() throws BladWykonania;
}
