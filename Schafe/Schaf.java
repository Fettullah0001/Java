
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
    public void fuettern(int menge){
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

    /**
     * Get Energie Methode
     */
    public int getEnergie(){return _energie;}

    /**
     * Schreibt eine Methode, wo das Schaf voll (Energie = 100) gefüttert wird
     */
    public void fuetternVoll(){this.fuettern(100);}

    /**
     * Schaf zählt Tage. Für einen Monat im Jahr. Benutzt werden soll eine Switch-Anweisung.
     */
    public int tageProMonat(int monat, int jahr){
        switch(monat){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            default:
                if(jahr%4==0){
                    return 29;
                }else{
                    return 28;
                }
        }
    }

    /**
     * Gibt an, ob die Zeichenkette einen Vokal enthaelt.
     */
    public boolean enthaeltVokal(String s){
        String low = s.toLowerCase();
        if(low.indexOf('a')>=0){
            return true;
        }else if(low.indexOf('e')>=0){
            return true;
        }else if(low.indexOf('i')>=0){
            return true;
        }else if(low.indexOf('o')>=0){
            return true;
        }else if(low.indexOf('u')>=0){
            return true;
        }else{
            return false;        
        }   
    }

    /**
     * Diese Methode liefert true, wenn der übergebene String ein Palindrom ist,sonst false.
     * @param s ein beliebiger String, darf nicht null sein
     */
    public boolean istPalindrom(String s){
        boolean palindrom = false;
        String lowCase = s.toLowerCase();
        int versuche = s.length()/2;
        int anfang = 0;
        int ende = s.length()-1;
        while(true){
            if(versuche == 0){break;}
            if(lowCase.charAt(anfang) == lowCase.charAt(ende)){
                palindrom = true;
            }else{return false;}
            anfang++;
            ende--;
            versuche--;
        }
        return palindrom;
    }

    /**
     * Liefert fuer einen uebergebenen String die Anzahl der Auftreten des ebenfalls uebergebenen Zeichens innerhalb des Strings.
     * @param vonChar das Zeichen, dessen Auftreten gezaehlt werden soll 
     * @param inString der String, in dem gezaehlt werden soll
     */
    public int anzahlAuftreten(char vonChar, String inString){
        int anzahl = 0;
        if(inString.indexOf(vonChar) >= 0){
            for(int i = 0; i < inString.length(); i++){
                if(inString.charAt(i)==vonChar){
                    anzahl++;
                }
            }
        }
        return anzahl;
    }

    /**
     * Liefert nur die Vokale der uebergebenen Zeichenkette. Fuer den Parameter "HAllo Welt!" liefert diese Methode beispielweise den String "Aoe".
     * @param eine beliebige Zeichenkette; darf nicht null sein und keine Umlaute enthalten.
     */
    public String nurVokale(String wort){
        String ausgabe = "";
        for(int i = 0; i < wort.length(); i++){
            if(wort.charAt(i) == 'a' || wort.charAt(i) == 'A'){ausgabe += wort.charAt(i);
            }else if(wort.charAt(i) == 'e' || wort.charAt(i) == 'E'){ausgabe += wort.charAt(i);
            }else if(wort.charAt(i) == 'i' || wort.charAt(i) == 'I'){ausgabe += wort.charAt(i);
            }else if(wort.charAt(i) == 'o' || wort.charAt(i) == 'O'){ausgabe += wort.charAt(i);
            }else if(wort.charAt(i) == 'u' || wort.charAt(i) == 'U'){ausgabe += wort.charAt(i);
            }
        }
        return ausgabe;
    }

    /**
     * Liefert eine neue Zeichenkette aus der alle Vokale entfernt wurden. Fuer den Parameter "Hallo Welt!" liefert diese Methode beispielweise den String "Hll Wlt!". 
     * @param eine beliebige Zeichenkette; darf nicht null sein und keine Umlaute enthalten.
     */
    public String entferneVokale(String s){
        String ausgabe = "";
        for(int i = 0 ; i < s.length();i++){
            if(istVokal(s,i)){ //Tue nichts
            }else{ausgabe += s.charAt(i);}
        }
        return ausgabe;
    }

    /**
     * gibt zurück ob an stelle i des String s ein Vokal ist.
     */
    private boolean istVokal(String s, int i){
        if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O'|| s.charAt(i) == 'u' || s.charAt(i) == 'U'){
            return true;
        }else{return false;}
    }

    /**
     * Gibt an, ob in einer Zeichenkette mindestens ein Zeichen, direkt aufeinander folgend, doppelt vorkommt. 
     * @param eine beliebige Zeichenkette, darf nicht null sein.
     */
    public boolean enthaeltDoppelzeichen(String s){
        boolean gefunden = false;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                gefunden = true;
            }
        }
        return gefunden;
        }
    }
