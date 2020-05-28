
/**
 * The class that keeps on giving me problems
 * 
 * @author Adrian 
 * @version 0.01
 */
public class Patient
{
    public String name;
    public String bday;
    public boolean privatversichert;
    public boolean maennlich;
    
    
    public Patient(String name)
    {
        this.name = name;
    }
    
    public Patient(String nameIn, String bdayIn,boolean privatversichertIn,boolean maennlichIn){
        name = nameIn;
        bday = bdayIn;
        privatversichert = privatversichertIn;
        maennlich = maennlichIn;
    }
    
    public String toString(){
        return name;
    }
}
