import java.util.Set;
import java.util.HashSet;

/**
 * Beschreiben Sie hier die Klasse SetStall.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SetStall implements Stall
{
    private HashSet<Schaf> _setSchafe;
    /**
     * Konstruktor für Objekte der Klasse SetStall
     */
    public SetStall()
    {
        _setSchafe = new HashSet<Schaf>(); 
    }

    public void setzeSchaf(Schaf schaf){
        
    }
    
    public void schafStallFuettern(){}
}
