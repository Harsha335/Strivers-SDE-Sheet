class Solution {
    class Trie{
        Trie child[];
        boolean isEnd;
        int count;
        Trie()
        {
            child=new Trie[26];
            isEnd=false;
            count=0;
        }
    }
    int n;
    private int subsequences(String s,int ind,Trie root)
    {
        if(root==null)
            return 0;
        if(ind==n)
        {
            if(root.isEnd)
            {
                root.isEnd=false;
                return root.count;
            }
            return 0;
        }
        int ans=0;
        // System.out.println(root.isEnd);
        if(root.isEnd)
        {
            root.isEnd=false;
            ans=root.count;
        }
        for(int i=0;i<26;i++)
        {
            // System.out.print(i+" "+root.child[i]);
            // System.out.println();
            if(root.child[i]!=null)
            {
            // System.out.println(ind+" "+(char)(97+i));
                // if(s.charAt(ind)==(char)(97+i))
                // {
            // System.out.println(ind+" "+(char)(97+i));
                int nextIndex=s.indexOf((char)(97+i)+"",ind);
                if(nextIndex!=-1)
                    ans+=subsequences(s,nextIndex+1,root.child[i]);
                // }
                // else
                //     ans+=subsequences(s,ind+1,root);
            }
        }
        return ans;
    }
    public int numMatchingSubseq(String s, String[] words) {
        // int count=0;
        n=s.length();
        Trie root=new Trie();
        for(String x:words)
        {
            Trie node=root;
            for(char c:x.toCharArray())
            {
            // System.out.println(node+" "+node.child[c-'a']);
                if(node.child[c-'a']==null)
                    node.child[c-'a']=new Trie();
                node=node.child[c-'a'];
            }
            // if(node.isEnd)
            //     count
            node.isEnd=true;
            node.count++;
            // System.out.println(node+" "+node.isEnd);
        }
        return subsequences(s,0,root);
    }
}