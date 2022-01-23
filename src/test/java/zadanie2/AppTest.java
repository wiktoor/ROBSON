package zadanie2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

// Aby uruchomić test, należy wywołać polecenie 'mvn clean test'
// z folderu zadanie2
public class AppTest 
{
    @Test
    public void silniaTest() {
        try {
            Robson r = new Robson();
            r.fromJSON("./silnia.json");
            assertTrue( r.wykonaj() == 40320.0);
        }
        catch (NieprawidlowyProgram e1) {
            System.out.println("Nieprawidłowy program");
        }
        catch (BladWykonania e2) {
            System.out.println("Blad wykonania");
        }
    }
    @Test
    public void fibonacciTest() {
        try {
            Robson r = new Robson();
            r.fromJSON("./fibonacci.json");
            assertTrue( r.wykonaj() == 55.0 );
        }
        catch (NieprawidlowyProgram e1) {
            System.out.println("Nieprawidłowy program");
        }
        catch (BladWykonania e2) {
            System.out.println("Blad wykonania");
        }
    }
}
