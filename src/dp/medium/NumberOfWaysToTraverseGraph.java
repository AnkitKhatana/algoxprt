package dp.medium;

import util.Utils;

public class NumberOfWaysToTraverseGraph {

    public int numberOfWaysToTraverseGraphDP(int width, int height) {
        // Write your code here.
        int[] prev = new int[width];
        prev[0] = 1;

        for(int i=0; i<height; i++){
            int[] current = new int[width];
            for(int j=0; j<width; j++ ){
                if(j == 0)
                    current[j] = prev[j] + 0;
                else
                    current[j] = prev[j] + current[j-1];
            }
            prev=current;
        }
        return prev[width-1];
    }

    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        long factWidth=1 , factHeight=1 , fact=1;
        for(int i=2; i < width+height-1; i++){
            fact = fact*i;
            if(i == width-1)
                factWidth = fact;
            if(i == height-1)
                factHeight = fact;
        }
        fact=fact/factWidth;
        fact=fact/factHeight;
        return (int)fact;
    }

    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        int expected = 10;
        int actual = new NumberOfWaysToTraverseGraph().numberOfWaysToTraverseGraph(width, height);
        Utils.assertTrue(expected == actual);    }
}
