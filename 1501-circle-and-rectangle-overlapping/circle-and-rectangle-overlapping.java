class Solution {
    int nearstX(int a,int b,int c)
    {
        if(a < b){
            return b;
        }
        else if(a > c){
            return c;
        }
        return a;//inner
    }
    int nearstY(int a,int b,int c)
    {
        if(a < b){
            return b;
        }
        else if(a > c){
            return c;
        }
        return a;//inner
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // sqrt((x2-x1)^2 + (y2-y1)^2) --> distance b/n 2 points
        // (x - x1)^2 + (y - y1)^2 = r^2 --> circle
        int x = nearstX(xCenter, x1, x2);
        int y = nearstY(yCenter, y1, y2);
        return Math.pow((xCenter - x),2) + Math.pow((yCenter - y),2) <= (double)radius*radius;
    }
}