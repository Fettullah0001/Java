
/**
 * @author (Fettullah) 
 */
public class Schaf
{
    private final String _name;
    private int _alter;
    private int _hunger;
    private int _energie;
    private boolean _lebendig = true;
    private int _gegessen;
    private int _geschlagen;
    private int _futtermenge;

    public Schaf(String name)
    {
        _name = name;
        _alter = 0;
    }

    public int getalter(){return _alter;}

    public int getenergie(){return _energie;}

    public boolean getlebendig(){return _lebendig;}

    /** 
     * Methode altern: Das Schaf wird ein Jahr älter und verliert 10 hunger 
     */
    public void altern()
    {
        if(_alter < 20 && _alter >= 0){
            if(_alter < 10){
                _energie -= 10;
            }else{
                _energie -= 20;
            }
            _alter++;
        }else{
            _lebendig = false;
            System.out.println("Schaf lebt nicht");
        }
    }

    /**
     * Methode fuettern: Erhöht die Energie des Schafs.
     */
    public void fuetter(int menge){
        if(menge > 0){
            if(_lebendig==true){
                _energie += menge;
                _gegessen++;
                _futtermenge += menge;
            }else{
                System.out.println("Schaf ist Tod");
            }
        }
    }

    /**
     * Man kann das Schaf schlagen… (unterschiedlich kräftig)
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

    /**
     * Fragen ob das Schaf glücklich ist. Öfter gegessen als geschlagen
     */
    public boolean getgluecklich(){
        if(_gegessen > _geschlagen){
            System.out.println("Das Schaf ist Glücklich");
            return true;
        }else if (_gegessen < _geschlagen){
            System.out.println("Das Schaf ist Unglücklich");
            return false;
        }else{
            System.out.println("Neutral");
            return true;
        }
    }

    /**
     * Schaf kann Hunrig werden. Wenn Energie < 50.
     */
    public boolean gethungrig(){
        if(_energie < 50){
            System.out.println("Das Schaf ist Hungrig");
            return true;
        }else {return false;}
    }

    /**
     * Schaf kann sprechen
     * Wenn hungrig und glücklich „Ich bin glücklich, aber was zu fressen wäre schön“
     * Wenn hungrig und unglücklich –„Du musst dir besser überlegen ob du ein Schaf besitzen sollst. Bääääähhhhhh“
     * Wenn nicht hungrig und glücklich „Danke dir! Du bist der Beste!“
     * Ansonsten „Bääääähhhhhh“
     */
    public void sprechen(){
        if(gethungrig() && getgluecklich()){
            System.out.println("Ich bin glücklich, aber was zu fressen wäre schön");
        }else if(gethungrig() && !getgluecklich()){
            System.out.println("Du musst dir besser überlegen ob du ein Schaf besitzen sollst. Bääääähhhhhh");
        }else if(!gethungrig() && getgluecklich()){
            System.out.println("Danke dir! Du bist der Beste!");
        }else {
            System.out.println("Bääääähhhhhh");
        }
    }
    
    /**
     * Schaf kann ausschlafen, dafür schreiben wir die Methode boolean ausschlafen(boolean werktag,boolean urlaub)
     * Es schläft aus, wenn es kein Werktag ist oder es ist im Urlaub.
     */
    public boolean ausschalfen(boolean werktag, boolean urlaub){
        if(!werktag || urlaub){
            return true;
        }else {return false;}
    }
    
    /**
     * Schaf kann addieren, returns die Summe von a und b,
     * aber wenn a und b gleich sind wird die Summe von beiden verdoppelt und returns.
     */
    public int schafAddiert(int a, int b){
        if(a == b){return (a+b)*2;
        }else{return (a+b);}
    }
    
    /**
     * Schaf kann Differenz zur 21 berechnen.
     * Wenn n größer 21 ist wird Differenz verdoppelt.
     */
    public int diff21(int n){
        int tmp = 21-n;
        if(n > 21){
            return tmp*2;
        }else{return tmp;}
    }
    
    /**
     * Schaf methode returns true wenn parameter a oder b oder die Summe von den Zahlen 10 ergibt.
     */
    public boolean makes10(int a, int b){
        if(a == 10 || b == 10 || (a+b)==10){
            return true;
        }else {return false;}
    }
    
    /**
     * Berechne die durchschnittliche Futtermenge
     */
    private void durchschnittFuttermenge(){
        int durchschnittFuttermenge = _futtermenge/_gegessen;
    }
}
