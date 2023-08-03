class Solution {
    List<String> output;
    HashMap<Integer,char[]> map;
    int n;
    int[] arr;
    void helper(int ind,String s)
    {
        if(ind==n){
            output.add(s);return;
        }
        System.out.println(arr[ind]);
        int len=map.get(arr[ind]).length;
        for(int i=0;i<len;i++)
        {
            // System.out.println(map.get(arr[ind]));
            helper(ind+1,s+Character.toString(map.get(arr[ind])[i]));
        }
    }
    public List<String> letterCombinations(String digits) {
        n=digits.length();
        if(n==0)return new ArrayList();
        output=new ArrayList<>();
        map=new HashMap<>();
        map.put(2,"abc".toCharArray());
        map.put(3,"def".toCharArray());
        map.put(4,"ghi".toCharArray());
        map.put(5,"jkl".toCharArray());
        map.put(6,"mno".toCharArray());
        map.put(7,"pqrs".toCharArray());
        map.put(8,"tuv".toCharArray());
        map.put(9,"wxyz".toCharArray());
        // System.out.println(map.get(2).length);
        arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=digits.charAt(i)-'0';
            // System.out.println(arr[i]);
        }
        helper(0,"");
        // if(output)
        return output;
    }
}