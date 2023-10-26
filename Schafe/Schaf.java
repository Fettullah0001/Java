
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
            _alter++;
            _hunger -=10;
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
    public void getgluecklich(){
        if(_gegessen > _geschlagen){
            System.out.println("Das Schaf ist Glücklich");
        }else if (_gegessen < _geschlagen){
            System.out.println("Das Schaf ist Unglücklich");
        }else{
            System.out.println("Neutral");
        }
    }

    /**
     * Schaf kann Hunrig werden. Wenn Energie < 50.
     */
    public void gethungrig(){
        if(_energie < 50){
            System.out.println("Das Schaf ist Hungrig");
        }
    }
}
