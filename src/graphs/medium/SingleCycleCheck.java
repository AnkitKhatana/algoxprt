package graphs.medium;

import util.Utils;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int index=0, counter=array.length;
        while(counter != 0){
            if(index == 0 && counter<array.length)
                return false;
            index = (index+array[index]) % array.length;
            index = index < 0 ? index+array.length : index;
            counter--;
        }
        return index %array.length == 0;
    }

    public static boolean hasSingleCycleUnOptimized(int[] array) {
        // Write your code here.
        int index=array[0], counter=array.length-1;
        array[0]=0;
        if(index >= array.length || index < 0)
            index=(index+(Math.abs(index / array.length)+1)*array.length)%array.length;
        while(counter != 0){
            if(index == 0)
                return false;
            int temp=array[index];
            array[index]=0;
            index=(index+temp);
            if(index >= array.length || index < 0)
                index = (index + (Math.abs(index / array.length)+1)*array.length) % array.length;
            counter--;
        }
        return index == 0;
    }

    public static void main(String[] args) {
        Utils.assertTrue(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
    }
}
