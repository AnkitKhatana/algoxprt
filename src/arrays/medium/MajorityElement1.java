package arrays.medium;

import util.Utils;

public class MajorityElement1 {

    public int majorityElement(int[] array) {
        // Write your code here.
        for(int i=0; i<array.length; i++){
            if(array[i]>0){
                int tempElement=array[i];
                while(tempElement>0){
                    int holder = array[tempElement-1];
                    if(holder > 0)
                        array[tempElement - 1] = -1;
                    else
                        array[tempElement-1] -= 1;
                    tempElement=holder;
                }
            }
        }
        int max=0;
        for(int i=0;i<array.length;i++){
            if(array[i] < 0 && array[i] < array[max])
                max=i;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 2, 2, 1, 2};
        int expected = 2;
        int actual = new MajorityElement1().majorityElement(input);
        Utils.assertTrue(expected == actual);
    }

}
