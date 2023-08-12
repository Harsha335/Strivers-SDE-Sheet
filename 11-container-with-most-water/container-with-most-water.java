class Solution {
    public int maxArea(int[] height) {
        //wrong
        // int n=height.length;
        // int pre[]=new int[n];
        // int post[]=new int[n];
        // pre[0]=0;   //index
        // for(int i=1;i<n;i++)
        // {
        //     pre[i]=Math.max(height[i],height[pre[i-1]]);
        // }
        // post[n-1]=n-1;
        // for(int i=n-2;i>=0;i--)
        // {
        //     post[i]=Math.max(height[i],height[post[i+1]]);
        // }
        // for(int i=0;i<n;i++)
        // {
        //     System.out.println(pre[i]+" "+post[i]);
        // }
        // int output=0;
        // for(int i=0;i<n;i++)
        // {
        //     output=Math.max(output,height[i]*(i-pre[i]));
        //     output=Math.max(output,height[i]*(post[i]-i));
        // }
        // return output;

        //two pointers
        int left=0;
        int right=height.length-1;
        int maxi=0;
        while(left<right)
        {
            int dist=right-left;
            int hei=Math.min(height[left],height[right]);
            maxi=Math.max(maxi,hei*dist);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxi;
    }
}