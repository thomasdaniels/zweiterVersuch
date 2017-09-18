
/**
 * Beschreiben Sie hier die Klasse WarteschlangeGen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class WarteschlangeGen<MeinDatenTyp>
{

    private class Knoten
    {
        private MeinDatenTyp o=null;
        private Knoten nachfolger=null;

        public Knoten (MeinDatenTyp meinDatenTyp){
            o = meinDatenTyp;
            nachfolger=null;
        }

        public void lerneNachfolgerKennen(Knoten n) {
            nachfolger = n; // hier wird nur die Adresse des Objektes n ergeben!
        }

        public Knoten getNachfolger() {
            return nachfolger;
        }

        public MeinDatenTyp getMeinDatenTyp(){
            return o;
        }
    }

    private Knoten anfang;
    private Knoten k;
    private Knoten ende;

    public WarteschlangeGen() {
        anfang = null; // das bedeutet, dass die Warteschlange leer ist
        ende = null;
    }

    public boolean isEmpty() {
        return (anfang == null);
    }

    public void enqueue(MeinDatenTyp o) {
        //MeinDatenTyp besser hier erzeugen als jedes Mal einzeln im Wartezimmer
        k = new Knoten(o);
        // einen MeinDatenTyp am Ende der Warteschlange hinzufgen
        if (this.isEmpty()) {
            anfang = k;
            ende = k;
            //anfang.lerneNachfolgerKennen(ende);
            //ende.lerneNachfolgerKennen(null);
        } else {
            ende.lerneNachfolgerKennen(k); // das alte ende lernt seinen
            // Nachfolger k kennen
            ende = k; // k ist nun das neue Ende der Schlange
        }

    }

    public void dequeue() {
        // entfernt den ersten Patienten aus der Schlange
        if (!this.isEmpty()) {
            anfang = anfang.getNachfolger();
            
            if (this.isEmpty()){
                anfang = null;
                ende = null;
            }
            
        }
    }

    public MeinDatenTyp front() {
        return anfang.getMeinDatenTyp();
    }
}
