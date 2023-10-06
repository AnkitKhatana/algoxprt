package arrays.medium;

import util.Utils;

public class MajorityElement2 {

    public int majorityElement(int[] array) {
        // Write your code here.
        int AssumedMajorityElement=array[0];
        int count=1;
        for(int i=1; i<array.length; i++){
            if(count == 0)
                AssumedMajorityElement = array[i];
            if(array[i] == AssumedMajorityElement)
                count++;
            else
                count--;
        }
        return AssumedMajorityElement;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 2, 2, 1, 2};
        int expected = 2;
        int actual = new MajorityElement2().majorityElement(input);
        Utils.assertTrue(expected == actual);
    }
}
