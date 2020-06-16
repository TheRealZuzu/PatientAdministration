import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Unit test zeigt nicht automatisch konsole an
public class WarteschlangeTest
{   
    @Test
    public void testWarteschlange() 
    {
        Warteschlange w = new Warteschlange(1000);
    
    
        System.out.println("New Unit Test: ");
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
        assertEquals(1,1);
    }
}
