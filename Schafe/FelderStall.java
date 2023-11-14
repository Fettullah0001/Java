
/**
 * 
 * @author Fettullah
 */
public class FelderStall implements Stall
{
    private Schaf _quartier1;
    private Schaf _quartier2;
    private Schaf _quartier3;

    private Kuh _kuh1;
    private Kuh _kuh2;
    private Kuh _kuh3;
    private Kuh _kuh4;

    public FelderStall()
    {

    }

    /**
     * besetzt das nächste freie Schafs Feld. Ist kein Feld mehr frei, wird der Methodenaufruf ignoriert
     */
    public void setzeSchaf(Schaf schaf){
        if(_quartier1 == null){
            _quartier1 = schaf;
        }else if(_quartier2 == null){
            _quartier2 = schaf;
        }else if(_quartier3 == null){
            _quartier3 = schaf;
        }
    }

    /**
     * Mit fuettereSchafe (int menge) füttert man alle schon belegten Schafe
     */
    public void fuettereSchafe(int menge){
        if(_quartier1 != null){
            _quartier1.fuettern(menge);
        }if(_quartier2 != null){
            _quartier2.fuettern(menge);
        }if(_quartier3 != null){
            _quartier3.fuettern(menge);
        }
    }
    
    /**
     * Das volle Schaf Stall wird gefuetert. durch aufruf der Methode fuettereSchafe mit eine menge 10.
     */
    public void schafStallFuettern(){
        fuettereSchafe(10);
    }

    /**
     * Die Methode gibSchwaechstesSchaf () gibt das schwächste der drei Schafe zurück. 
     * Gibt es kein belegtes Schafs Feld wird null zurückgegeben. 
     * (In diesem Fall ist das das Schaf, das am wenigsten Energie hat)
     */
    public Schaf gibSchwaechstesSchaf(){
        if(_quartier1  != null&& _quartier2 != null && _quartier3 != null){
            return gibSchwaecheresSchaf(gibSchwaecheresSchaf(_quartier1,_quartier2),_quartier3);
        }else if(_quartier1  != null&& _quartier2 != null && _quartier3 == null){
            return gibSchwaecheresSchaf(_quartier1,_quartier2);
        }else if(_quartier1  != null&& _quartier2 == null && _quartier3 != null){
            return gibSchwaecheresSchaf(_quartier1,_quartier3);
        }else if(_quartier1  == null&& _quartier2 != null && _quartier3 != null){
            return gibSchwaecheresSchaf(_quartier3,_quartier2);
        }else{return null;}
    }

    private Schaf gibSchwaecheresSchaf(Schaf schaf1, Schaf schaf2){
        if(schaf1.getEnergie() < schaf2.getEnergie()){
            return schaf1;
        }else{return schaf2;}
    }

    /**
     * Die Methode entferneSchaf () entfernt die Belegung des zuerst belegten Schafs Feld
     */
    public void entferneSchaf(){
        if(_quartier1 !=null){
            _quartier1 = null;
        }else if(_quartier2 !=null){
            _quartier2 = null;
        }else if(_quartier3 !=null){
            _quartier3 = null;
        }
    }

    /**
     * Die Methode gibStaerkstesSchaf () gibt das stärkste der drei Schafe zurück.
     * Gibt es kein belegtes Schafs Feld wird null zurückgegeben
     */
    public Schaf gibStaerkstesSchaf(){
        if(_quartier1  != null&& _quartier2 != null && _quartier3 != null){
            return gibStaerkeresSchaf(gibStaerkeresSchaf(_quartier1,_quartier2),_quartier3);
        }else if(_quartier1  != null&& _quartier2 != null && _quartier3 == null){
            return gibStaerkeresSchaf(_quartier1,_quartier2);
        }else if(_quartier1  != null&& _quartier2 == null && _quartier3 != null){
            return gibStaerkeresSchaf(_quartier1,_quartier3);
        }else if(_quartier1  == null&& _quartier2 != null && _quartier3 != null){
            return gibStaerkeresSchaf(_quartier3,_quartier2);
        }else{return null;}
    }

    private Schaf gibStaerkeresSchaf(Schaf schaf1, Schaf schaf2){
        if(schaf1.getEnergie() < schaf2.getEnergie()){
            return schaf1;
        }else{return schaf2;}
    }
    
    /**
     * Wenn Vier Kuehe im Stall sind. Schalfen Sie und gehen aus dem Stall.
     */
    public void setzeKuh(Kuh kuh){
        if(_kuh1 == null){
            _kuh1 = kuh;
        }else if(_kuh2 == null){
            _kuh2 = kuh;
        }else if(_kuh3 == null){
            _kuh3 = kuh;
        }else if(_kuh4 == null){
            _kuh4 = kuh;
        }
        if(_kuh4 != null){
            _kuh1.schlafen();
            _kuh2.schlafen();
            _kuh3.schlafen();
            _kuh4.schlafen();
            entferneAlleKuehe();
        }
    }
    
    /**
     * entfernt alle Kuehe aus dem Stall.
     */
    private void entferneAlleKuehe(){
        _kuh1 = null;
        _kuh2 = null;
        _kuh3 = null;
        _kuh4 = null;
    }
}
