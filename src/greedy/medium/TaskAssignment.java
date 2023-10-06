package greedy.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TaskAssignment {

    static class TaskWithIndex {
        private int index;
        private int duration;
        TaskWithIndex(int index , int duration){
            this.index = index;
            this.duration = duration;
        }
        public Integer getDuration() {
            return duration;
        }

        public int getIndex() {
            return index;
        }
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        TaskWithIndex[] taskWithIndices = new TaskWithIndex[tasks.size()];
        for(int i=0; i<tasks.size(); i++){
            taskWithIndices[i] = new TaskWithIndex(i,tasks.get(i));
        }

        Arrays.sort(taskWithIndices, new Comparator<TaskWithIndex>() {
            @Override
            public int compare(TaskWithIndex o1, TaskWithIndex o2) {
                return o1.getDuration().compareTo(o2.getDuration());
            }
        });

        ArrayList<ArrayList<Integer>> assignedTasks= new ArrayList<>();
        for(int i=0; i<k; i++){
            ArrayList<Integer> currentWorkerTask = new ArrayList<>(Arrays.asList(taskWithIndices[i].getIndex() , taskWithIndices[tasks.size()-1-i].getIndex()));
            assignedTasks.add(currentWorkerTask);
        }
        return assignedTasks;
    }

    public static void main(String[] args) {
        int k = 3;
        ArrayList<Integer> tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        ArrayList<ArrayList<Integer>> actual = new TaskAssignment().taskAssignment(k, tasks);
        System.out.println(Arrays.deepToString(actual.toArray()));
        Utils.assertTrue(expected.equals(actual));
    }

}
