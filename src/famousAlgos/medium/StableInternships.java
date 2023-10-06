package famousAlgos.medium;

import util.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StableInternships {

    public ArrayList<Integer> getInternsWithLowestPref(int[] internsPref , int[] internStatus) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> internsWithLowestPref = new ArrayList<>();

        for(int i=0; i<internsPref.length; i++){
            if(min > internsPref[i] && internStatus[i] == 0){
                min = internsPref[i];
            }
        }

        for(int i=0; i<internsPref.length; i++){
            if(internsPref[i] == min && internStatus[i] == 0)
                internsWithLowestPref.add(i);
        }

        return internsWithLowestPref;
    }

    public int[][] stableInternships(int[][] interns, int[][] teams) {
        // Write your code here.
        int[][] pairs = new int[interns.length][2];
        int[][] internPrefEachTeam = new int[interns.length][interns.length];
        int[][] teamPrefEachIntern = new int[teams.length][teams.length];

        for(int i=0; i<interns.length; i++){
            for(int j=0; j< interns.length; j++){
                internPrefEachTeam[interns[i][j]][i] = j;
            }
        }

        for(int i=0; i<teams.length; i++){
            for(int j=0; j<teams.length; j++){
                teamPrefEachIntern[teams[i][j]][i] = j;
            }
        }

        int[] internStatus = new int[interns.length];

        for(int i=0; i<interns.length; i++){
            ArrayList<Integer> internsHavingLowestPrefForThisTeam = getInternsWithLowestPref(internPrefEachTeam[i] , internStatus);
            if(internsHavingLowestPrefForThisTeam.size() == 1) {
                pairs[i][0] = internsHavingLowestPrefForThisTeam.get(0);
                pairs[i][1] = i;
                internStatus[internsHavingLowestPrefForThisTeam.get(0)] = -1;
            } else {
                int teamPrefers = internsHavingLowestPrefForThisTeam.get(0);
                for(Integer intern : internsHavingLowestPrefForThisTeam) {
                    if(teamPrefEachIntern[teamPrefers][i] > teamPrefEachIntern[intern][i])
                        teamPrefers = intern;
                }
                pairs[i][0] = teamPrefers;
                pairs[i][1] = i;
                internStatus[teamPrefers] = -1;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[][] interns = new int[][] {{0, 1}, {1, 0}};
        int[][] teams = new int[][] {{1, 0}, {1, 0}};
        int[][] expected = new int[][] {{0, 0}, {1, 1}};
        int[][] actual = new StableInternships().stableInternships(interns, teams);
        Utils.assertTrue(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                }
            }
            Utils.assertTrue(containsMatch);
        }
    }
}
