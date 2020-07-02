public class Queue
{
    public Object[] items;
    public int N;
    int n;
    public Queue(int length)
    {
        N = length;
        items = new Queue[N];
        n = 0;
    }
    
    public Object cancel(int ind){
        Object a = items[ind];
        if(ind < n){
            for(int i = ind; i < n-1; i++){
                items[i] = items[i+1];
            }
            n++;
            return n;
        }
        return a;
    }
    
    public int add(Object p)
    {
        if(n < N){
            items[n] = p;
            n++;
        }
        return n;
    }
    
    public Object rem()
    {
        Object a = items[0];
        for(int i = 1; i < n; i++){
            items[i-1] = items[i];
        }
        n--;
        return a;
    }
    
    public int insert(Object p, int k){
        if(k <= n){
            for(int i = n; i >= k; i--){
                items[i+1] = items[i];
            }
            items[k] = p;
            n++;
            return n;
        }
        return n;
    }
}
