package recursion.medium;

import util.Utils;

import java.util.HashMap;
import java.util.Map;

public class BlackJackProbability {

    public float blackjackProbabilityHelperOld(int target , int runningSum , int level, Map<String , Float> dpTableMap){
        if(runningSum > target)
            return 1/(float)Math.pow(10,level);
        if(runningSum >= target-4)
            return 0.0f;
        float bustProb = 0.0f;
        for(int i=1 ; i<11; i++) {
            if(!dpTableMap.containsKey(level+"_"+(runningSum+i)))
                dpTableMap.put(level+"_"+(runningSum+i), blackjackProbabilityHelperOld(target, runningSum + i, level + 1,dpTableMap));
            bustProb += dpTableMap.get(level+"_"+(runningSum+i));
        }
        return bustProb;
    }

    public float blackjackProbabilityOld(int target, int startingHand) {
        // Write your code here.
        Map<String , Float> dpTableMap = new HashMap<>();
        float bustProb = blackjackProbabilityHelperOld(target, startingHand, 0,dpTableMap);
        return (float) bustProb;
    }

    public float blackjackProbabilityHelper(int target , int currentHand , Map<Integer,Float> memo){
        if(memo.containsKey(currentHand))
            return memo.get(currentHand);
        if(currentHand > target)
            return 1.0f;
        if(currentHand >= target-4)
            return 0.0f;
        float bustProbFromCurrentHand = 0.0f;
        for(int i=1; i<=10; i++)
            bustProbFromCurrentHand += 0.1 * blackjackProbabilityHelper(target,currentHand+i,memo);
        memo.put(currentHand,bustProbFromCurrentHand);
        return bustProbFromCurrentHand;
    }
    public float blackjackProbability(int target, int startingHand) {
        // Write your code here.
        Map<Integer , Float> memo = new HashMap<>();
        return Math.round(blackjackProbabilityHelper(target,startingHand,memo) * 1000f)/ 1000f;
    }

    public static void main(String[] args) {
        int target = 21;
        int startingHand = 15;
        float expected = 0.45f;
        float actual = new BlackJackProbability().blackjackProbability(target, startingHand);
        Utils.assertTrue(expected == actual);
    }
}
