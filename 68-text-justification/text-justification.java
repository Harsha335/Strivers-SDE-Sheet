class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;
        int n=words.length;
        List<String> output=new ArrayList<>();
        while(i<n)
        {
            int j=i;
            int count=0;
            // int endCount=0;
            int wordCount=0;
            while(j<n && count+words[j].length()<=maxWidth)
            {
                wordCount++;
                // endCount=count;
                count+=words[j].length()+1;
                // System.out.println(count);
                j++;
            }
            count-=1;
            // System.out.println(i+" "+j+" "+count+" "+wordCount);
            int space=0;
            int remSpace=0;
            if(wordCount!=1)
            {
                space=(maxWidth-count)/(wordCount-1)+1;
                remSpace=(maxWidth-count)%(wordCount-1);
            }
            else{
                space=(maxWidth-count);
            }
            // System.out.println(space+" "+remSpace+" "+i+" "+j);
            if(j==n && wordCount!=1){
                space=1;
                remSpace=0;
            }
            StringBuilder sb=new StringBuilder();
            for(int k=i;k<j;k++)
            {
                sb.append(words[k]);
                int spacing=space;
                if(remSpace>0)
                {
                    spacing+=1;
                    remSpace--;
                }
                // System.out.println(spacing+" "+remSpace);
                if(wordCount==1 || k!=j-1)
                    while(spacing-->0)
                    {
                        sb.append(" ");
                    }
            }
            if(j==n && wordCount!=1){
                int spaceLast=maxWidth-count;
                while(spaceLast-->0)
                {
                    sb.append(" ");
                }
            }
            output.add(sb.toString());
            i=j;
        }
        return output;
    }
}