class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int pre=points[0][0];
        int output=0;
        int n=points.length;
        for(int i=0;i<n;i++)
        {
            output=Math.max(output,points[i][0]-pre);
            pre=points[i][0];
        }
        return output;
    }
}