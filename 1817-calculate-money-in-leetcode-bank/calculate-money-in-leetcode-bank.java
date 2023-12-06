class Solution {
    public int totalMoney(int n) {
        //sum of 1 to 7 -> 28
        int sevens=n/7;
        int lastWeek=n%7;
        int lastDay=lastWeek+sevens;
        return (sevens*28)+(sevens*(sevens-1)/2)*7+((lastDay*(lastDay+1)/2)-(sevens*(sevens+1)/2));
    }
}