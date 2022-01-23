package zadanie2;

import java.util.ArrayList;
import java.util.List;

public class Blok extends Wyrażenie {
    private List<Wyrażenie> instrukcje;

    // konstruktory
    public Blok() { 
        super("Blok");
        instrukcje = new ArrayList<Wyrażenie>(); 
    }

    public Blok(List<Wyrażenie> instrukcje) {
        super("Blok");
        this.instrukcje = instrukcje;
    }

    // funkcje pomocnicze
    public double wykonaj() throws BladWykonania {
        if (instrukcje.isEmpty()) return 0;
        else {
            double w = 0;
            for (int i = 0; i < instrukcje.size(); i++) {
                w = instrukcje.get(i).wykonaj();
            }
            return w;
        }
    }
}
