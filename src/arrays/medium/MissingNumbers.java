package arrays.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MissingNumbers {

    public int[] missingNumbers(int[] nums) {
        // Write your code here.
        boolean lengthPlusOneNumber=false;
        boolean lengthPlusTwoNumber=false;
        for(int i=0; i<nums.length; i++){
            int element = Math.abs(nums[i]);
            if(element == nums.length+2)
                lengthPlusTwoNumber=true;
            else if(element == nums.length+1)
                lengthPlusOneNumber=true;
            else
                nums[element-1] = nums[element-1]*-1;
        }

        int[] missingNums = new int[2];
        int missingNumIndex=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                missingNums[missingNumIndex++]=i+1;
        }
        if(!lengthPlusOneNumber)
            missingNums[missingNumIndex++]=nums.length+1;
        if(!lengthPlusTwoNumber)
            missingNums[missingNumIndex]=nums.length+2;
        return missingNums;
    }

    public static void main(String[] args) {
        int[] input = {1,4,3};
        System.out.println(Arrays.toString(new MissingNumbers().missingNumbers(input)));
    }
}
