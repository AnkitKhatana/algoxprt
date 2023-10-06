package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsAlternative {

    public static void swap(List<Integer> array, int a , int b){
        int temp = array.get(a);
        array.set(a,array.get(b));
        array.set(b,temp);
    }
    public static void getPermutationsHelper(int level, List<Integer> array, List<List<Integer>> permutations){
        if(level == array.size()-1)
            permutations.add(new ArrayList<>(array));
        else {
            for (int toSwap = level; toSwap < array.size(); toSwap++) {
                swap(array, level, toSwap);
                getPermutationsHelper(level + 1, array, permutations);
                swap(array, level, toSwap);
            }
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> completePermutations = new ArrayList<>();
        getPermutationsHelper(0,array,completePermutations);
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
