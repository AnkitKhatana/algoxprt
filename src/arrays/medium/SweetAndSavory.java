package arrays.medium;

import util.Utils;

import java.util.Arrays;

public class SweetAndSavory {

    public int[] sweetAndSavory(int[] dishes, int target) {
        // Write your code here.
        Arrays.sort(dishes);
        int left = 0;
        int right = dishes.length-1;
        int[] closest = {0,0};
        int closestMargin = Integer.MAX_VALUE;
        while (left<right && dishes[left]<0 && dishes[right]>0) {
            int sum = dishes[left] + dishes[right];
            if (sum > target)
                right--;
            else if(sum == target)
                return new int[] {dishes[left],dishes[right]};
            else{
                int margin = target - sum;
                if(closestMargin == Integer.MAX_VALUE || Math.abs(margin) < Math.abs(closestMargin)) {
                    closest[0] = dishes[left];
                    closest[1] = dishes[right];
                    closestMargin = target - dishes[left] - dishes[right];
                }
                left++;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] dishes = new int[] {-3, -5, 1, 7};
        int target = 0;
        int[] expected = new int[] {-3, 1};
        int[] actual = new SweetAndSavory().sweetAndSavory(dishes, target);
        System.out.println(Arrays.toString(actual));
        Utils.assertTrue(actual.length == 2);
        Utils.assertTrue(actual[0] == expected[0]);
        Utils.assertTrue(actual[1] == expected[1]);
    }
}
