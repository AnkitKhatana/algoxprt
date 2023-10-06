package greedy.easy;

import util.Utils;

import java.util.*;

public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        // Write your code here.
        Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                return o1.get("payment").compareTo(o2.get("payment"));
            }
        });
        boolean[] schedulingArray = new boolean[7];
        int totalProfit = 0;
        for(int i=jobs.length-1; i>=0; i--){
            int deadline = jobs[i].get("deadline") > 7 ? 6 : jobs[i].get("deadline")-1;
            while(deadline >= 0){
                if(!schedulingArray[deadline]){
                    schedulingArray[deadline] = true;
                    totalProfit += jobs[i].get("payment");
                    break;
                }
                deadline--;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        HashMap[] input = new HashMap[3];
        HashMap<String, Integer> job1 = new HashMap<String, Integer>();
        job1.put("deadline", 1);
        job1.put("payment", 1);
        input[0] = job1;

        HashMap<String, Integer> job2 = new HashMap<String, Integer>();
        job2.put("deadline", 2);
        job2.put("payment", 1);
        input[1] = job2;

        HashMap<String, Integer> job3 = new HashMap<String, Integer>();
        job3.put("deadline", 2);
        job3.put("payment", 2);
        input[2] = job3;

        int expected = 3;
        int actual = new OptimalFreelancing().optimalFreelancing(input);
        System.out.println(actual);
        Utils.assertTrue(expected == actual);
    }

}
