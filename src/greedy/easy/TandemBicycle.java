package greedy.easy;

import util.Utils;

import java.util.Arrays;

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int totalSpeed=0;
        if(fastest){
            for(int i=0; i<redShirtSpeeds.length; i++){
                totalSpeed += Math.max(redShirtSpeeds[i] , blueShirtSpeeds[redShirtSpeeds.length-i-1]);
            }
        } else {
            for(int i=0; i< redShirtSpeeds.length; i++)
                totalSpeed += Math.max(redShirtSpeeds[i],blueShirtSpeeds[i]);
        }
        return totalSpeed;
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        int actual = new TandemBicycle().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        Utils.assertTrue(expected == actual);
    }
}
