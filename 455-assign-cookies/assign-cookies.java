class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1 = g.length;
        int n2 = s.length;
        int j = 0;
        int count = 0;
        for(int i = 0; i<n1 && j<n2; i++)
        {
            while(j<n2)
            {
                if(g[i] <= s[j])
                {
                    count += 1;
                    break;
                }
                j++;
            }
            // if(j == n2)
            //     return i;
            j++;
        }
        return count;
    }
}