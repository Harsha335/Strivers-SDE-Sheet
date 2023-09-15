class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] que) {
        int n=s.length();
        int[][] counter=new int[n+1][26];
        for(int i=1;i<=n;i++)
        {
            // if(i!=0)
            // {
                counter[i]=counter[i-1].clone();
            // }
            counter[i][s.charAt(i-1)-'a']++;
        }
        List<Boolean> output = new ArrayList<>();
        for(int[] x:que){
            int countOdd=0;
            // System.out.println(x[1]+" "+x[0]);
            for(int i=0;i<26;i++)
            {
                // System.out.println(counter[x[1]][i]+"-"+counter[x[0]][i]);
                countOdd+=(counter[x[1]+1][i]-counter[x[0]][i])%2;
            }
            output.add((countOdd/2)<=x[2]);
        }
        return output;
    }
    
}