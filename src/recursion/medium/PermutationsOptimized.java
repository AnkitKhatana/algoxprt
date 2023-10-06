package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOptimized {

    public static void getPermutationsHelper(List<Integer> isNotIncluded, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if(isNotIncluded.size()==0 && currentPermutation.size()>0)
            permutations.add(currentPermutation);
        else {
            for (int i = 0; i < isNotIncluded.size(); i++) {
                List<Integer> newCurrentPermutation = new ArrayList<>(currentPermutation);
                newCurrentPermutation.add(isNotIncluded.get(i));
                List<Integer> newIsNotIncluded = new ArrayList<>(isNotIncluded);
                newIsNotIncluded.remove(i);
                getPermutationsHelper(newIsNotIncluded, newCurrentPermutation, permutations);
            }
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> completePermutations = new ArrayList<>();
        getPermutationsHelper(array,new ArrayList<Integer>(),completePermutations);
        return completePermutations;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> input1 = new ArrayList<Integer>();
        List<List<Integer>> permutations = getPermutations(input);
        for (List<Integer> subarray : permutations){
            for(Integer element : subarray)
                System.out.print(element+" ");
            System.out.println();
        }
    }
}
