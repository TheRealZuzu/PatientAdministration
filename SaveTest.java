public class SaveTest
{
    public  Warteschlange w = new Warteschlange(20);
    
    public SaveTest(){
        System.out.println("File Save Test: ");
        
        for(int i = 0; i < 20; i++){
            Patient p = new Patient("patientNr"+i);
            p.privatversichert = Math.round(Math.random()) == 1;
            w.anmelden(p);
        }
        
        String saveString = w.toString();
        
        System.out.println(saveString);
        
        String[] ps = w.fromString(saveString);
        
        for(int i = 0; i < ps.length; i++){
            System.out.println(ps[i]);
        }
    }
}
