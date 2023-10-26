
/**
 * 
 */
public class Teiler
{

    /**
     * Konstruktor für Objekte der Klasse Teiler
     */
    public Teiler()
    {

    }

    /**
     * 
     */
    public boolean istTeilerVon(int zahl, int teiler){
        if (zahl%teiler == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean sind2und3teiler(int zahl){
        if(istTeilerVon(zahl,2)){
            return true;
        }else if(istTeilerVon(zahl,3)){
            return true;
        }else{
            return false;
        }
    }
}
