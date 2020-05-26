public class TestWarteschlange
{
    public Warteschlange w = new Warteschlange(1000);
    
    public TestWarteschlange(){
        for(int i = 0; i < 20; i++){
            w.anmelden(new Patient("patientNr"+i));
        }
        
        w.ausgeben();
        
        w.abmelden();
        
        w.ausgeben();
    }
}
