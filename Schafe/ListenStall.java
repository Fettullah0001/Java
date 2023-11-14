import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse ListenStall.
 */
public class ListenStall implements Stall
{
    private ArrayList<Schaf> _schafStall;

    /**
     * Konstruktor für Objekte der Klasse ListenStall
     */
    public ListenStall()
    {
        _schafStall = new ArrayList<Schaf>(3);
    }

    public void setzeSchaf(Schaf schaf){
        if(_schafStall.get(0) == null){_schafStall.add(0,schaf);
        }else if(_schafStall.get(1) == null){_schafStall.add(1,schaf);
        }else if(_schafStall.get(2) == null){_schafStall.add(2,schaf);
        }else{System.out.println("Stall ist voll");}
    }
    
    /**
     * Schafe im Stall werden in einer Erweiterten for-Schleife mit der Menge 10 durch aufruf
     * der fuettern methode von Schaf gefuettert.
     */
    public void schafStallFuettern(){
        for(Schaf f: _schafStall){
            f.fuettern(10);
        }
    }
}
