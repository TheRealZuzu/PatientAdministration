public class TestWarteschlange
{
    public Warteschlange w = new Warteschlange(1000);
    
    public TestWarteschlange(){
        System.out.println("New Test: ");
        for(int i = 0; i < 20; i++){
            Patient p = new Patient("patientNr"+i);
            p.privatversichert = Math.round(Math.random()) == 1;
            w.anmelden(p);
        }
        
        w.ausgeben();
        
        System.out.println("Abmelden Test: ");
        
        w.abmelden();
    
        w.ausgeben();
        
        System.out.println("Insert Test: ");
        
        w.insert(new Patient("Vordrängler"),3);
        
        w.ausgeben();
        
        System.out.println("Sort Test: ");
        
        w.sort();
        
        w.ausgeben();
    }
}
