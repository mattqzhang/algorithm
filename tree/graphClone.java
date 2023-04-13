/*
Graph Clone: Given a graph, make a clone of this graph
BFS:
- every time pop a node from queue, get the mapping node in the new graph from the hashmap.
- for each of its neighbor:
  > if it's not in the hashmap(not visited yet), create a mapping neighbor node, and push the mapping pair into hashmap. Then push this neighbor to queue, and link the mapping neighbor to the mapping node.
  > Otherwise (already visited), get the mapping node from hashmap, link it as the mapping neighbor to the mapping node.
DFS:
- if a node already exists in hashmap (visited), return the mapping node
- otherwise, create a mapping node, and put this pair in hashmap,
- for each neighbor node, DFS find/create the mapping neighbor node, link to the mapping node. 

lc 133
https://leetcode.com/problems/clone-graph/description/
*/

    private HashMap<Node, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        // this node's already visited, return the mapping node
        if(hm.containsKey(node))
            return hm.get(node);

        // create a mapping node, and add this pair in hashmap
        Node newNode =  new Node(node.val, new ArrayList<>());
        // put the pair in hashMap before exploring neighbors
        hm.put(node, newNode);

        // for each of the neighbor nodes, find/create the mapping neighbor node by DFS
        // and link to the mapping node
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            Node newNeighbor = cloneGraph(neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }


////// old solution

import java.util.*;

/* Graph representation */
class Node{
    int data;
    Vector<Node> neighbors;
   
    public Node(Node node){
        data = node.data;
    }
}
public class cloneGraph {

    /* clone a graph, BFS */
    Node clone(Node graph) {
        if (graph == null)
            return null;

        // create a newGraph root, and put this pair in hashmap
        Node newGraph = new Node(graph);
        HashMap<Node, Node> hm = new HashMap<Node, Node>();
        hm.put(graph, newGraph);

        Queue<Node> qe = new LinkedList<Node>();
        qe.add(graph);

        // loop through the queue, retrieve each pair of <node, newNode>
        // then for each node's neighbor, create/connect newNode's neighbor.
        while (!qe.isEmpty()) {
            Node node = qe.remove();
            Node newNode = hm.get(node);

            for (int i = 0; i < node.neighbors.size(); i++) {
                Node neighbor = node.neighbors.get(i);

                // this neighbor hasn't been visited before
                if (!hm.containsKey(neighbor)) {
                    // clone a node for this neighbor, and put this pair in hm
                    Node newNeighbor = new Node(neighbor);
                    hm.put(neighbor, newNeighbor);

                    // connect the new node to it's new neighbor
                    newNode.neighbors.add(newNeighbor);

                    // push this neighbor to queue
                    qe.add(neighbor);

                } else {
                    // neighbor already visited (cloned neighbor node also already created)
                    // just make edge from the newNode to the cloned neighbor
                    newNode.neighbors.add(hm.get(neighbor));
                }
            }
        }

        return newGraph;
    }

    /* clone a graph, DFS */
    Node cloneDFS(Node node, HashMap<Node, Node> hm){
        if(node == null)
            return null;
       
        // this node's already visited, return the mapping node
        if(hm.containsKey(node))
            return hm.get(node);
           
        // create a mapping node, and add this pair in hashmap
        Node newNode =  new Node(node);
        hm.put(node, newNode);
               
        // for each of the neighbor nodes, find/create the mapping neighbor node by DFS
        // and link to the mapping node
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            Node newNeighbor = cloneDFS(neighbor, hm);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
   
}
