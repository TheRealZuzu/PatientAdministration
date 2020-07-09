public class TestWarteschlange
{
    public Warteschlange w = new Warteschlange(1000);
    
    public TestWarteschlange(){
        System.out.print('\u000C');
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
        
        System.out.println("Cancel Test: ");
        
        w.cancel(3);
        
        w.ausgeben();
        
        System.out.println("Sort Test: ");
        
        w.sort();
        
        w.ausgeben();
        
        System.out.println("Search Test: ");
        
        Patient[] r = w.searchByName("patientNr18");
        
        printPArr(r);
        
        System.out.println("Comparing Mei & Meier");
        
        System.out.println(w.similar("Mei","Meier"));
    }
    
    private void printPArr(Patient[] p){
        if(p == null){
            System.out.println("Array is empty");
            return;
        }
        for(int i = 0; i < p.length; i++){
            System.out.println(p[i]);
        }
    }
}
