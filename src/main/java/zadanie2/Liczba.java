package zadanie2;

public class Liczba extends Wyrażenie {
    private double wartosc;

    // konstruktor
    public Liczba(double wartosc) {
        super("Liczba");
        this.wartosc = wartosc;
    }

    // funkcje pomocnicze
    public double wykonaj() {
        return wartosc;
    }
}
