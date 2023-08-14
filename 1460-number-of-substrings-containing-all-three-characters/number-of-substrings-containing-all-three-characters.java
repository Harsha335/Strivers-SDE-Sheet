class Solution {
    public int numberOfSubstrings(String s) {
        int arr[]=new int[3];
        int j=0;
        int output=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']+=1;
            if(arr[0]>0 && arr[1]>0 && arr[2]>0)
            {
                while(j<=(i-3))
                {
                    if(arr[s.charAt(j)-'a']==1) break;
                    arr[s.charAt(j)-'a']-=1;
                    j++;
                }
                output+=j+1;
            }
        }
        return output;
    }
}