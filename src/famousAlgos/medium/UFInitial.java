package famousAlgos.medium;

import util.Utils;

import java.util.*;

public class UFInitial {
    int size;
    HashMap<Integer, Set<Integer>> disjointSet;
    public UFInitial(int n){
        this.size = n;
        this.disjointSet = new HashMap<>();
    }

    public int addNewSet(int p){
        Set<Integer> temp = new HashSet<>();
        temp.add(p);
        disjointSet.put(p, temp);
        return p;
    }

    public void union(int p, int q){
        int pComponent = find(p);
        int qComponent = find(q);

        if(pComponent == -1)
            pComponent = addNewSet(p);
        if(qComponent == -1)
            qComponent = addNewSet(q);

        Set<Integer> pSet = disjointSet.get(pComponent);
        Set<Integer> qSet = disjointSet.get(qComponent);
        disjointSet.remove(pComponent);
        disjointSet.remove(qComponent);
        Set<Integer> unionedSet = new HashSet<>();
        unionedSet.addAll(pSet);
        unionedSet.addAll(qSet);
        disjointSet.put(p, unionedSet);
    }

    public int find(int p){
        for(Map.Entry<Integer,Set<Integer>> entry : disjointSet.entrySet()){
            Set<Integer> set = entry.getValue();
            if(set.contains(p))
                return entry.getKey();
        }
        return -1;
    }

    public boolean connected(int p, int q){
        for(Map.Entry<Integer,Set<Integer>> entry : disjointSet.entrySet()){
            Set<Integer> set = entry.getValue();
            if(set.contains(p))
                if(set.contains(q))
                    return true;
        }
        return false;
    }

    public int count(){
        return size;
    }

    public static int[][] validate(int[][] input){
        UFInitial uf = new UFInitial(input.length);
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

        int[][] actual = UFInitial.validate(input);

        Utils.assertTrue(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                }
            }
            Utils.assertTrue(containsMatch);
        }
    }
}
