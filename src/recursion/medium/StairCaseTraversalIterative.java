package recursion.medium;

import java.util.HashMap;
import java.util.Map;

public class StairCaseTraversalIterative {

    static int count=0;
    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        int sum=1;
        int[] waysToStep = new int[height+1];
        waysToStep[0]=1;
        waysToStep[1]=1;
        for(int i=2;i<height+1;i++){
            sum+=sum;
            if(i>maxSteps)
                sum-=waysToStep[i-maxSteps-1];
            waysToStep[i]=sum;
        }
        return waysToStep[height];
    }

    public static void main(String[] args) {
        System.out.println(new StairCaseTraversalIterative().staircaseTraversal(4,2));
        System.out.println(count);
    }
}
