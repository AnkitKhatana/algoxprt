package greedy.easy;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean blueAhead = blueShirtHeights.get(0) < redShirtHeights.get(0);
        boolean redAhead = !blueAhead;
        for(int i=1; i<redShirtHeights.size(); i++) {
            if(blueAhead && redShirtHeights.get(i) <= blueShirtHeights.get(i))
                return false;
            if(redAhead && blueShirtHeights.get(i) <= redShirtHeights.get(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights);
        Utils.assertTrue(expected == actual);
    }

}
