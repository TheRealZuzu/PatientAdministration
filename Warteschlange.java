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
    
    public int cancel(int ind){
        if(ind < n){
            for(int i = ind; i < n-1; i++){
                patienten[i] = patienten[i+1];
            }
            n++;
            return n;
        }
        return n;
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
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) != '|'){
                p[k] += s.charAt(i);
            }else{
                 System.out.println(p[k]);
                 System.out.println(k+" "+" "+p.length);
                 k++;
                 p[k] = "";
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
            for(int i = n; i >= k; i--){
                patienten[i+1] = patienten[i];
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
    
    
    public Patient[] searchByName(String searched){
        Patient[] resR = new Patient[n];
        int c = 0;
        for(int i = 0; i < n; i++){
            if(patienten[i].name.equals(searched)){
                resR[c] = patienten[i];
                c++;
            }
        }
        
        if(c == 0){
            return null;
        }
        
        Patient[] res = new Patient[c];
        
        for(int i = 0; i < c; i++){
            res[i] = resR[i];
        }
        
        return res;
    }
    
    public float similar(String toCompare, String term){
        float res = 0;
        int count = 0;
        for(int i = 0; i < toCompare.length(); i++){
            if(toCompare.charAt(i) == term.charAt(0)){
               count = 1;
               System.out.println("found for "+term.charAt(0)+" and "+toCompare.charAt(i));
               for(int j = 1; j < term.length(); j++){
                   if(toCompare.charAt(i+j)==term.charAt(j)){
                       System.out.println("found for "+term.charAt(j)+" and "+toCompare.charAt(i+j));
                       count++;
                   }else{
                       i += j-1;
                       break;
                   }
               }
               res += ((float)(count))/((float)(toCompare.length()));
               count = 0;
            }
        }
        return res;
    }
}
