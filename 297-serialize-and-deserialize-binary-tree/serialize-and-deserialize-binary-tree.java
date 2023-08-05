/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        StringBuilder s=new StringBuilder();
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            if(cur==null)
            {
                s.append(" null");
                continue;
            }
            s.append(" "+cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s[]=data.split(" ");
        int n=s.length;
        if(s[1].equals("null")) return null;
        TreeNode root=new TreeNode(Integer.valueOf(s[1]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int i=2;
        while(i<n)
        {
            TreeNode cur=q.poll();
            if(!s[i].equals("null")){
            //     cur.left=new TreeNode();
            // else{
                cur.left=new TreeNode(Integer.valueOf(s[i]));
            // System.out.println(cur.val);
            q.add(cur.left);

            }
            i++;
            if(i==n) break;
            if(!s[i].equals("null")){
            //     cur.right=null;
            // else
                cur.right=new TreeNode(Integer.valueOf(s[i]));
            q.add(cur.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));