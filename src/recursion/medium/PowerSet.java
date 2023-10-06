package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void powerSetHelper(int level, List<Integer> array, List<Integer> set, List<List<Integer>> powerSet){
        if( level == array.size() )
            powerSet.add(set);
        else {
            List<Integer> setWithCurrentElement = new ArrayList<>(set);
            setWithCurrentElement.add(array.get(level));
            powerSetHelper(level + 1, array, setWithCurrentElement, powerSet);
            powerSetHelper(level + 1, array, set, powerSet);
        }
    }
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSetHelper(0,array,new ArrayList<>(),powerSet);
        return powerSet;
    }

    public static void main(String[] args) {
        List<List<Integer>> output = PowerSet.powerset(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));

        for(List<Integer> set : output){
            System.out.print("[");
            for(Integer element : set){
                System.out.print(element+ ",");
            }
            System.out.println("]");
        }
    }
}
