/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     Map<Node, Node> cache = new HashMap<>();
    
    public Node cloneGraph(Node node) {      
    
        if (node == null) return null;
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        Node copyNode = new Node(node.val, new ArrayList<>());
        cache.put(node, copyNode);
        for (Node person : node.neighbors) {
            cache.get(node).neighbors.add(cloneGraph(person));
        }
        return cache.get(node);
        
       
        
    }
    
//     public void dfs( Node node , Node copy , boolean vis[])
//     {
//         vis[copy.val] = true ;
//         for(Node it : neighbors.get(node))
//         {
//             if(vis[it] == false)
//             {
//                 Node newNode = new Node(it.val);
//                 neighbors.add(newNode);
//                 dfs(it , newNode , vis);
                
                
                
//             }
//         }
//     }

}