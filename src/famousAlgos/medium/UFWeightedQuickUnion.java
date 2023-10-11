package famousAlgos.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UFWeightedQuickUnion {

    int size;
    int[] id;
    int[] height;

    public UFWeightedQuickUnion(int n){
        size = n;
        id = new int[n];
        for(int i=0; i<n; i++)
            id[i] = i;
        height = new int[n];
        for(int i=0; i<n; i++)
            height[i] = 1;
    }

    private int find(int p) {
        while(this.id[p] != p)
            p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        if(height[pRoot] < height[qRoot]) {
            id[pRoot] = qRoot;
            height[pRoot] += height[qRoot];
        }
        else {
            id[qRoot] = pRoot;
            height[qRoot] += height[pRoot];
        }
        size--;
    }



    public static int[][] validate(int[][] input){
        UFWeightedQuickUnion uf = new UFWeightedQuickUnion(input.length);
        List<int[]> toReturn = new ArrayList<>();

        for(int[] pair : input){
            int p = pair[0];
            int q = pair[1];
            if (uf.find(p) == uf.find(q) && uf.find(p) != -1) continue;
            uf.union(p, q);
            toReturn.add(new int[]{p , q});
        }
        int[][] toReturnArray = new int[toReturn.size()][2];
        return toReturn.toArray(toReturnArray);
    }

    public static void main(String[] args) {
        int[][] input = { {4,3} , {3,8} , {6,5} , {9,4} , {2,1} , {8,9} , {5,0} , {7,2} , {6,1} , {1,0} , {6,7} } ;
        int[][] expected = { {4,3} , {3,8} , {6,5} , {9,4} , {2,1} , {5,0} , {7,2} , {6,1} };

        int[][] actual = UFWeightedQuickUnion.validate(input);

        Utils.assertTrue(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                    break;
                }
            }
            Utils.assertTrue(containsMatch);
        }
    }
}
