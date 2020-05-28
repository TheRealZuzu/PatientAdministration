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
    
    
    public String[] fromString(String s){
        int patientCount = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
               patientCount++; 
            }
        }
        
        String[] p = new String[patientCount];
        int k = 0;
        p[0]  = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '|'){
                p[k] += s.charAt(i);
            }else{
                if(i != s.length()-1){
                    k++;
                    p[k] = "";
                }
            }
        }
        
        return p;
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
    
    public int insert(Patient p, int k){
        if(k <= n){
            for(int i = k+1; i < n; i++){
                patienten[i-1] = patienten[i];
            }
            patienten[k] = p;
            n++;
            return n;
        }
        return n;
    }
    
    public void sort(){//Privatpatienten nach vorne wie es sich gehoert
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
    
    
    public String toString(){
      String s = "";
      
      for(int i = 0; i < n; i++){
           s += patienten[i];
           s += "|";
      }
      return s;
    }
}
