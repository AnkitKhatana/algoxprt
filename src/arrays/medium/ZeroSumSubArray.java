package arrays.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZeroSumSubArray {

    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        int sum=0;
        for(int i=0; i<nums.length; i++){
            for (int j=i; j<nums.length; j++){
                sum+= nums[j];
                if(sum==0)
                    return true;
            }
            sum=0;
        }
        return false;
    }

    public boolean zeroSumSubarray1(int[] nums) {
        // Write your code here.
        int[] sums= new int[nums.length];

        for(int i=nums.length; i>=0; i--){
            for(int j=i; j<sums.length;j++){
                sums[j]+=nums[i];
                if(sums[j]==0)
                    return true;
            }
        }
        return false;
    }

    public boolean zeroSumSubarray2(int[] nums) {
        // Write your code here.
        Set<Integer> occurences = new HashSet<>();
        int sum=0;
        for(int i=0;i<nums.length; i++){
            sum+=nums[i];
            if(sum==0 || occurences.contains(sum))
                return true;
            else
                occurences.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4, 2, -1, -1, 3};
        boolean expected = true;
        boolean actual = new ZeroSumSubArray().zeroSumSubarray1(input);
        System.out.println(actual);

        Map<String , String> eventMap = new HashMap<>();

        eventMap.put("key","value");
        eventMap.put("key", "another_value");

        System.out.println(eventMap.toString());
    }
}
