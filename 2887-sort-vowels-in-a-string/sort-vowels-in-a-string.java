class Solution {
    public String sortVowels(String s) {
        // char arr[]=s.toCharArray();
        // Arrays.sort(arr);
        // StringBuilder sb=new StringBuilder();
        List<String> l=new ArrayList<>();
        String vowels="aeiouAEIOU";
        for(char c:s.toCharArray())
        {
            if(vowels.indexOf(c)!=-1)
                l.add(c+"");
        }
        Collections.sort(l);
        // sb.append(arr);
        // System.out.println(sb.toString()+" "+Arrays.toString(arr));
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            // if(vowels.indexOf(sb.charAt(i))==-1)
            // {
            //     sb.deleteCharAt(i);
            // }
            if(vowels.indexOf(c)==-1)
            {
                l.add(i,c+"");
            }
        }
        return String.join("",l);
    }
}