package recursion.medium;

import java.util.*;

public class Permutations {

    public static void getPermutationsHelper(List<Integer> isNotIncluded, List<List<Integer>> incompletePermutationsList, List<List<Integer>> completePermutationsList, int level, int totalElements){
        for(int i=0; i<incompletePermutationsList.size();i++){
            List<Integer> permutation = incompletePermutationsList.get(i);
            if(permutation.size() == level){
                for(int j=0; j< isNotIncluded.size(); j++){
                    List<Integer> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(isNotIncluded.get(j));
                    if(level == totalElements)
                        completePermutationsList.add(newPermutation);
                    else
                        incompletePermutationsList.add(newPermutation);
                    List<Integer> isNotIncludedChild = new ArrayList<>(isNotIncluded);
                    isNotIncludedChild.remove(j);
                    getPermutationsHelper(isNotIncludedChild,incompletePermutationsList,completePermutationsList,level+1,totalElements);
                }
                incompletePermutationsList.remove(i);
            }
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> incompletePermutations = new ArrayList<>();
        List<List<Integer>> completePermutations = new ArrayList<>();
        incompletePermutations.add(new ArrayList<Integer>());
        getPermutationsHelper(new ArrayList<>(array),incompletePermutations,completePermutations,0,array.size()-1);
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
