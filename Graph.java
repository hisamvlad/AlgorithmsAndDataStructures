package AlgorithmsAndDataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    //Mapping from Node id to the actual node
    //Mostly used for getNode and addEdge
    private HashMap<Integer, GNode> nodeLookup = new HashMap<Integer, GNode>();

    public static class GNode {
        // id that represents the node id
        private int id;
        LinkedList<GNode> adjacent = new LinkedList<GNode>();
        private GNode(int id) {
            this.id = id;
        }
    }

    private GNode getGNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        GNode s = getGNode(source);
        GNode d = getGNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        GNode s = getGNode(source);
        GNode d = getGNode(destination);
        //HashSet to store all of the ids that were already visited.
        // HashSet stores only unique values
        HashSet<Integer> visited = new HashSet<Integer>();
        // Recursive call to the method itself
        return hasPathDFS(s, d,visited);
    }
    private boolean hasPathDFS(GNode source, GNode destination, HashSet<Integer> visited) {
        // if this node has already been visited,
        // return false because there's no path then
        if(visited.contains(source.id)) {
            return false;
        }
        // otherwise, mark this node as visited
        visited.add(source.id);
        // if I'm at my source,
        if(source == destination) {
            //return true because there's definitely a path there
            return true;
        }
        //otherwise, go see all of my children
        // to see if there's a path there
        for(GNode child : source.adjacent) {
            // if there's a path from child to the destination
            if(hasPathDFS(child, destination, visited)) {
                //return true and that will bubble up the stack
                return true;
            }
        }
        // Otherwise, if I came to the very end
        // and I haven't found a path, then
        // There's no path
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getGNode(source), getGNode(destination));
    }

    public boolean hasPathBFS(GNode source, GNode destination) {
        // List of the nodes I need to visit next
        LinkedList<GNode> nextToVisit = new LinkedList<>();
        // HashSet that represents everything I've already visited
        HashSet<Integer> visited = new HashSet<>();
        // first, I need to visit my source
        nextToVisit.add(source);
        // While there's a place to visit
        while(!nextToVisit.isEmpty()) {
            //keep going
            //first, grab a very first node in that list
            // and remove it
            GNode gNode = nextToVisit.remove();
            //if this is my destination, then
            // there's certainly a path
            if(gNode == destination) {
                return true;
            }
            //visiting checking
            if(visited.contains(gNode.id)) {
                //go to the next value
                continue;
            }
            //otherwise, mark it as visited
            visited.add(gNode.id);
            // and then go and actually add my children
            for(GNode child : gNode.adjacent ) {
            // go and add all of those to my 'next to visit'
                nextToVisit.add(child);
            }
        }
        //if I got to the very end and there's no path
        return false;
    }

}
