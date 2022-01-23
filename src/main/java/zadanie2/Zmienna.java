package zadanie2;

import java.util.Map;

public class Zmienna extends Wyrażenie {
    private String nazwa;
    private Robson robson;

    // konstruktor
    public Zmienna(String nazwa, Robson robson) {
        super("Zmienna");
        this.nazwa = nazwa;
        this.robson = robson;
    }

    public double wykonaj() throws BladWykonania {
        Map<String, Double> zmienne = robson.zmienne();
        if (!zmienne.containsKey(nazwa)) {
            zmienne.put(nazwa, null);
            return 0;
        }
        else {
            return zmienne.get(nazwa).doubleValue();
        }
    }
}
