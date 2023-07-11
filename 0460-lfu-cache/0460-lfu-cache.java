class LFUCache {
    class Node{
        int key;
        int data;
        int count;
        Node next,pre;
        Node(int key,int data)
        {
            this.key=key;
            this.data=data;
            count=0;
            next=null;pre=null;
        }
    }
    HashMap<Integer,Node> map=new HashMap<>();//key node
    HashMap<Integer,List<Node>> linkedlist=new HashMap<>();//count,linkedlist head,tail
    PriorityQueue<Integer> minCount=new PriorityQueue<>();
    int capacity;
    int length;
    public LFUCache(int cap) {
        length=0;
        capacity=cap;
    }
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            // System.out.println(node+" "+linkedlist+" "+map);
            remove(node);
            node.count+=1;
            insert(node.count,node);
        }
        else{
            return -1;
        }
        // System.out.println(key);
        // System.out.println(map);
        // for(int i:map.keySet())
        // {
        //     System.out.print(map.get(i).data+" ");
        // }
        // System.out.println();
        // System.out.println(linkedlist);
        // for(int i:linkedlist.keySet())
        // {
        //     System.out.println(i);
        //     Node temp=linkedlist.get(i).get(0);
        //     while(temp!=null)
        //     {
        //         System.out.print(temp.data+" ->");
        //         temp=temp.next;
        //     }
        // }
        // System.out.println("++++++++++++++++++++++++++++++");
        return map.get(key).data;
    }
    void insert(int count,Node node)
    {
        if(!minCount.contains(count))
            minCount.add(count);
        List<Node> list=new ArrayList<>();
        list.add(new Node(-1,-1));
        list.add(new Node(-1,-1));
        list.get(0).next=list.get(1);
        list.get(1).pre=list.get(0);
        linkedlist.putIfAbsent(count,list);//default tail
        Node preHead=linkedlist.get(count).get(0);
        Node first=preHead.next;
        preHead.next=node;
        node.next=first;
        node.pre=preHead;
        first.pre=node;
    }
    void remove(Node node)
    {
        int curCount=node.count;
        // System.out.println("remove "+node.data+" "+node+"  count"+curCount+" "+linkedlist);
            node.pre.next=node.next;
            node.next.pre=node.pre;
        // for(int i:linkedlist.keySet())
        //     {
        //         System.out.println(i);
        //         Node temp=linkedlist.get(i).get(0);
        //         while(temp!=null)
        //         {
        //             System.out.print(temp.data+" ->");
        //             temp=temp.next;
        //         }
        //     }
        // System.out.println("remove "+node.data+" count"+curCount+" "+linkedlist);
        if(linkedlist.get(curCount).get(0).next.data==-1)//all removed
        {
            minCount.remove(curCount);
            linkedlist.remove(curCount); 
        }  
    }
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.data=value;
            remove(node);
            node.count+=1;
            insert(node.count,node);
        }  
        else{
            if(length==capacity)
            {
                int count=minCount.peek();
                // System.out.println(minCount+" count"+count+" "+linkedlist.get(count).get(1).pre.data);
                map.remove(linkedlist.get(count).get(1).pre.key);
                remove(linkedlist.get(count).get(1).pre);
                length--;
            }
            Node node=new Node(key,value);
            node.count+=1;
            map.put(key,node);
            // System.out.println("map"+map);
            insert(node.count,node);
            // System.out.println("linkedlist"+linkedlist);
            // for(int i:linkedlist.keySet())
            // {
            //     System.out.println(i);
            //     Node temp=linkedlist.get(i).get(0);
            //     while(temp!=null)
            //     {
            //         System.out.print(temp.data+" ->");
            //         temp=temp.next;
            //     }
            // }
            // System.out.println("-------------------");
            length++;
            // System.out.println(length+" "+capacity);
            
        } 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */