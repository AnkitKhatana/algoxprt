package stacks.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class SunsetViews {

    public ArrayList<Integer> sunsetViewsBackward(int[] buildings){
        int max_height = -1;
        Stack<Integer> outputStack = new Stack<>();
        ArrayList<Integer> outputArray = new ArrayList<>();
        for(int i=buildings.length-1;i>=0;i--){
            if(buildings[i] > max_height) {
                outputStack.push(i);
                max_height = buildings[i];
            }
        }
        while(!outputStack.isEmpty()){
            outputArray.add(outputStack.pop());
        }
        return outputArray;
    }

    public ArrayList<Integer> sunsetViewsForward(int[] buildings){
        int max_height=-1;
        ArrayList<Integer> outputArray = new ArrayList<>();
        for(int i=0;i< buildings.length; i++){
            if(buildings[i] > max_height){
                outputArray.add(i);
                max_height=buildings[i];
            }
        }
        return outputArray;
    }
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        if(direction.equals("WEST"))
            return sunsetViewsForward(buildings);
        else
            return  sunsetViewsBackward(buildings);
    }

    public static void main(String[] args) {
        int[] buildings = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        int[] buildings1 = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
        String direction1 = "WEST";
        System.out.println((new SunsetViews().sunsetViews(buildings,direction)));
        System.out.println((new SunsetViews().sunsetViews(buildings1,direction1)));
    }
}
