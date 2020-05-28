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
    
    public void insert(Patient p, int k){
        if(k <= n){
            for(int i = k+1; i < n; i++){
                patienten[i-1] = patienten[i];
            }
            patienten[k] = p;
        }
    }
    
    public void sort(){//Privatpatienten nach vorne
        Patient[] priv = new Patient[N];
        int privL = 0;
        Patient[] pub = new Patient[N];
        int pubL = 0;
        
        for(int i = 0; i < n; i++){
            if(patienten[i].privatversichert){
                priv[privL] = patienten[i];
                privL++;
            }else{
               pub[pubL] = patienten[i];
               pubL++; 
            }
        }
        
        for(int i = 0; i < privL; i++){
            patienten[i] = priv[i];
        }
        
        for(int i = privL; i < privL+pubL; i++){
            patienten[i] = pub[i-privL];
        }
    }
    
    
    public void ausgeben(){
        for(int i = 0; i < n; i++){
            System.out.println(patienten[i]);
        }
    }
}
