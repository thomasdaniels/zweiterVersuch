
/**
 * Beschreiben Sie hier die Klasse Wartezimmer2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Wartezimmer2
{
    private WarteschlangeGen<NeuerPatient> leute;
    private NeuerPatient p;


    public Wartezimmer2() {
        leute = new WarteschlangeGen<NeuerPatient>();
    }

    public void fuehreAus() {
        p = new NeuerPatient("Adam");
        leute.enqueue(p);
		
        p = new NeuerPatient("Berta");
        leute.enqueue(p);

        p = new NeuerPatient("Charly");
        leute.enqueue(p);

        p = new NeuerPatient("Detlef");
        leute.enqueue(p);
        
        //String s = "hallo";
        //leute.enqueue(s);

        //leute.alleAusgeben2(leute.front());
        System.out.println("----- nun wird der erste entfernt: dequeue");
        leute.dequeue();

        //leute.alleAusgeben2(leute.front());
        System.out.println("----- nun werden zwei angeh舅gt: enqueue");
        p = new NeuerPatient("Jakob");
        leute.enqueue(p);

        p = new NeuerPatient("Johannes");
        leute.enqueue(p);

        while (!leute.isEmpty()){
            p =  leute.front();
            System.out.println(p.getName());
            leute.dequeue();

        }

    }
}
