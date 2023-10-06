package recursion.medium;

import java.util.HashMap;
import java.util.Map;

public class StairCaseTraversalDP {

    public static int count=0;
    public int stairCaseTraversalHelper(int height, int maxSteps, int traversed, Map<Integer,Integer> memoize){
        count++;
        if(traversed > height)
            return 0;
        if(!memoize.containsKey(traversed)) {
            int ways = 0;
            for (int i = 1; i <= maxSteps; i++)
                ways = ways + stairCaseTraversalHelper(height, maxSteps, traversed + i, memoize);
            memoize.put(traversed,ways);
        }
        return memoize.get(traversed);
    }
    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        Map<Integer,Integer> memoize = new HashMap<>();
        memoize.put(height,1);
        return stairCaseTraversalHelper(height,maxSteps,0,memoize);
    }

    public static void main(String[] args) {
        System.out.println(new StairCaseTraversalDP().staircaseTraversal(4,2));
        System.out.println(count);
    }
}
