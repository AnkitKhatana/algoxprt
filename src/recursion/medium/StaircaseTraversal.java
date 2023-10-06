package recursion.medium;

public class StaircaseTraversal {
    public static int count=0;

    public int stairCaseTraversalHelper(int height, int maxSteps, int traversed){
        count++;
        if(traversed == height)
            return 1;
        if(traversed > height)
            return 0;
        int ways=0;
        for(int i=1; i<=maxSteps; i++){
            int newTraversed = traversed+i;
            ways = ways + stairCaseTraversalHelper(height,maxSteps,newTraversed);
        }
        return ways;
    }
    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        return stairCaseTraversalHelper(height,maxSteps,0);
    }

    public static void main(String[] args) {
        System.out.println(new StaircaseTraversal().staircaseTraversal(10,2));  //-- 5
        System.out.println(count);  //-- 15
    }

}
