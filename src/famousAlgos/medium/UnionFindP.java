package famousAlgos.medium;

import util.Utils;

public class UnionFindP {

    static class UnionFind {
        // Write your code here.
        int[] id ;
        int size ;
        int[] height ;

        UnionFind(){
            id = new int[2000];
            height = new int[2000];
            size = 0;
            for(int i=0; i<2000; i++){
                id[i] = -1;
            }
        }

        public void createSet(int value) {
            // Write your code here.
            id[value] = value;
            height[value] = 1;
            size++;
        }

        public Integer find(int value) {
            // Write your code here.
            if(id[value] == -1)
                return null;
            if(id[value] == value)
                return value;
            id[value] = find(id[value]);
            return id[value];
        }

        public void union(int valueOne, int valueTwo) {
            // Write your code here.
            Integer rootOne = find(valueOne);
            Integer rootTwo = find(valueTwo);

            if(rootOne == null || rootTwo == null || rootOne.equals(rootTwo))
                return ;

            if(height[rootOne] < height[rootTwo])
                id[rootOne] = rootTwo;
            else {
                id[rootTwo] = rootOne;
                if(height[rootOne] == height[rootTwo])
                    height[rootOne]++;
            }
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFindP.UnionFind();
        unionFind.createSet(0);
        unionFind.createSet(2);
        unionFind.union(0, 2);
        unionFind.createSet(3);
        unionFind.createSet(1);
        unionFind.union(1, 3);
        Utils.assertTrue(unionFind.find(0) == unionFind.find(2));
        Utils.assertTrue(unionFind.find(1) == unionFind.find(3));
        unionFind.union(0,1);
        Utils.assertTrue(unionFind.find(0) == unionFind.find(1));
    }

    public static void main1(String[] args) {
        UnionFind unionFind = new UnionFindP.UnionFind();
        Utils.assertTrue(unionFind.find(1) == null);
        unionFind.createSet(1);
        Utils.assertTrue(unionFind.find(1) == 1);
        unionFind.createSet(5);
        Utils.assertTrue(unionFind.find(1) == 1);
        Utils.assertTrue(unionFind.find(5) == 5);
        unionFind.union(5, 1);
        Utils.assertTrue(unionFind.find(5) == unionFind.find(1));
    }
}
