package graphs.medium;

import util.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoColorable {

    public boolean twoColorable(int[][] edges) {
        // Write your code here.
        boolean[] colors = new boolean[edges.length];
        boolean[] discovered = new boolean[edges.length];

        colors[0] = true;
        discovered[0] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);

        while(!queue.isEmpty()){
            int current = queue.removeFirst();
            boolean color = colors[current];
            int[] neighbours = edges[current];
            for(int neighbour : neighbours){
                if(!discovered[neighbour]){
                    discovered[neighbour] = true;
                    queue.addLast(neighbour);
                    colors[neighbour] = !color;
                } else if(colors[neighbour] == color)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1}, {0}};
        boolean expected = true;
        boolean actual = new TwoColorable().twoColorable(input);
        Utils.assertTrue(expected == actual);
    }
}
