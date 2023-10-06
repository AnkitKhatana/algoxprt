package graphs.medium;

import util.Utils;

public class CycleInGraph {

    public boolean dfsFindCycle(int[][] edges, int[] parent , boolean[] discovered, boolean[] traversed, int current){
        discovered[current] = true;
        for(int adjacentVertex=0; adjacentVertex<edges[current].length; adjacentVertex++){
            if(!discovered[edges[current][adjacentVertex]]){
                parent[edges[current][adjacentVertex]] = current;
                if(dfsFindCycle(edges,parent,discovered,traversed,edges[current][adjacentVertex]))
                    return true;
            }
            else if(!traversed[edges[current][adjacentVertex]])
                return true;
        }
        traversed[current] = true;
        return false;
    }
    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        int[] parent = new int[edges.length];
        boolean[] discovered = new boolean[edges.length];
        boolean[] traversed = new boolean[edges.length];
        for(int i=0; i<edges.length;i++)
            parent[i] = -1;

        for(int i=0; i<edges.length; i++){
            if(!traversed[i] && dfsFindCycle(edges,parent,discovered,traversed,i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
        boolean expected = true;
        boolean actual = new CycleInGraph().cycleInGraph(input);
        Utils.assertTrue(expected == actual);
    }
}
