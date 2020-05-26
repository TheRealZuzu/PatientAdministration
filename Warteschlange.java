public class Warteschlange
{
    public Patient[] patienten;
    public int N;
    int n;
    public Warteschlange(int length)
    {
        N = length;
        patienten = new Patient[N];
        n = 0;
    }
    
    public int anmelden(Patient p)
    {
        if(n < N){
            patienten[n] = p;
            n++;
        }
        return n;
    }
    
    public void abmelden()
    {
        for(int i = 1; i < n; i++){
            patienten[i-1] = patienten[i];
        }
        n--;
    }
    
    
    public void ausgeben(){
        for(int i = 0; i < n; i++){
            System.out.println(patienten[i].name);
        }
    }
}
