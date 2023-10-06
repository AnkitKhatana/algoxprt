package greedy.medium;

import util.Utils;

public class ValidStartingCity {

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int validEndCity = 0;
        int runningDeficitSum = 0;
        int highestNegativeDeficit = Integer.MAX_VALUE;
        for(int i=0; i<distances.length; i++){
            runningDeficitSum += fuel[i]*mpg - distances[i];
            if(highestNegativeDeficit > runningDeficitSum){
                validEndCity = i;
                highestNegativeDeficit = runningDeficitSum;
            }
        }
        return (validEndCity+1) % distances.length;
    }

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        int actual = new ValidStartingCity().validStartingCity(distances, fuel, mpg);
        Utils.assertTrue(expected == actual);
    }
}
