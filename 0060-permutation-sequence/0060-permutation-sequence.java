class Solution {
    int fact[];
    public String getPermutation(int n, int k) {
        fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++)
        {
            fact[i]=fact[i-1]*i;
            // System.out.print(fact[i]+" ");
        }
        // k=k%fact[n];
        int output[]=new int[n];
        boolean visited[]=new boolean[n+1];
        for(int i=0;i<n;i++)
        {
            int element=n+1;
            for(int ele=1;ele<n+1;ele++)
            {
                if(!visited[ele])
                {
                    // System.out.println(i+" "+k+" "+(fact[n-i-1]));
                    if((k-fact[n-i-1])>0)
                    {
                        k-=fact[n-i-1];
                        continue;
                    }
                    element=ele;
                    break;
                }
            }
            output[i]=element;
            visited[element]=true;
        }
        // for(int x:output)
        // System.out.println(x);
        StringBuilder s=new StringBuilder();
        for(int x:output)
        {
            s.append(x);
        }
        return s.toString();
    }
}