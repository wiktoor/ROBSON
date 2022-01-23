package zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;

public class Robson 
{
    private Wyrażenie program;
    private Map<String, Double> zmienne;

    // UWAGA: test znajduje się w folderze test
    
    // gettery
    public Map<String, Double> zmienne() { return zmienne; }

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        Path path = Paths.get(filename);
        try {
            String json = Files.readString(path);
            Object obj = (new Gson()).fromJson(json, Object.class);

            zmienne = new HashMap<String, Double>();
            LinkedTreeMap<?,?> map = (LinkedTreeMap<?,?>) obj;
            program = Parsuj(map);
        }
        catch (IOException e) {
            throw new NieprawidlowyProgram();
        }
    }

    public double wykonaj() throws BladWykonania {
        if (program == null) throw new BladWykonania();
        else return program.wykonaj();
    }

    private Wyrażenie Parsuj(LinkedTreeMap<?,?> map) throws NieprawidlowyProgram {
        if (map == null) throw new NieprawidlowyProgram();
        String typ = (String) map.get("typ");
        if (typ == null) throw new NieprawidlowyProgram();
        switch (typ) {
            case ("Blok"):
                ArrayList<?> list = (ArrayList<?>) map.get("instrukcje");
                ArrayList<Wyrażenie> instrukcje = new ArrayList<Wyrażenie>();
                for (int i = 0; i < list.size(); i++) {
                    instrukcje.add(Parsuj((LinkedTreeMap<?,?>) list.get(i)));
                }
                return new Blok(instrukcje);
            case ("If"):
                Wyrażenie ifwarunek = Parsuj((LinkedTreeMap<?,?>) map.get("warunek"));
                Wyrażenie blok_prawda = Parsuj((LinkedTreeMap<?,?>) map.get("blok_prawda"));
                LinkedTreeMap<?,?> fałsz = (LinkedTreeMap<?,?>) map.get("blok_falsz");
                if (fałsz == null) {
                    return new If(ifwarunek, blok_prawda);
                }
                else {
                    Wyrażenie blok_fałsz = Parsuj((LinkedTreeMap<?,?>) map.get("blok_falsz"));
                    return new If(ifwarunek, blok_prawda, blok_fałsz);
                }
            case ("While"):
                Wyrażenie whilewarunek = Parsuj((LinkedTreeMap<?,?>) map.get("warunek"));
                Wyrażenie blok = Parsuj((LinkedTreeMap<?,?>) map.get("blok"));
                return new While(whilewarunek, blok);
            case ("Przypisanie"):
                String przypisanienazwa = (String) map.get("nazwa");
                Wyrażenie wartosc = Parsuj((LinkedTreeMap<?,?>) map.get("wartosc"));
                return new Przypisanie(przypisanienazwa, wartosc, this);
            case ("Plus"):
                Wyrażenie plusargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie plusargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Plus(plusargument1, plusargument2);
            case ("Minus"):
                Wyrażenie minusargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie minusargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Minus(minusargument1, minusargument2);
            case ("Razy"):
                Wyrażenie razyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie razyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Razy(razyargument1, razyargument2);
            case ("Dzielenie"):
                Wyrażenie dzielenieargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie dzielenieargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Dzielenie(dzielenieargument1, dzielenieargument2);
            case ("And"):
                Wyrażenie andargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie andargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new And(andargument1, andargument2);
            case ("Or"):
                Wyrażenie orargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie orargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Or(orargument1, orargument2);
            case ("<"):
                Wyrażenie mniejszyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie mniejszyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Mniejszy(mniejszyargument1, mniejszyargument2);
            case (">"):
                Wyrażenie większyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie większyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Większy(większyargument1, większyargument2);
            case ("<="):
                Wyrażenie mniejszyrównyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie mniejszyrównyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new MniejszyRówny(mniejszyrównyargument1, mniejszyrównyargument2);
            case (">="):
                Wyrażenie większyrównyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie większyrównyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new WiększyRówny(większyrównyargument1, większyrównyargument2);
            case ("=="):
                Wyrażenie równyargument1 = Parsuj((LinkedTreeMap<?,?>) map.get("argument1"));
                Wyrażenie równyargument2 = Parsuj((LinkedTreeMap<?,?>) map.get("argument2"));
                return new Równy(równyargument1, równyargument2);
            case ("Not"):
                Wyrażenie notargument = Parsuj((LinkedTreeMap<?,?>) map.get("argument"));
                return new Not(notargument);
            case ("Liczba"):
                return new Liczba((double) map.get("wartosc"));
            case ("True"):
                return new True();
            case ("False"):
                return new False();
            case ("Zmienna"):
                return new Zmienna((String) map.get("nazwa"), this);
            default:
                throw new NieprawidlowyProgram();
        }
    }
}

