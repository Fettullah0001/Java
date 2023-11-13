
/**
 * Beschreiben Sie hier die Klasse Kuh.
 */
public class Kuh implements Tier
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int _alter;
    private int _energie;
    private boolean _lebendig = true;
    private int _geschlagen = 0;

    /**
     * Konstruktor
     */
    public Kuh(){
    }
    
    /**
     * wird fuettern aufgerufen bekommt die Kuh menge*Kalorie Energie
     */
    public void fuettern (Essen essen){
        _energie = essen.getMenge() * essen.getKalorien();
    }
    
    /**
     * fuettern mit einer menge int mal Kalorien 4 zu Energie
     */
    public void fuettern(int menge){
        _energie += menge * 4;
    }
    
    /**
     * gibt auf der Konsole Muhh aus
     */
    public void machMuh(){
        System.out.println("Muhh");
    }
    
    /**
     * Schlafen regeneriert der Kuh 5 Energie;
     */
    public void schlafen(){
        _energie +=5;
    }
    
    /**
     * Man kann das Kuh schlagen… (unterschiedlich kräftig)
     */
    public void schlagen(int kraft){
        if(_lebendig == true){
            if(kraft >0){
                _energie -= kraft;
                _geschlagen++;
                if (_energie <= 0){
                    _lebendig = false;
                }
            }
        }else{
            System.out.println("Schaf ist tot");
        }
    }
}
