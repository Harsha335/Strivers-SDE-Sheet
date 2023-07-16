class Solution {
    class Symbols{
        int ind,value;
        Symbols(int ind,int value)
        {
            this.ind=ind;
            this.value=value;
        }
    }
    public int romanToInt(String s) {
        HashMap<Character,Symbols> map=new HashMap<>();
        map.put('I',new Symbols(0,1));
        map.put('V',new Symbols(1,5));
        map.put('X',new Symbols(2,10));
        map.put('L',new Symbols(3,50));
        map.put('C',new Symbols(4,100));
        map.put('D',new Symbols(5,500));
        map.put('M',new Symbols(6,1000));
        int n=s.length();
        Symbols x=map.get(s.charAt(n-1));
        int output=x.value;
        int preInd=x.ind;
        for(int i=n-2;i>=0;i--)
        {
            x=map.get(s.charAt(i));
            if(x.ind>=preInd)
            {
                output+=x.value;
            }
            else{
                output-=x.value;
            }
            preInd=x.ind;
        }
        return output;
    }
}