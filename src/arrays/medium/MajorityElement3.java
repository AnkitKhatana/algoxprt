package arrays.medium;

import util.Utils;

public class MajorityElement3 {

    public int majorityElement(int[] array) {
        // Write your code here.
        int majorityElement=0;

        for(int i=0; i<32 ; i++){
            int currentBit = 1 << i;
            int countOnes=0;
            for(int j=0; j<array.length; j++){
                if( (currentBit & array[j]) > 0)
                    countOnes++;
            }

            if(countOnes > array.length/2)
                majorityElement+=currentBit;
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 2, 2, 1, 2};
        int expected = 2;
        int actual = new MajorityElement3().majorityElement(input);
        Utils.assertTrue(expected == actual);
    }
}
