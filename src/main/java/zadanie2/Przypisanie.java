package zadanie2;

import java.util.Map;

public class Przypisanie extends Wyrażenie {
    private String nazwa;
    private Wyrażenie wartosc;
    private Robson robson;

    // konstruktor
    public Przypisanie(String nazwa, Wyrażenie wartosc, Robson robson) {
        super("Przypisanie");
        this.nazwa = nazwa;
        this.wartosc = wartosc;
        this.robson = robson;
    }

    public double wykonaj() throws BladWykonania {
        Map<String, Double> zmienne = robson.zmienne();
        zmienne.put(nazwa, Double.valueOf(wartosc.wykonaj()));
        return zmienne.get(nazwa);
    }
}
